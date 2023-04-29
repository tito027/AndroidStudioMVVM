package com.example.examplemvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.model.ColorModel
import com.example.examplemvvm.model.ColorProvider

class ColorViewModel: ViewModel() {
    val colorModel = MutableLiveData<ColorModel>()

    fun randomColor() {
        val currentColor: ColorModel = ColorProvider.random()
        println("Total colores: " + ColorProvider.total().toString())
        colorModel.postValue(currentColor)
    }

    fun add(color: String, name: String) {
        val colorModel = ColorModel(
            color = color,
            name = name,
        )
        ColorProvider.add(colorModel)
        println("Total colores: " + ColorProvider.total().toString())
        this.colorModel.postValue(colorModel)
    }
}