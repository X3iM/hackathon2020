package com.android.hackathon.canteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.android.hackathon.canteen.database.DatabaseController;
import com.android.hackathon.canteen.database.model.Canteen;
import com.android.hackathon.canteen.utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Canteen> canteenList = DatabaseController.INSTANCE.addCanteen();


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.main_activity_recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(canteenList, this);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        try {
            Thread.sleep(1000L);
            Log.d("THREAD", "sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adapter.setCanteenList(canteenList);
        adapter.notifyDataSetChanged();
    }
}