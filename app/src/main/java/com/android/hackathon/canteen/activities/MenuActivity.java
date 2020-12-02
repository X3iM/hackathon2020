package com.android.hackathon.canteen.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.android.hackathon.canteen.R;

import com.android.hackathon.canteen.activities.adapter.RecyclerViewAdapterMenu;
import com.android.hackathon.canteen.database.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    List<Food> lstFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Просто проверял как выглядит активити
       lstFood = new ArrayList<>();
       lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapterMenu myAdapter = new RecyclerViewAdapterMenu(this,lstFood);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }

}