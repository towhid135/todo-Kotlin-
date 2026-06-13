# Copilot Instructions - Todo (MVVM + Clean Architecture)

This document collects project-wide guidance and best practices tailored to this repository. Follow these rules to keep the codebase consistent, testable, and maintainable while using MVVM + Clean Architecture.

High-level plan
- Short checklist of what this file covers.
- Architecture & folder conventions you should follow.
- Coding rules and naming conventions (ViewModel, UseCases, Repos, DTOs, Mappers).
- API integration pattern and the recommended usage of `collectUseCaseFlow` (tracked from `HomeViewModel`).
- ViewModel event / side-effect handling rules (no plain lambdas in `onEvent`).
- UI best practices (Android Developers guide highlights) and where UI-only logic should live.
- Testing, linting and tooling suggestions.

Checklist (what to follow in new/changed code)
- [ ] Keep strict Clean Architecture layers: data, domain, presentation.
- [ ] Use DTO <-> domain mappers (extension functions named `toDomain()` / `toDto()`).
- [ ] For API flows, use the `safeApiFlow` + `collectUseCaseFlow` trigger pattern.
- [ ] In `ViewModel.onEvent`, avoid anonymous lambdas — forward to named handler functions.
- [ ] Use a `_sideEffect` SharedFlow/MutableSharedFlow for one-off UI actions (navigation, snackbars, dialogs).
- [ ] Keep navigation & UI actions in UI composables; only emit side-effects from ViewModel.
- [ ] Write unit tests for UseCases and ViewModels (fake repo implementations).

1) Project & Architecture
- Follow Clean Architecture: three main layers.
  - `feature_<feature>/data` — network + local + mapper + repository implementation.
  - `feature_<feature>/domain` — models (domain), repository interfaces, use-cases, domain exceptions.
  - `feature_<feature>/presentation` — Compose screens, ViewModels, UI state, events and side-effects.
- Each feature module should be mostly self-contained and expose only domain models to other layers.
- Keep the app module thin (wiring, DI with Hilt, navigation hosts).

Recommended folder structure (example: `feature_todo`)
- data/
  - remote/ (api interfaces, dtos)
  - local/ (room entities, dao)
  - repo/ (repository implementation)
  - mapper/ (dto <-> domain mapping extensions)
- domain/
  - model/ (domain models only)
  - repo/ (interfaces)
  - use_case/ (single responsibility use-cases)
  - util/ (domain-level utilities)
- presentation/
  - screenname/
    - view/ (composables)
    - view_model/ (ViewModel + state + events)

2) DTOs, Domain models and Mappers
- All network models belong to `data/remote/dto` and are suffixed with `Dto`.
- Domain models (used across app and UI) live in `domain/model` and have no platform-specific annotations.
- Provide extension mappers in `data/mapper` or `data/mapper/XXMapper.kt`.
  - Naming: `fun TodoItemDto.toDomain(): TodoItem` and `fun TodoItem.toDto(): TodoItemDto`.
- Keep mapping logic explicit; do not leak network-only fields into domain.
- Perform conversions that matter for correctness here (e.g. date string -> ZonedDateTime using `DateTimeFormatter.ISO_INSTANT`).

3) API integration & usage approach (best practice)
- Centralize HTTP response parsing & error handling with `safeApiFlow` (or similar) in `core.util`.
- Use repository functions that return `Flow<ApiResult<T>>` for remote calls. UseCases should be small wrappers over repository calls.

Track this pattern (from `HomeViewModel`) and follow it everywhere:

collectUseCaseFlow(
    trigger = _triggerGetAllTodos,
    useCase = { userId -> todoUseCases.getAllTodosUseCase(userId) },
    onLoading = ::onGetAllTodosLoading,
    onSuccess = ::onSuccessGetAllTodos,
    onError = ::onGetAllTodosError
)

- `trigger` should be a lightweight SharedFlow/MutableSharedFlow with replay 1 helper (you have `sharedFlowWithReplay1`).
- `useCase` must be a named reference or lambda that calls the UseCase operator function.
- `onLoading`, `onSuccess`, `onError` should be ViewModel functions (not anonymous lambdas) to keep stack traces and make testing easy.
- Keep the mapper inside repository implementation — convert DTOs to domain models before emitting success.

