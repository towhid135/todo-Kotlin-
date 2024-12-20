package com.example.todo.feature_todo.presentation.todo_list

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.R
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import com.example.todo.feature_todo.presentation.todo_list.components.DrawerOptions
import com.example.todo.feature_todo.presentation.todo_list.components.TodoItemCard
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodoListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    val backgroundImage = if(isPortrait){
        R.drawable.background_portrait
    }else{
        R.drawable.background_landscape
    }

    LaunchedEffect(key1 = true) {
        viewModel.getTodoItems()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(state.todoItemOrder, onOrderChange = {order ->
            viewModel.onEvent(TodoListEvent.Sort(order))
        }) }
    ) {
        Scaffold(
            floatingActionButton = {
                AddTodoButton(onAddButtonPress = {
                    //TODO: Navigate to Add Todo Screen
                })
            },
            topBar = { TodoListScreenTopAppBar { scope.launch { drawerState.open() } }}
        ) { padding ->
            TodoItemList(
                backgroundImage = painterResource(id = backgroundImage),
                todoItems = state.todoItems,
                isLoading = state.isLoading,
                error = state.error
            )

        }
    }
}

@Composable
fun DrawerContent(todoItemOrder:TodoItemOrder,onOrderChange:(TodoItemOrder) -> Unit){
    Box(modifier = Modifier.fillMaxWidth(0.65f)){
        ModalDrawerSheet {
            Text(
                text = TodoListStrings.SORT_BY,
                modifier = Modifier.padding(16.dp),
                fontSize = 34.sp,
                lineHeight = 18.sp
            )
            HorizontalDivider()
            DrawerOptions(
                todoItemOrder = todoItemOrder,
                onOrderChange = onOrderChange
            )
        }
    }
}

@Composable
fun AddTodoButton(onAddButtonPress:() -> Unit){
    FloatingActionButton(
        onClick = onAddButtonPress,
        shape = FloatingActionButtonDefaults.shape,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ContentDescriptions.ADD_TODO
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreenTopAppBar(onMenuButtonPress: () -> Unit){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = TodoListStrings.TODO_LIST,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        navigationIcon = {},
        actions = {
            IconButton(onClick = onMenuButtonPress) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = ContentDescriptions.SORTING_MENU)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
            scrolledContainerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    )
}

@Composable
fun TodoItemList(backgroundImage:Painter,todoItems:List<TodoItem>,isLoading:Boolean=false,error:String? = null){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Image(
            painter = backgroundImage,
            contentDescription = ContentDescriptions.BACKGROUND_IMAGE,
            alignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 12.dp)
                    .padding(top = 64.dp)
            ) {
                items(todoItems){ todoItem ->
                    TodoItemCard(
                        todo=todoItem,
                        modifier = Modifier.fillMaxSize()
                            .padding(4.dp),
                        onDeleteClick = {},
                        onArchiveClick = {},
                        onCompleteClick = {},
                        onCardClick = {}
                        )
                }
            }
            if(isLoading){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.semantics {
                            this.contentDescription = ContentDescriptions.LOADING_INDICATOR
                        }
                    )
                }
            }
            if(error != null){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = error,
                        fontSize = 30.sp,
                        lineHeight = 36.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TodoItemListPreview() {
    val sampleTodoItems = listOf(
        TodoItem(id = 1, title = "Sample Todo 1", description = "Description 1", timestamp = System.currentTimeMillis(), completed = false, archived = false),
        TodoItem(id = 2, title = "Sample Todo 2", description = "Description 2", timestamp = System.currentTimeMillis(), completed = true, archived = false),
        TodoItem(id = 3, title = "Sample Todo 3", description = "Description 3", timestamp = System.currentTimeMillis(), completed = false, archived = true)
    )

    val painter = painterResource(id = R.drawable.background_portrait)

    TodoItemList(
        backgroundImage = painter,
        todoItems = sampleTodoItems
    )
}

@Preview
@Composable
fun TodoListScreenTopAppBarPreview(){
    TodoListScreenTopAppBar(onMenuButtonPress = {})
}

@Preview
@Composable
fun AddTodoPreview(){
    AddTodoButton(onAddButtonPress = {})
}



