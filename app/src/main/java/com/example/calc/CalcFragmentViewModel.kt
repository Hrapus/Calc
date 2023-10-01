package com.example.calc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcFragmentViewModel : ViewModel() {

    private val _inputUser = MutableLiveData<String>("-")
    val inputUser : LiveData<String> = _inputUser


    fun setInputUser(digit: String){
        _inputUser.value = digit
    }
    fun getInputUser(): String {
        return _inputUser.value.toString()
    }

}