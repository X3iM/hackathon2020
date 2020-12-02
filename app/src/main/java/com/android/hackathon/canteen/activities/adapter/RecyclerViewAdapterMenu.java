package com.android.hackathon.canteen.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.hackathon.canteen.R;

import java.util.List;

public class RecyclerViewAdapterMenu extends RecyclerView.Adapter<RecyclerViewAdapterMenu.MyViewHolder> {

    private Context mContext;
    private List<Food> mData;

    public RecyclerViewAdapterMenu(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflate = LayoutInflater.from(mContext);
        view = mInflate.inflate(R.layout.menu_item_dish,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_food_title.setText(mData.get(position).getName());
        holder.img_food_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.tv_food_price.setText(mData.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_food_title;
        ImageView img_food_thumbnail;
        TextView tv_food_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_food_title = (TextView)itemView.findViewById(R.id.food_title_id);
            img_food_thumbnail = (ImageView)itemView.findViewById(R.id.food_img_id);
            tv_food_price=(TextView)itemView.findViewById(R.id.food_title_price);
        }
    }
}
