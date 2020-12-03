package com.android.hackathon.canteen.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.hackathon.canteen.R;
import com.android.hackathon.canteen.activities.DishActivity;
import com.android.hackathon.canteen.database.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterBasket extends RecyclerView.Adapter<RecyclerViewAdapterBasket.MyViewHolder>{

    private Context mContext;
    private List<Food> mData;

    public RecyclerViewAdapterBasket(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflate = LayoutInflater.from(mContext);
        view = mInflate.inflate(R.layout.basket_activity_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_food_title.setText(mData.get(position).getName());
//        holder.img_food_thumbnail.setImageURI(Uri.parse(mData.get(position).getImage()));
        Picasso.get().load(mData.get(position).getImage()).into(holder.img_food_thumbnail);
        holder.tv_food_price.setText(mData.get(position).getPrice());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DishActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_food_title;
        ImageView img_food_thumbnail;
        TextView tv_food_price;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_food_title = (TextView)itemView.findViewById(R.id.basket_activity_title);
            img_food_thumbnail = (ImageView)itemView.findViewById(R.id.basket_activity_picture);
            tv_food_price=(TextView)itemView.findViewById(R.id.basket_activity_price);
            cardView=(CardView)itemView.findViewById(R.id.basket_item);
        }
    }
}
