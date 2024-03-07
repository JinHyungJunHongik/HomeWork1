package com.example.test1

import android.widget.TextView

class Calculator(str1: String) {
    var operand_1: String = ""
    var operand_2: String = ""
    var operater: Char = ' '
    init{
    }

    fun Input_operand(Input: String){
        if(operand_1.length == 0){
            operand_1 = Input
        }
        else
            operand_2 = Input
    }
    fun Input_operater(Input: Char) {
        operater = Input
    }
}