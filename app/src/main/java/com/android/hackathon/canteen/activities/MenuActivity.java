package com.android.hackathon.canteen.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.android.hackathon.canteen.R;
import com.android.hackathon.canteen.activities.adapter.Food;
import com.android.hackathon.canteen.activities.adapter.RecyclerViewAdapterMenu;

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
        lstFood.add(new Food("The Vegetarian","Categories","Description", 2.33,R.drawable.tomato ));
        lstFood.add(new Food("Soup","Categories","Description",2.40, R.drawable.chorizo ));
        lstFood.add(new Food("Hamburger","Categories","Description",3.00,R.drawable.num1 ));
        lstFood.add(new Food("The Vegetarian","Categories","Description", 2.30,R.drawable.tomato ));
        lstFood.add(new Food("Soup","Categories","Description",2.40, R.drawable.chorizo ));
        lstFood.add(new Food("Hamburger","Categories","Description",3.00,R.drawable.num1 ));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapterMenu myAdapter = new RecyclerViewAdapterMenu(this,lstFood);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }

}