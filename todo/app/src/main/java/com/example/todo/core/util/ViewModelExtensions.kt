package com.example.todo.core.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
fun<I,O> ViewModel.collectUseCaseFlow(
    trigger: MutableSharedFlow<I>,
    useCase: (I) -> Flow<ApiResult<O>>,
    onLoading: (() -> Unit)? = null,
    onSuccess: (O) -> Unit,
    onError: ((String) -> Unit)? = null
){
  viewModelScope.launch {
      trigger.flatMapLatest { input ->
          useCase(input)
      }.collect { result ->
          when (result){
              is ApiResult.Loading -> onLoading?.invoke()
              is ApiResult.Error -> onError?.invoke(result.message)
              is ApiResult.Success -> onSuccess(result.data)
          }
      }
  }
}