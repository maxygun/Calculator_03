package com.example.calculator_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator_03.databinding.ActivityMainBinding
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val numberStringBuilder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()

    }

    private fun setListeners() = with(binding) {

        zeroButton.setOnClickListener {
            numberStringBuilder.append(0)
            resultTextView.text = numberStringBuilder
        }

        oneButton.setOnClickListener {
            numberStringBuilder.append(1)
            resultTextView.text = numberStringBuilder
        }

        twoButton.setOnClickListener {
            numberStringBuilder.append(2)
            resultTextView.text = numberStringBuilder
        }

        threeButton.setOnClickListener {
            numberStringBuilder.append(3)
            resultTextView.text = numberStringBuilder
        }

        fourButton.setOnClickListener {
            numberStringBuilder.append(4)
            resultTextView.text = numberStringBuilder
        }

        fiveButton.setOnClickListener {
            numberStringBuilder.append(5)
            resultTextView.text = numberStringBuilder
        }

        sixButton.setOnClickListener {
            numberStringBuilder.append(6)
            resultTextView.text = numberStringBuilder
        }

        sevenButton.setOnClickListener {
            numberStringBuilder.append(7)
            resultTextView.text = numberStringBuilder
        }

        eightButton.setOnClickListener {
            numberStringBuilder.append(8)
            resultTextView.text = numberStringBuilder
        }

        nineButton.setOnClickListener {
            numberStringBuilder.append(9)
            resultTextView.text = numberStringBuilder
        }


        plusButton.setOnClickListener {
            numberStringBuilder.append("+")
            resultTextView.text = numberStringBuilder
        }

        minusButton.setOnClickListener {
            numberStringBuilder.append("-")
            resultTextView.text = numberStringBuilder
        }

        multiplyButton.setOnClickListener {
            numberStringBuilder.append("*")
            resultTextView.text = numberStringBuilder
        }

        divideButton.setOnClickListener {
            numberStringBuilder.append("/")
            resultTextView.text = numberStringBuilder
        }

        pointButton.setOnClickListener {
            numberStringBuilder.append(".")
            resultTextView.text = numberStringBuilder
        }

        clearButton.setOnClickListener{
            numberStringBuilder.clear()
            resultTextView.text = "0"
        }

        resetButton.setOnClickListener{
            val lastIndex = numberStringBuilder.length - 1
            numberStringBuilder.deleteCharAt(lastIndex)
            resultTextView.text = numberStringBuilder
        }

        equalButton.setOnClickListener{
            calculate(resultTextView)

        }
    }

    private fun calculate(textView: TextView) {
        try {

            val stringExpression = numberStringBuilder.toString()
            val expression = Expression(stringExpression)
            val expressionResult = expression.evaluate().numberValue
            textView.text = expressionResult.toString()

            numberStringBuilder.clear()
            numberStringBuilder.append(expressionResult.toString())

        } catch (t: Throwable) {
            Toast.makeText(this@MainActivity, "Exception: $t", Toast.LENGTH_LONG)
                .show()
        }
    }
}