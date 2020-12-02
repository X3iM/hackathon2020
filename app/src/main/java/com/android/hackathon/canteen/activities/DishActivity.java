package com.android.hackathon.canteen.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.hackathon.canteen.R;
import com.android.hackathon.canteen.database.model.Canteen;
import com.android.hackathon.canteen.database.model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class DishActivity extends AppCompatActivity {
    private ImageView image;
    private TextView name, description, price;
    private Food dishes;
    private String id = "Food";
    private TextView protein;
    private TextView fats;
    private TextView carbonohydrates;
    private TextView kcal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish);

        dishes = new Food("id1", "Rezen", "https://webstockreview.net/images/crab-clipart-crusty-15.png", "Tento šalát sa skladá z avokáda, zelene,\n" +
                " papriky, paradajok, tofu, cíceru a vodného melónu.", "5$",
                "40", 400, "40", "20");




        image=(ImageView)findViewById(R.id.imageDish);
        name=(TextView)findViewById(R.id.nameDish);
        description = (TextView)findViewById((R.id.descr));
        price=(TextView)findViewById(R.id.price);
        protein=(TextView)findViewById(R.id.protein);
        fats=(TextView)findViewById(R.id.fats);
        carbonohydrates=(TextView)findViewById(R.id.carbonohydrates);
        kcal=(TextView)findViewById(R.id.kcal);



        Picasso.get().load(dishes.getImage()).into(image);
        name.setText(dishes.getName());
        description.setText(dishes.getDescription());
        price.setText(dishes.getPrice());
        protein.setText(String.valueOf(dishes.getProtein()));
        fats.setText(String.valueOf(dishes.getProtein()));
        carbonohydrates.setText(String.valueOf(dishes.getProtein()));
        kcal.setText(String.valueOf(dishes.getKcal()));




//        infoDishDisplay(id);
    }

//    private void infoDishDisplay(String id) {
//        DatabaseReference dishRef = FirebaseDatabase.getInstance().getReference();
//        dishRef.child(id).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()) {
//                    Food dish = snapshot.getValue(Food.class);
//                    name.setText(dish.getName());
//                    description.setText(dish.getDescription());
//                    Picasso.get().load(dish.getImage()).into(image);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }


}