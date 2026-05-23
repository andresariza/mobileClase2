package com.example.estadosjetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.roundToLong
import kotlin.text.toDoubleOrNull

class FormTaskViewModel: ViewModel() {

    var inputValue by mutableStateOf("0")
    var inputPercentage  by mutableStateOf("0")
    //var result  by mutableStateOf(0.0)
    var switchRound by mutableStateOf(false)

    val result: String
        get(){
            var cantidad = inputValue.toDoubleOrNull() ?: 0.0;
            var percentage = inputPercentage.toDoubleOrNull() ?: 0.0;

            var result = cantidad * percentage / 100;

            if(switchRound) {
                result = result.roundToLong().toDouble()
            } else {
                result = cantidad * percentage / 100
            }
            return result.toString();
        }

    fun updateCantidad(text: String) {
        inputValue = text
    }

    fun updatePercentage(text: String) {
        inputPercentage = text
    }

    fun updateSwitchRoud(round: Boolean) {
        switchRound = round
    }

}