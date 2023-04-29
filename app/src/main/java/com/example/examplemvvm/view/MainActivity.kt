package com.example.examplemvvm.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.viewModel.ColorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var txtColor: EditText

    private val colorViewModel: ColorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        txtColor = binding.txtColor
        setContentView(binding.root)

        colorViewModel.randomColor()

        colorViewModel.colorModel.observe(this, Observer { currentColor ->
            binding.viewContainer.setBackgroundColor(Color.parseColor(currentColor.color))
            binding.colorLabel.text = "El color de fondo es " + currentColor.name
        })

        binding.viewContainer.setOnClickListener {
            val colorText = txtColor.text.toString()
            if(colorText.isNotEmpty()) {
                val colorArray = colorText.split("/").toTypedArray()
                val colorName = colorArray[0]
                val colorHex = colorArray[1]
                val colorHexRegex = Regex("^#[A-Fa-f0-9]{6}$")
                if(colorHexRegex.matches(colorHex))  {
                    colorViewModel.add(colorHex, colorName)
                } else {
                    Toast.makeText(this, "Debes ingresar un color en formato hexadecimal valido", Toast.LENGTH_SHORT).show()
                }
                txtColor.setText("")
            } else {
                colorViewModel.randomColor()
            }
        }
    }
}