package com.android.hackathon.canteen.database

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseController {

    var databaseReference: DatabaseReference

    constructor() {
        databaseReference = FirebaseDatabase.getInstance().reference.child("users").child("1")
    }
}