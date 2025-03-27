package com.hoan.coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val _message = MutableLiveData<Int>()
    val message:LiveData<Int>
        get() = _message

    fun cong(a:Int,b:Int){
        viewModelScope.launch {
            delay(5000L)
            _message.postValue(a + b)
        }
    }

    fun tru(a:Int,b:Int){
        viewModelScope.launch {
            delay(5000L)
            _message.postValue(a - b)
        }
    }
}