4) ViewModel rules & side effects

- ViewModel must own UI state. Use Kotlin `StateFlow` for screen state (not `mutableStateOf`).

- Internal state: use `MutableStateFlow` (private) and the `update` extension to change properties atomically.
  - Example pattern:
    - `private val _state = MutableStateFlow(HomeScreenState())`
    - `val state: StateFlow<HomeScreenState> = _state.asStateFlow()`
  - Update state with the atomic `update` extension:
    - `_state.update { it.copy(isLoading = true) }`

- ViewModel state data class rules:
  - The state must be a Kotlin `data class` and all properties should be declared as `val`.
  - Mutations are performed by creating a new instance via `copy()` inside `_state.update { ... }`.
  - Keep the state flattened enough to avoid deeply nested mutable structures; prefer small nested data classes for complex pieces.

- Treat auth / mutable values as part of ViewModel state (common guideline):
  - Do NOT declare mutable fields like `private var authToken: String? = null` directly inside a ViewModel.
  - Instead add such values to the state data class (e.g. `data class HomeScreenState(val authToken: String? = null, ...)`) and update via `_state.update { it.copy(authToken = token) }`.
  - Rationale: keeping tokens and other mutable UI-related values in the state ensures a single source of truth, atomic updates, easier testing, and predictable Compose/Flow interop.

- Migration note: wherever you currently use `mutableStateOf(...)` for ViewModel-owned screen state, replace it with `MutableStateFlow(...)` and update callers. For example, replace:
  - `private val _state = mutableStateOf(HomeScreenState())`
  - `val state: State<HomeScreenState> = _state`
  With:
  - `private val _state = MutableStateFlow(HomeScreenState())`
  - `val state: StateFlow<HomeScreenState> = _state.asStateFlow()`

- Rationale: `MutableStateFlow` provides `update`, predictable snapshots, easier testing, and better interop with non-Compose consumers while still working well with Compose via `collectAsState()`.

- Event handling:
  - `fun onEvent(event: HomeScreenEvent)` should be a single entry-point that only delegates to small, named private functions. No inline or anonymous lambdas capturing UI logic.
  - Example naming: `private fun handleGetAllTodos()` or `private fun onChangeTitle(title: String)`.
  - This makes unit testing and stack traces easier.

- Side effects:
  - Provide a `_sideEffect: MutableSharedFlow<UiEvent>` in ViewModel and expose `sideEffect: SharedFlow<UiEvent>`.
  - UiEvent should be a sealed class with one-off actions (Navigate, ShowSnackbar, OpenDialog). Example:
    - `sealed class UiEvent { data class Navigate(val route: String): UiEvent(); data class ShowSnackbar(val msg:String): UiEvent() }`
  - Emit side effects from ViewModel: `_sideEffect.tryEmit(UiEvent.Navigate(...))`.
  - In Composables, collect side effects inside a `LaunchedEffect(key1 = Unit)` and `collect` (or `collectLatest`) the `sideEffect` and `when` over events to perform navigation/modal presentation.
  - Keep navigation and modal show/hide logic exclusively in UI layer — ViewModel only emits events.

- Avoid putting Android framework types in domain models (Context, AndroidX classes). Use qualifiers and Hilt for needed platform dependencies in data/presentation layers.

5) Error handling & coroutine patterns
- Inject a `@IoDispatcher` CoroutineDispatcher into repositories and ViewModels for background work.
- Use a `CoroutineExceptionHandler` in ViewModel where appropriate for unexpected exceptions and to update UI state.
- For network flows, return typed `ApiResult` and handle errors with `onError` callbacks provided to `collectUseCaseFlow`.
- Prefer `viewModelScope.launch(dispatcher + errorHandler)` for IO-bound launches where you modify state from callback results.

6) Naming conventions
- UseCase classes: `GetAllTodosUseCase`, `CreateTodoUseCase` and the aggregator `TodoUseCases`.
- Repos: interface `HomeRepo`, implementation `HomeRepoImpl`.
- DTO names: `TodoItemDto`, `CreateTodoRequestDto`.
- Mappers: `toDomain()` / `toDto()` extension functions in `data/mapper`.
- ViewModel event handlers: `onPressAddTodo()`, `onSelectPriority(priority: Priority)` or `handlePressAddTodo()`; pick one pattern and be consistent. I suggest `onXxx` for event handlers.

