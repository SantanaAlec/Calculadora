package mx.edu.itson.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var first: Int = Integer.MIN_VALUE
    var second: Int = Integer.MIN_VALUE
    var evaluation: Int = 0

    //ENUMS artificiales
    var sign: Int = 0 //0; no sign, 1; +, 2; -, 3; /, 4;*
    var shownResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables del forntend
        //Operations vies
        val process: TextView = findViewById(R.id.tvProcess)
        val numbers: TextView = findViewById(R.id.tvNumbers)

        //Values buttons
        val value_0: Button = findViewById(R.id.btnValue_0)
        val value_1: Button = findViewById(R.id.btnValue_1)
        val value_2: Button = findViewById(R.id.btnValue_2)
        val value_3: Button = findViewById(R.id.btnValue_3)
        val value_4: Button = findViewById(R.id.btnValue_4)
        val value_5: Button = findViewById(R.id.btnValue_5)
        val value_6: Button = findViewById(R.id.btnValue_6)
        val value_7: Button = findViewById(R.id.btnValue_7)
        val value_8: Button = findViewById(R.id.btnValue_8)
        val value_9: Button = findViewById(R.id.btnValue_9)

        //Operators buttons
        val add: Button = findViewById(R.id.btnAdd)
        val sub: Button = findViewById(R.id.btnSub)
        val div: Button = findViewById(R.id.btnDiv)
        val mult: Button = findViewById(R.id.btnMult)

        //Format buttons
        val clear: Button = findViewById(R.id.btnClear)
        val result: Button = findViewById(R.id.btnResult)

        //Numbers
        value_0.setOnClickListener {
            setNumb(0)
        }
        value_1.setOnClickListener {
            setNumb(1)
        }
        value_2.setOnClickListener {
            setNumb(2)
        }
        value_3.setOnClickListener {
            setNumb(3)
        }
        value_4.setOnClickListener {
            setNumb(4)
        }
        value_5.setOnClickListener {
            setNumb(5)
        }
        value_6.setOnClickListener {
            setNumb(6)
        }
        value_7.setOnClickListener {
            setNumb(7)
        }
        value_8.setOnClickListener {
            setNumb(8)
        }
        value_9.setOnClickListener {
            setNumb(9)
        }

        //Operators
        add.setOnClickListener {
            calculate()

            sign = 1

            second = Integer.MIN_VALUE
            numbers.setText("")

            var str: String = first.toString() + " + "
            process.setText(str)
        }
        sub.setOnClickListener {
            calculate()

            sign = 2

            second = Integer.MIN_VALUE
            numbers.setText("")

            var str: String = first.toString() + " - "
            process.setText(str)
        }
        div.setOnClickListener {
            calculate()

            sign = 3

            second = Integer.MIN_VALUE
            numbers.setText("")

            var str: String = first.toString() + " / "
            process.setText(str)
        }
        mult.setOnClickListener {
            calculate()

            sign = 4

            second = Integer.MIN_VALUE
            numbers.setText("")

            var str: String = first.toString() + " * "
            process.setText(str)
        }

        //Format
        result.setOnClickListener {
            calculate()
            shownResult = true
        }
        clear.setOnClickListener {
            clean()
        }
    }

    fun setNumb(number: Int) {
        val numbers: TextView = findViewById(R.id.tvNumbers)
        val process: TextView = findViewById(R.id.tvProcess)

        if (shownResult){
            clean()
            shownResult = false
        }
        numbers.setText(numbers.text.toString() + number.toString())

        /**if(numbers.text.toString().toInt() == 0){
            return
        }**/



        if(sign == 0){
            first = numbers.text.toString().toInt()
        }else{
            second = numbers.text.toString().toInt()
            process.setText(process.text.toString() + second.toString())
        }
    }

    fun calculate(){
        val numbers: TextView = findViewById(R.id.tvNumbers)
        if(second != Integer.MIN_VALUE){
            when {
                sign == 1 ->{
                    evaluation = first + second
                }
                sign == 2 ->{
                    evaluation = first - second
                }
                sign == 3 ->{
                    if(second != 0){
                        evaluation = first / second
                    }
                }
                sign == 4 ->{
                    evaluation = first * second
                }
            }

            shownResult = false
            first = evaluation
            second = Integer.MIN_VALUE
            numbers.setText(evaluation.toString())
        }
    }

    fun clean(){
        val numbers: TextView = findViewById(R.id.tvNumbers)
        val process: TextView = findViewById(R.id.tvProcess)

        process.setText("")
        numbers.setText("0")
        first = Integer.MIN_VALUE
        second = Integer.MIN_VALUE
        sign = 0
    }

    /**
     *
     * var str: String = ""
     * var opera: int = 0
     *
     * 0, str += str + "0"
     * numeros.setText(str)
     *
     * operado
     *
     * +, calc(1) str += str + "+"
     *  proceso.setText(str)
     *  opera =str.parseInt
     *  str=""
     *  numeros.setText("")
     *
     *
     * fun calc(1, num)
     * var nume = opera
     * num
     * when
     * op == 1 -<{
     *  nume + num
     *  ]
     *
     *
     *
     * **/
}