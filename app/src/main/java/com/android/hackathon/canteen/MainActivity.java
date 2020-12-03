package com.android.hackathon.canteen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.android.hackathon.canteen.activities.BasketActivity;
import com.android.hackathon.canteen.activities.MenuActivity;
import com.android.hackathon.canteen.activities.ProfileActivity;
import com.android.hackathon.canteen.database.DatabaseController;
import com.android.hackathon.canteen.database.model.Canteen;
import com.android.hackathon.canteen.utils.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Canteen> canteenList = DatabaseController.INSTANCE.addCanteen();

        progressBar = findViewById(R.id.progress_bar_main_activity);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.main_activity_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setVisibility(View.GONE);
        adapter = new RecyclerViewAdapter(canteenList, this);

        if (canteenList.size() == 0)
            (new Handler()).postDelayed(this::function, 1500);
        else {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        adapter.notifyDataSetChanged();


        //NavigationBar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
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
// NavigationBar
    }

    private void function() {
        adapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

}


