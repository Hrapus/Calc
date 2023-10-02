package com.example.calc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcFragmentViewModel : ViewModel() {

    private val _inputUser = MutableLiveData("")
    val inputUser: LiveData<String> = _inputUser

    private var _a: Double? = null
    private var _b: Double? = null
    private var operator: String? = null

    private var _result: Double? = null


    fun setInputUser(digit: String) {
        _inputUser.value += digit

        if (digit == "=") {
            _inputUser.value?.let { parseStringToDouble(it) }
            calculate()
            showRes()
        }
        if (digit == "s") {
            _inputUser.value = ""
        }
    }


    private fun showRes() {
        _inputUser.value = _result.toString()
    }

    private fun calculate() {
        when (operator) {
            "/" -> _result = _b?.let { _a?.div(it) }
            "*" -> _result = _b?.let { _a?.times(it) }
            "-" -> _result = _b?.let { _a?.minus(it) }
            "+" -> _result = _b?.let { _a?.plus(it) }
        }
    }

    private fun parseStringToDouble(x: String) {

        val numberPattern = "[0-9.]+".toRegex()
        val operatorPattern = "[+*/-]".toRegex()

        val numbers = numberPattern.findAll(_inputUser.value!!)
            .map { it.value }
            .toList()

        _a = numbers[0].toDouble()
        _b = numbers[1].toDouble()

        operator = operatorPattern.findAll(_inputUser.value!!)
            .map { it.value }
            .toList()[0]


    }
}