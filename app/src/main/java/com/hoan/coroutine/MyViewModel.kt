package com.hoan.coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
   var _message = MutableLiveData<String>()

    val message:LiveData<String>
        get() = _message

    fun updateText(v:String){
        _message.value = v
    }
}