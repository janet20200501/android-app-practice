package com.soetek.bmi

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.soetek.bmi.databinding.ActivityBmiCalculateBinding

class BmiCalculateAct : AppCompatActivity() {
    private lateinit var binding: ActivityBmiCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContentView(R.layout.activity_bmi_calculate)
        binding = ActivityBmiCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.weightInput.addTextChangedListener { text ->
            if (text != null) {
                if (!text.equals("") && !binding.heightInput.text.toString().equals(""))
                    binding.submitBtn.isEnabled = true
            }
        }
        binding.heightInput.addTextChangedListener { text ->
            if (text != null) {
                if (!text.equals("") && !binding.weightInput.text.toString().equals(""))
                    binding.submitBtn.isEnabled = true
            }
        }
    }

    fun calculate(view: View) {
        val bmi = Bmi()
        bmi.weight = binding.weightInput.text.toString().toFloat()
        bmi.height = binding.heightInput.text.toString().toFloat()

        val result = bmi.calculate()
        binding.bmiResult.setText("%.2f".format(result).toString())
    }

    fun clear(view: View) {
        binding.weightInput.setText("")
        binding.heightInput.setText("")
        binding.bmiResult.setText("")
    }
}