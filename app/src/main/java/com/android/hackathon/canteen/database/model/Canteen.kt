package com.android.hackathon.canteen.database.model

data class Canteen(
        var id: String,
        var name: String
) {
    constructor() : this("1", "1") {}
}
