package com.android.hackathon.canteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.android.hackathon.canteen.database.DatabaseController;
import com.android.hackathon.canteen.database.model.Canteen;
import com.android.hackathon.canteen.utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Canteen> canteenList = new ArrayList<>();
        canteenList.add(new Canteen("id1", "Jedlikova 5"));
        canteenList.add(new Canteen("id2", "Neviem aka 5"));
        canteenList.add(new Canteen("id3", "Neviem aka 6"));
        canteenList.add(new Canteen("id4", "Neviem aka 7"));
        canteenList.add(new Canteen("id5", "Neviem aka 8"));
        canteenList.add(new Canteen("id6", "Neviem aka 9"));

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.main_activity_recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(canteenList, this);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        DatabaseController.INSTANCE.makeRequest();

    }
}