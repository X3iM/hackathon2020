package com.android.hackathon.canteen.database.model

data class Order(
        var foodList: List<Food>,
        var date: String
)
