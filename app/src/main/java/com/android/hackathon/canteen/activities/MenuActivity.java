package com.android.hackathon.canteen.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.hackathon.canteen.MainActivity;
import com.android.hackathon.canteen.R;

import com.android.hackathon.canteen.activities.adapter.RecyclerViewAdapterMenu;
import com.android.hackathon.canteen.database.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuActivity extends AppCompatActivity {

    private List<Food> currentFood;

    private HashMap<String, List<Food>> hashMap;
    private List<Food> foodList1;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView myrv;
    private TextView canteenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Просто проверял как выглядит активити

        canteenTextView = findViewById(R.id.menu_canteen_name);
        prepareHashMap();
        Intent intent = getIntent();
        if (intent != null) {
            String curId = intent.getStringExtra("canteenId");
            String curName = intent.getStringExtra("canteenName");
            canteenTextView.setText(curName);
            for (Map.Entry<String, List<Food>> entry : hashMap.entrySet()) {
                if (entry.getKey().equals(curId)) {
                    currentFood = entry.getValue();
                }
            }
        }

        myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapterMenu myAdapter = new RecyclerViewAdapterMenu(this, currentFood);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);
        //NavigationBar
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.cart);

        setupBottomNav();
    }

    private void setupBottomNav() {
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
                        startActivity(new Intent(getApplicationContext(), BasketActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void prepareHashMap() {
        hashMap = new HashMap<>();

        foodList1 = new ArrayList<>();
        foodList1.add(new Food("1", "The Vegetarian", "https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Vegetarian cuisine is based on food that meets vegetarian standards by not including meat and animal tissue products", "$2.00", "25", 194, "30", "30"));
        foodList1.add(new Food("2", "Cumin soup", "https://img.sndimg.com/food/image/upload/w_560,h_315,c_thumb,fl_progressive,q_80/v1/img/recipes/32/24/65/picnDxFgl.jpg", "This carrot and cumin soup recipe, based on a traditional Middle Eastern soup, has become a favorite with everyone who tastes it. It's also unbelievably healthy (almost no fat) and easy (few ingredients). The finished soup has a wonderful creamy texture, especially considering there is no cream or cheese in it.", "$2.75", "35", 295, "30", "25"));
        foodList1.add(new Food("3", "Creamy Sweet Potato", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F8760746.jpg&q=85", "Loaded with sweet potato and warm spices, this oatmeal is a nutritious and tasty breakfast! It's perfect for using up leftover sweet potatoes. Just adjust the sweetener and butter if your recipe already has them. Top with toasted pecans, walnuts, or coconut.", "$1.90", "30", 341, "30", "40"));
        foodList1.add(new Food("4", "Vegetable curry", "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/chickpea_spinach_and_egg_50755_16x9.jpg", "This vegetarian low-calorie chickpea curry makes a wonderful, easy after-work meal, and is ready in less than 20 minutes. It's also vegan if you leave out the egg.", "$2", "26", 441, "29", "42"));
        foodList1.add(new Food("5", "Salmon", "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/salmon_broccoli_pasta_39926_16x9.jpg", "A simple salmon pasta that’s ready in under 15 minutes. This recipe makes two generous servings or three lighter meals. It’s also very easy to double up", "$3.90", "42", 549, "30", "25"));
        foodList1.add(new Food("6", "Adaptable bean", "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/nigelsadaptablebeans_92230_16x9.jpg", "Nigel Slater's budget-friendly bean soup is healthy and filling. Chop and change the ingredients for your favourite vegetables and beans.", "$2.50", "43", 439, "35", "20"));

//        foodList1.clear();
        hashMap.put("1", foodList1);

//        foodList1 = new ArrayList<>();
//        foodList1.add(new Food("1", "The Vegetarian", "https://firebasestorage.googleapis.com/v0/b/myunicanteen-2015b.appspot.com/o/chorizo.jpg?alt=media&token=0d64d905-8647-46ca-8a90-5d60ebc03954", "Vegetarian cuisine is based on food that meets vegetarian standards by not including meat and animal tissue products", "$2.00", "25", 194, "30", "30"));
//        foodList1.add(new Food("2", "Cumin soup", "https://img.sndimg.com/food/image/upload/w_560,h_315,c_thumb,fl_progressive,q_80/v1/img/recipes/32/24/65/picnDxFgl.jpg", "This carrot and cumin soup recipe, based on a traditional Middle Eastern soup, has become a favorite with everyone who tastes it. It's also unbelievably healthy (almost no fat) and easy (few ingredients). The finished soup has a wonderful creamy texture, especially considering there is no cream or cheese in it.", "$2.75", "35", 295, "30", "25"));
//        foodList1.add(new Food("3", "Creamy Sweet Potato", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F8760746.jpg&q=85", "Loaded with sweet potato and warm spices, this oatmeal is a nutritious and tasty breakfast! It's perfect for using up leftover sweet potatoes. Just adjust the sweetener and butter if your recipe already has them. Top with toasted pecans, walnuts, or coconut.", "$1.90", "30", 341, "30", "40"));
//        foodList1.add(new Food("4", "Vegetable curry", "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/chickpea_spinach_and_egg_50755_16x9.jpg", "This vegetarian low-calorie chickpea curry makes a wonderful, easy after-work meal, and is ready in less than 20 minutes. It's also vegan if you leave out the egg.", "$2", "26", 441, "29", "42"));
//        foodList1.add(new Food("5", "Salmon", "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/salmon_broccoli_pasta_39926_16x9.jpg", "A simple salmon pasta that’s ready in under 15 minutes. This recipe makes two generous servings or three lighter meals. It’s also very easy to double up", "$3.90", "42", 549, "30", "25"));
//        foodList1.add(new Food("6", "Adaptable bean", "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/nigelsadaptablebeans_92230_16x9.jpg", "Nigel Slater's budget-friendly bean soup is healthy and filling. Chop and change the ingredients for your favourite vegetables and beans.", "$2.50", "43", 439, "35", "20"));

        hashMap.put("2", foodList1);
    }

}