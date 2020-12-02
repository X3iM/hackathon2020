package com.android.hackathon.canteen.database.model

class Food(
        var id: String,
        var name: String,
        var image: String,
        var description: String,
        var price: String,
        protein: String,
        var kcal: Int,
        fats: String,
        carbohydrates: String,
) {
    var protein = protein
        get() = "$field%"

    var fats = fats
        get() = "$field%"

    var carbohydrates = carbohydrates
        get() = "$field%"
}
