package com.example.cse438.caloriecounter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.cse438.caloriecounter.R

class FoodListAdapter(private var activity: Activity, private var food: ArrayList<String>, private var calories: ArrayList<String>): BaseAdapter() {

    private class ViewHolder(row: View?){
        var foodName: TextView? = null
        var foodCal: TextView? = null

        init {
            this.foodName = row?.findViewById(R.id.foodName)
            this.foodCal = row?.findViewById(R.id.foodCal)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.food_list_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val task = food[position]
        val c = calories[position]

        viewHolder.foodName?.text = task
        viewHolder.foodCal?.text = c

        return view as View
    }

    override fun getItem(position: Int): Any {
        return food[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return food.size
    }

}