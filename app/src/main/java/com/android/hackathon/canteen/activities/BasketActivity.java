package com.android.hackathon.canteen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.hackathon.canteen.MainActivity;
import com.android.hackathon.canteen.R;
import com.android.hackathon.canteen.activities.adapter.RecyclerViewAdapterBasket;
import com.android.hackathon.canteen.activities.adapter.RecyclerViewAdapterMenu;
import com.android.hackathon.canteen.database.DatabaseController;
import com.android.hackathon.canteen.database.model.Canteen;
import com.android.hackathon.canteen.database.model.Food;
import com.android.hackathon.canteen.utils.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity
{
    List<Food> lstFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        //Просто проверял как выглядит активити
        lstFood = new ArrayList<>();
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));
        lstFood.add(new Food("1","The Vegetarian","https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Description","$2","2",2,"2","2" ));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.basket_activity_recycler_view);
        RecyclerViewAdapterBasket myAdapter = new RecyclerViewAdapterBasket(this,lstFood);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.cart);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.cart:
                        return true;
                }
                return false;
            }
        });
    }

}