7) UI implementation best-practices (Android Developers highlights)
- Use unidirectional data flow: UI reads immutable `state` and renders; events go to `ViewModel.onEvent`.
- Prefer `State<T>` / `StateFlow` with Compose and use `collectAsState()` or `observeAsState()` correctly.
- Expose ViewModel state in Composables using lifecycle-aware collection. Example pattern:
  - `val uiState by viewModel.state.collectAsStateWithLifecycle()`
  - Use `uiState` to render the screen and pass events back to `viewModel.onEvent(...)`.
- Notes:
  - `collectAsStateWithLifecycle()` is part of `androidx.lifecycle:lifecycle-runtime-compose`. Add the dependency if missing and import `import androidx.lifecycle.compose.collectAsStateWithLifecycle`.
  - Using the `by` delegate gives you an immutable snapshot (recommended): `val uiState by ...`.
  - This ensures the UI only collects when the composable is in an appropriate lifecycle state (avoids leaks and unnecessary work).
- Keep recomposition-friendly APIs: avoid expensive work inside composables; hoist state up; use remember/derivedStateOf where appropriate.
- Use `LaunchedEffect` to collect one-off flows like `_sideEffect` and `SnapshotFlow` for snapshot-based side effects.
- Avoid performing navigation inside ViewModel — emit events and let UI handle navigation with NavController.
- Follow accessibility: contentDescription for images, proper roles for interactive elements, contrast and text scaling.

8) Testing guidance
- Unit tests
  - Use fake implementations of `HomeRepo` when testing `GetAllTodosUseCase` and ViewModel.
  - Use `TestDispatcher` (kotlinx-coroutines-test) and `StandardTestDispatcher` to control coroutines. Call `runTest {}`.
  - Assert `state` changes and that `_sideEffect` emits expected events.
- Integration / Instrumented tests
  - Compose UI tests should verify that when the ViewModel emits a navigation side effect the NavController receives the action.

9) Linting, formatting & tooling
- Use ktlint / ktlint-gradle and detekt for static analysis.
- Enable `kotlinx.serialization` or Moshi/Gson consistently in `data/remote`.
- CI: run `./gradlew ktlintCheck detekt` and unit tests.

10) Practical notes pulled from this repo (what to change/fix first)
- Where you find `viewModelScope.launch { ... }` that performs IO, switch to `viewModelScope.launch(dispatcher + errorHandler)` for long-running or IO tasks.
- Replace anonymous handlers passed into `collectUseCaseFlow` with named functions (you already use `::onSuccessGetAllTodos`). Continue that style across the project.
- Keep `TodoPreferenceStore` reads in ViewModel but mask `Context` usage behind helpers where possible (or use `@ApplicationContext` injection). Don’t use `Context` in domain layer.
- When converting dates for network, use `DateTimeFormatter.ISO_INSTANT` and store ZonedDateTime in domain models.

11) Example checklist for a new feature or change
- [ ] Create UseCase(s) for business logic.
- [ ] Add repository method in `domain/repo` and implement in `data/repo`.
- [ ] Add DTO(s) in `data/remote/dto` and Mapper(s) to convert to Domain.
- [ ] Make API method in `TodoApi` with path/query annotations.
- [ ] Use `safeApiFlow` in repo and map DTO -> domain before emitting success.
- [ ] In ViewModel, add `MutableSharedFlow` trigger and wire `collectUseCaseFlow` (use named handler functions for onLoading/onSuccess/onError).
- [ ] Emit side-effects using `_sideEffect` for navigation/snackbar.
- [ ] Add unit tests for UseCase(s) and ViewModel handlers.

If anything here is unclear or you want me to add concrete templates (ViewModel event handler template, a sample `collectUseCaseFlow` helper implementation, or mapper templates), ask and I will add them.

Thanks — tell me which part you want scaffolded first (ViewModel template, UseCase template, or mapper examples) and I'll generate the files/code for you.
