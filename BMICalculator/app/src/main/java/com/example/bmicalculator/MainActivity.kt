package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val btnSubmit = findViewById<Button>(R.id.btnCalculate)
        btnSubmit.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if (validateInput(weight, height)) {
                val bmi = (weight.toFloat()) / ((height.toFloat() / 100) * (height.toFloat() / 100))
                val bmi2Digit = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2Digit)
            }
        }
    }

    // handling null situation (other wise app carshes if user enter nothing and submit)
    // weight:String = null (not valid)
    // weight:String? = null (valid)

    private fun validateInput(weight: String?, height: String?): Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Please Enter Weight", Toast.LENGTH_LONG).show()
                false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Please Enter Height", Toast.LENGTH_LONG).show()
                false
            }
            else -> true
        }

    }

    private fun displayResult(bmi: Float) {
        val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val infoMessage = findViewById<TextView>(R.id.tvInfo)
        val resToShow = findViewById<TextView>(R.id.tvRes)
        resultIndex.text = bmi.toString()
        infoMessage.text = "(Normal range is 18.5 - 24.9)"
        var color = 0
        var resultText = ""
        when {
            bmi < 18.5 -> {
                resultText = "You are Underweight"
                color = R.color.under_weight
            }
            bmi in 18.5..24.9 -> {
                resultText = "You are Healthy"
                color = R.color.normal
            }
            bmi in 25.0..29.9 -> {
                resultText = "You are Overweight"
                color = R.color.over_weight
            }
            else -> {
                resultText = "Obese"
                color = R.color.obese
            }

        }
        resToShow.setTextColor(ContextCompat.getColor(this, color))
        resToShow.text = resultText
    }
}

