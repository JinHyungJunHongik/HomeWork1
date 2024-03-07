package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.test1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        var Screen = binding.txCalculate
        var numberBuffer1: String = ""
        var polyCalculus: String = ""
        var BracketCalCulus: String = ""
        var BracketCalculator: Calculator = Calculator("Bracket")
        val operatorList = listOf<Char>(
            '+', '-', 'x', '÷'
        )
        val Priority = listOf<Char>(
            'x', '÷'
        )
        val Later = listOf<Char>(
            '+','-'
        )
        var isCalClicked = false
        var isBracketCreate = false
        var TestCalculator: Calculator = Calculator("MyCalculator")
        val NumList = listOf<TextView>(
            binding.btn0,
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9,
        )
        Screen.text = "0"
        //숫자 버튼 입력 시 실행 되는 함수, 시작은 0
        for(i in 0..9){
            NumList[i].setOnClickListener {
                if(isCalClicked == true){
                    polyCalculus = ""
                    Screen.text = i.toString()
                    TestCalculator.operater = ' '
                    TestCalculator.operand_1 = ""
                    TestCalculator.operand_2 = ""
                    isCalClicked == false
                }
                    if (Screen.text == "0") {
                        Screen.text = i.toString()
                    } else {
                        numberBuffer1 = Screen.text.toString()
                        Screen.text = numberBuffer1 + i.toString()
                    }
                if(isBracketCreate == false) {
                    polyCalculus = polyCalculus + i.toString()
                }

                }
            }

        //부호 버튼 입력 시 실행되는 함수, 부호가 연달아 입력 시 마지막으로 입력한 부호로 변환되게 설정
        binding.btnPlus.setOnClickListener {
            isCalClicked = false
            if (isBracketCreate == true) {
                var text = Screen.text.toString()
                if (operatorList.contains(text[text.length - 1])) {
                    text = text.substring(0, polyCalculus.length - 1)
                    text = text + '+'
                    Screen.text = text
                } else {
                    text = text + '+'
                    Screen.text = text
                }
            } else {
                if (operatorList.contains(polyCalculus[polyCalculus.length - 1])) {
                    var text = Screen.text.toString()
                    text = text.substring(0,text.length-1)
                    polyCalculus = polyCalculus.substring(0, polyCalculus.length - 1)
                    polyCalculus = polyCalculus + '+'
                    text = text + '+'
                    Screen.text = text
                } else {
                    var text = Screen.text.toString()
                    polyCalculus = polyCalculus + '+'
                    text = text + '+'
                    Screen.text = text
                }
                Log.d("확인", "$polyCalculus")
            }
        }
        binding.btnMin.setOnClickListener {
            isCalClicked = false
            if (isBracketCreate == true) {
                var text = Screen.text.toString()
                if (operatorList.contains(text[text.length - 1])) {
                    text = text.substring(0, polyCalculus.length - 1)
                    text = text + '-'
                    Screen.text = text
                } else {
                    text = text + '-'
                    Screen.text = text
                }
            } else {
                if (operatorList.contains(polyCalculus[polyCalculus.length - 1])) {
                    var text = Screen.text.toString()
                    text = text.substring(0,text.length-1)
                    polyCalculus = polyCalculus.substring(0, polyCalculus.length - 1)
                    polyCalculus = polyCalculus + '-'
                    text = text + '-'
                    Screen.text = text
                } else {
                    var text = Screen.text.toString()
                    polyCalculus = polyCalculus + '-'
                    text = text + '-'
                    Screen.text = text
                }
                Log.d("확인", "$polyCalculus")
            }
        }
        binding.btnMul.setOnClickListener {
            isCalClicked = false
            if (isBracketCreate == true) {
                var text = Screen.text.toString()
                if (operatorList.contains(text[text.length - 1])) {
                    text = text.substring(0, polyCalculus.length - 1)
                    text = text + 'x'
                    Screen.text = text
                } else {
                    text = text + 'x'
                    Screen.text = text
                }
            } else {
                if (operatorList.contains(polyCalculus[polyCalculus.length - 1])) {
                    var text = Screen.text.toString()
                    text = text.substring(0,text.length-1)
                    polyCalculus = polyCalculus.substring(0, polyCalculus.length - 1)
                    polyCalculus = polyCalculus + 'x'
                    text = text + 'x'
                    Screen.text = text
                } else {
                    var text = Screen.text.toString()
                    text = text + 'x'
                    polyCalculus = polyCalculus + 'x'
                    Screen.text = text
                }
                Log.d("확인", "$polyCalculus")
            }
        }
        binding.btnDiv.setOnClickListener {
            isCalClicked = false
            if (isBracketCreate == true) {
                var text = Screen.text.toString()
                if (operatorList.contains(text[text.length - 1])) {
                    text = text.substring(0, polyCalculus.length - 1)
                    text = text + '÷'
                    Screen.text = text
                } else {
                    text = text + '÷'
                    Screen.text = text
                }
            } else {
                if (operatorList.contains(polyCalculus[polyCalculus.length - 1])) {
                    var text = Screen.text.toString()
                    text = text.substring(0, polyCalculus.length - 1)
                    polyCalculus = polyCalculus.substring(0, polyCalculus.length - 1)
                    polyCalculus = polyCalculus + '÷'
                    text = text + '÷'
                    Screen.text = text
                } else {
                    var text = Screen.text.toString()
                    text = text + '÷'
                    polyCalculus = polyCalculus + '÷'
                    Screen.text = text
                }
            }
        }
        // 계산 결과를 도출하는 함수
        // 곱하기 나누기 연산자를 찾아 먼저 계산한 후 계산한 값들을 순서에 맞게 졍렬하고 문자열로 합침
        // 합친 문자열이 하나의 결괏값이 될 때까지 루프 돌리기
        // 계산은 한번에 이루어지지않고 나누어서 이루어짐

        fun inputCalculus(str: String, cal: Calculator) {
            var numberList = mutableListOf<String>()
            var optList = mutableListOf<Char>()
            var orderList = mutableListOf<Int>()
            var numUsed = mutableListOf<Int>()
            var CalString = ""
            var idxList = mutableListOf<Int>()
            var isNewOpEmpty = false
            //계산 관련 함수 싱글 코어 계산기, 클래스 이용
            fun Cal(calulator: Calculator) {
                var result: String
                val Add: AddOperation = AddOperation(calulator.operand_1, calulator.operand_2)
                val Sub: SubtractOperation =
                    SubtractOperation(calulator.operand_1, calulator.operand_2)
                val Mul: MultiplyOperation =
                    MultiplyOperation(calulator.operand_1, calulator.operand_2)
                val Div: DivideOperation = DivideOperation(calulator.operand_1, calulator.operand_2)
                when (calulator.operater) {
                    '+' -> {
                        result = Add.operation()
                    }

                    '-' -> {
                        result = Sub.operation()
                    }

                    'x' -> {
                        result = Mul.operation()
                    }

                    else -> {
                        result = Div.operation()

                    }
                }
                calulator.operand_1 = result
                calulator.operater = ' '
            }


            fun sortedString(str: String){
                var text: String = ""
                for (i in 0..str.length - 1) {
                    if (operatorList.contains(str[i]) == false && (i < str.length - 1)) {
                        text += str[i]
                    }
                    if (operatorList.contains(str[i]) == false && (i == str.length - 1)) {
                        text += str[i]
                        numberList.add(text)
                    } else if (operatorList.contains(str[i]) == true) {
                        numberList.add(text)
                        text = ""
                        optList.add(str[i])
                    }
                }

                for(i in 0..numberList.size-1){
                    numUsed.add(i,0)
                }

                for(i in 0..optList.size-1){
                    if(Priority.contains(optList[i])){
                        orderList.add(i)
                    }
                }
                Log.d("확인", "${numberList},${optList}, ${orderList}")
            }

            sortedString(str)

            while(orderList.isEmpty() == false){
                for(i in 0..orderList.size-1){
                    if(i == 0){
                        var idx = orderList[i]
                        idxList.add(idx)
                        Log.d("계산 과정1", "${numberList[idx]},${numberList[idx+1]}")
                        cal.operand_1 = numberList[idx]
                        cal.operand_2 = numberList[idx+1]
                        cal.operater = optList[idx]
                        numUsed.set(idx, 1)
                        numUsed.set(idx+1, 1)
                        Cal(cal)
                        numberList.set(idx+1, cal.operand_1)
                    }
                    else{
                        var idx = orderList[i]
                        idxList.add(idx)
                        if(numUsed[idx] == 1){
                            cal.operand_2 = numberList[idx+1]
                            cal.operater = optList[idx]
                            Log.d("계산 과정2", "${cal.operand_1},${cal.operand_2}")
                            Cal(cal)
                            numUsed.set(idx+1,1)
                            numberList.set(idx+1, cal.operand_1)
                        }
                        else {
                            cal.operand_1 = numberList[idx]
                            cal.operand_2 = numberList[idx+1]
                            Log.d("계산 과정3", "${cal.operand_1},${cal.operand_2}")
                            cal.operater = optList[idx]
                            numUsed.set(idx, 1)
                            numUsed.set(idx+1, 1)
                            Cal(cal)
                            numberList.set(idx+1, cal.operand_1)
                        }
                    }
                }

                for(i in 0..idxList.size-1){
                    numberList.set(idxList[i], "^")
                    optList.set(idxList[i], '@')
                }

                Log.d("꼼수", "${numberList},${optList}")
                var NewNumList = numberList.filterNot { it == "^" }.map{it}
                var NewOpList = optList.filterNot { it == '@' }.map{it}


                if(NewOpList.isEmpty() ){
                    isNewOpEmpty = true
                    break
                }

                for(i in 0..NewOpList.size-1){
                    if(i == 0){
                       CalString = NewNumList[i] + NewOpList[i] + NewNumList[i+1]
                    }
                    else{
                        CalString = CalString + NewOpList[i] + NewNumList[i+1]
                    }
                }
                Log.d("문자 재정렬 확인", "${CalString}")
                numberList.clear()
                optList.clear()
                orderList.clear()
                numUsed.clear()
                idxList.clear()
                sortedString(CalString)
                cal.operand_1 = ""
                cal.operand_2 = ""
                cal.operater = ' '
            }

            if(isNewOpEmpty == false) {
                for (i in 0..optList.size - 1) {
                    if (i == 0) {
                        cal.operand_1 = numberList[i]
                        cal.operand_2 = numberList[i + 1]
                        cal.operater = optList[i]
                        Cal(cal)
                    } else {
                        cal.operand_2 = numberList[i + 1]
                        cal.operater = optList[i]
                        Cal(cal)
                    }
                }
            }
            if(str == polyCalculus) {
                polyCalculus = cal.operand_1
            }
            else if(str == BracketCalCulus){
                BracketCalCulus = cal.operand_1
            }

        }
        //나머지 버튼 구현x
        binding.btnMod.setOnClickListener {
            Log.d("확인", "${BracketCalCulus}")
            Log.d("괄호 안 계산 확인", "${BracketCalculator.operand_1}")
            Log.d("입력 확인", "${polyCalculus}")
        }
        //괄호 버튼 오류가 많습니다..
        //현재 괄호 안에 괄호, 괄호 안에 계산 결괏값이 음수일경우 앱이 다운됩니다 ㅠㅠ
        //괄호 계산용 계산기 오브젝트 추가하기
        var isLeftBracketUsed = false //
        // 왼쪽 오른쪽 괄호 구분 사용을 위해 설정
        var isBracketComplete = false
        var start: Int = 0
        var last: Int = 0
        binding.btnBracket.setOnClickListener {
            isBracketCreate = true
            var text = Screen.text.toString()
            if(isLeftBracketUsed == false && operatorList.contains(text[text.length-1]) == false){
                text = text+'x'+'('
                Log.d("g", "${text.length}")
                start = text.length
                Screen.text = text
                isLeftBracketUsed = true
            }
            else if(isLeftBracketUsed == false && operatorList.contains(text[text.length-1]) == true){
                text = text+'('
                Log.d("g1", "${text.length}")
                start = text.length
                Screen.text = text
                isLeftBracketUsed = true
            }
            else if(isLeftBracketUsed == true && operatorList.contains(text[text.length-1]) == true){
                text = text+'('
                Log.d("g2", "${text.length}")
                start = text.length
                Screen.text = text
                isLeftBracketUsed = true
            }
            else if(isLeftBracketUsed == true && operatorList.contains(text[text.length-1]) == false){
                text = text+')'
                Log.d("g3", "${text.length}")
                last = text.length - 2
                Screen.text = text
                isLeftBracketUsed = false
                isBracketComplete = true
            }

            if(isBracketComplete == true){
                text = Screen.text.toString()
                BracketCalCulus = text.substring(start, last+1)
                inputCalculus(BracketCalCulus, BracketCalculator)
                polyCalculus = polyCalculus + BracketCalCulus
                isBracketComplete = false
                isBracketCreate = false
                BracketCalculator.operand_1 = ""
                BracketCalculator.operand_2 = ""
                BracketCalculator.operater = ' '
                start = 0
                last = 0
                BracketCalCulus = ""
            }
        }
        //소숫점 붙이기
        binding.btnFloor.setOnClickListener {
            if (polyCalculus.length == 0 || operatorList.contains(polyCalculus[polyCalculus.length - 1]) == false) {
                if (Screen.text == "0") {
                    Screen.text = "0"+"."
                    polyCalculus = Screen.text.toString()
                } else {
                    Screen.text = "${polyCalculus}."
                    polyCalculus = Screen.text.toString()
                }
            }
        }
        //계산 결과 도출하는 '=' 버튼
        binding.btnCal.setOnClickListener {
            inputCalculus(polyCalculus, TestCalculator)
            isCalClicked = true
            Screen.text = TestCalculator.operand_1
        }
        //초기화 버튼
        binding.btnClear.setOnClickListener {
            polyCalculus = ""
            Screen.text = "0"
            TestCalculator.operater = ' '
            TestCalculator.operand_1 = ""
            TestCalculator.operand_2 = ""
            isCalClicked = false
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}