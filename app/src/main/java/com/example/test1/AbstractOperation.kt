package com.example.test1

abstract class AbstractOperation(operand_1: String, operand_2: String) {
    var op1 = operand_1
    var op2 = operand_2
    var result: String = ""
    init{}
    abstract fun operation() : String
}

class AddOperation(operand_1: String, operand_2: String) : AbstractOperation(operand_1, operand_2){

    override fun operation() :  String {
        var buffer = op1.toFloat() + op2.toFloat()
        if((buffer * 10 % 10) > 0){
            result = buffer.toString()
        }
        else {
            result = (op1.toFloat() + op2.toFloat()).toInt().toString()
        }
        return result
    }
}
class SubtractOperation(operand_1: String, operand_2: String) : AbstractOperation(operand_1, operand_2){

    override fun operation() :  String {
        var buffer = op1.toFloat() - op2.toFloat()
        var str = buffer.toString()
        if(str[str.length-1] != '0'){
            result = str
        }
        else {
            result = (op1.toFloat() - op2.toFloat()).toInt().toString()
        }
        return result
    }
}
class MultiplyOperation(operand_1: String, operand_2: String) : AbstractOperation(operand_1, operand_2){

    override fun operation() :  String {
        var buffer = op1.toFloat() * op2.toFloat()
        if((buffer * 10 % 10) > 0){
            result = buffer.toString()
        }
        else {
            result = (op1.toFloat() * op2.toFloat()).toInt().toString()
        }
        return result
    }
}
class DivideOperation(operand_1: String, operand_2: String) : AbstractOperation(operand_1, operand_2){

    override fun operation() :  String {
        if(op2.toInt() != 0) {
                var buffer = op1.toFloat() / op2.toFloat()
                if((buffer * 10 % 10) > 0){
                    result = buffer.toString()
                }
                else {
                    result = (op1.toFloat() / op2.toFloat()).toInt().toString()
                }
            }
        return result
        }
    }
