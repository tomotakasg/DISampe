package com.example.disample.vm

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.disample.repository.QiitaResponse
import com.example.disample.usecase.TopAction
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
        private val topAction: TopAction,
        @Assisted private val savedState: SavedStateHandle  //@Assi
) : ViewModel() {
    // TODO: Implement the ViewModel
    private var resultString: MutableLiveData<QiitaResponse> = MutableLiveData()

    fun getResult(): LiveData<QiitaResponse> = resultString

    fun request() {
        viewModelScope.launch {
            topAction.invoke(viewModelScope, resultString)
        }
    }
}