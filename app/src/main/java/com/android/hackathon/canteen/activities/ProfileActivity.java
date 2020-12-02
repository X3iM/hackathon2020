package com.android.hackathon.canteen.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.hackathon.canteen.R;
import com.android.hackathon.canteen.database.DatabaseController;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("canteenId"), Toast.LENGTH_LONG).show();

//        DatabaseController.INSTANCE.makeRequest();
    }
}