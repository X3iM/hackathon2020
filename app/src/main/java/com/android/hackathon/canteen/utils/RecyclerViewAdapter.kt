package com.android.hackathon.canteen.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.hackathon.canteen.R
import com.android.hackathon.canteen.database.model.Canteen

open class RecyclerViewAdapter(var canteenList: List<Canteen>,
                               private var context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.main_activity_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val canteen = canteenList[position]

        viewHolder.textView.text = canteen.name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textView: TextView = view.findViewById(R.id.main_activity_canteen_name)

        override fun onClick(v: View?) {

        }

    }

    override fun getItemCount(): Int {
        return canteenList.size
    }

}