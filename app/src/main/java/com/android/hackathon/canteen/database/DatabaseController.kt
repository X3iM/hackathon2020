package com.android.hackathon.canteen.database

import android.util.Log
import com.android.hackathon.canteen.database.model.Canteen
import com.android.hackathon.canteen.database.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object DatabaseController {

    lateinit var databaseReference: DatabaseReference

    fun makeRequest() {

    }

    fun addCanteen() {
        databaseReference = FirebaseDatabase.getInstance().reference.child("canteen")
        databaseReference.push().setValue(Canteen(id="1", name="Němcovej 1")).addOnSuccessListener {  }

        Log.d("DATABASE", (databaseReference.push().key == null).toString())
//                .setValue(Canteen(id="2", name="Jedlíkova 7"))
//        databaseReference.push().setValue(Canteen(id="3", name="Urbánkova 2"))
//        databaseReference.push().setValue(Canteen(id="4", name="Němcovej 9"))
//        databaseReference.push().setValue(Canteen(id="5", name="Němcovej 32"))
//        databaseReference.push().setValue(Canteen(id="6", name="Vysokoškolská 4"))
//        databaseReference.push().setValue(Canteen(id="7", name="Němcovej 5"))
//        databaseReference.push().setValue(Canteen(id="8", name="Budovateľská 31"))
//        databaseReference.push().setValue(Canteen(id="9", name="Forte Jedlíkova 7"))
//        databaseReference.push().setValue(Canteen(id="10", name="Němcovej 7"))
    }

}