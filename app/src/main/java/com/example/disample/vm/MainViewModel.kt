package com.example.disample.vm

import android.app.Application
import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.disample.repository.QiitaResponse
import com.example.disample.usecase.TopAction
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @ViewModelInject constructor(
    private val topAction: TopAction,
    @Assisted private val savedState: SavedStateHandle
) : ViewModel() {
    // TODO: Implement the ViewModel
    private var resultString:MutableLiveData<QiitaResponse> = MutableLiveData()

    fun getResult() :LiveData<QiitaResponse> = resultString
    
    fun request(){
        viewModelScope.launch {
            topAction.invoke(viewModelScope,resultString)
        }
    }
}