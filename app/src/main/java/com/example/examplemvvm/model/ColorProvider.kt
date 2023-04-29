package com.example.examplemvvm.model

class ColorProvider {
    companion object {

        fun random(): ColorModel {
            val lastIndex: Int = color.size - 1
            val position: Int = (0..lastIndex).random()
            return color[position]
        }

        fun add(color: ColorModel) {
            this.color.add(color)
        }

        fun total(): Int {
            return color.size
        }

        private val color = mutableListOf<ColorModel>(
            ColorModel(
                color = "#826AED",
                name = "Medium slate blue",
            ),
            ColorModel(
                color = "#c879ff",
                name = "Heliotrope",
            ),
            ColorModel(
                color = "#ffb7ff",
                name = "Mauve",
            ),
            ColorModel(
                color = "#3bf4fb",
                name = "Aqua",
            ),
            ColorModel(
                color = "#caff8a",
                name = "Mindaro",
            ),
            ColorModel(
                color = "#7180ac",
                name = "Glaucous",
            ),
            ColorModel(
                color = "#2b4570",
                name = "Marian blue",
            ),
            ColorModel(
                color = "#a8d0db",
                name = "Light blue",
            ),
            ColorModel(
                color = "#e49273",
                name = "Atomic tangerine",
            ),
            ColorModel(
                color = "#a37a74",
                name = "Cinereuos",
            ),
        )
    }
}