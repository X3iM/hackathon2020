package com.android.hackathon.canteen.database.model

data class Food(
        var id: String,
        var name: String,
        var image: String,
        var description: String,
        var price: String,
        var protein: Int,
        var kcal: Int,
        var fats: Int,
        var carbohydrates: Int,
)
