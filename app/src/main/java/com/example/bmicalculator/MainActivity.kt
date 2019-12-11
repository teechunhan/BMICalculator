package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{ calculateBMI() }
        buttonReset.setOnClickListener{ resetInput() }
    }

    private fun calculateBMI() {

        if(editTextWeight.text.isEmpty() || editTextHeight.text.isEmpty()) {
            editTextHeight.setError(getString(R.string.input_error))
            editTextWeight.setError(getString(R.string.input_error))
        }
        else {
            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()

            val bmi = weight / ((height / 100) * (height / 100))

            if(bmi < 18.5) {
                imageViewProfile.setImageResource(R.drawable.under)
                textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)
                textViewStatus.setText(getString(R.string.status) + " " + getString(R.string.under))
            }
            else if(bmi > 18.4 && bmi < 25.0) {
                imageViewProfile.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)
                textViewStatus.setText(getString(R.string.status) + " " + getString(R.string.normal))
            }
            else {
                imageViewProfile.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)
                textViewStatus.setText(getString(R.string.status) + " " + getString(R.string.over))
            }
        }

    }

    private fun resetInput() {
        editTextWeight.setText("")
        editTextHeight.setText("")
        textViewBMI.text = getString(R.string.bmi)
        textViewStatus.text = getString(R.string.status)
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}
