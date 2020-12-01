package com.android.hackathon.canteen.database

data class User(
        var id: String,
        var name: String,
        var image: String,
        var email: String,
        var phone: String,
        var room: String,
        var orderHistory: List<Food>
)
