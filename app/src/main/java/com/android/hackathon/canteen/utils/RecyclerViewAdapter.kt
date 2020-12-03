package com.android.hackathon.canteen.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.hackathon.canteen.R
import com.android.hackathon.canteen.activities.MenuActivity
import com.android.hackathon.canteen.activities.ProfileActivity
import com.android.hackathon.canteen.database.model.Canteen

open class RecyclerViewAdapter(var canteenList: List<Canteen>,
                               var context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        canteenList.forEach { v -> Log.d("canteenList", "$v")}
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.main_activity_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val canteen = canteenList[position]
        
        viewHolder.bind(canteen)
        viewHolder.itemView.setOnClickListener {
            Log.d("onClick", canteen.id)
            var intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("canteenId", canteen.name)
            context.startActivity(intent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var textView: TextView = view.findViewById(R.id.main_activity_canteen_name)
        private lateinit var currentCanteen: Canteen

        fun bind(canteen: Canteen) {
            currentCanteen = canteen
            Log.d("bind", "bind item")
            textView.text = canteen.name
        }

    }

    override fun getItemCount(): Int {
        return canteenList.size
    }

}