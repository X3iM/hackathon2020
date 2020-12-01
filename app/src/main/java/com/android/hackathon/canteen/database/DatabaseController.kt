package com.android.hackathon.canteen.database

import android.util.Log
import com.android.hackathon.canteen.database.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object DatabaseController {

    lateinit var databaseReference: DatabaseReference

    fun makeRequest() {
        databaseReference = FirebaseDatabase.getInstance().reference.child("users")
        databaseReference.push().setValue(User(id="1", name="", image="none", email="example@gmail.com", phone="+9834929044", room="A001", orderHistory=null))
        Log.d("DATABASE","makeRequest")
    }

}