package com.example.cse438.caloriecounter

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.core.graphics.toColor
import com.example.cse438.caloriecounter.R
import com.example.cse438.caloriecounter.FoodListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.enter_calories.*
import kotlinx.android.synthetic.main.enter_calories.view.*
import kotlinx.android.synthetic.main.food_list_row.*
import kotlinx.android.synthetic.main.food_list_row.view.*

class MainActivity : AppCompatActivity() {

    private var listOfFoods = ArrayList<String>()
    private var listOfCal = ArrayList<String>()

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInitial()
        dialogView()
    }

    private fun getInitial() {
        listView = foodList

        val adapter = FoodListAdapter(this, listOfFoods, listOfCal)
        listView?.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    private fun dialogView() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.enter_calories, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Enter your calorie limit")
        val alertDialog = builder.show()

        alertDialog.submitCal.setOnClickListener {
            val calInput = dialogView.name.text.toString()
            if(calInput != ""){
                totCal.text = calInput
                calRemain.text = calInput
                alertDialog.dismiss()
            }
        }
    }

    fun addFood(view: View?){
        val foodToAdd = newFood.text.toString()
        val calToAdd = newCal.text.toString()

        var updateCal = calRemain.text.toString().toInt()

        if(foodToAdd == ""){
            val myToast = Toast.makeText(this, "Please enter a food item", Toast.LENGTH_SHORT)
            myToast.show()
        }
        else if(calToAdd == "") {
            val myToast = Toast.makeText(this, "Please enter calorie amount", Toast.LENGTH_SHORT)
            myToast.show()
        }
        else{
            listOfFoods.add(foodToAdd)
            listOfCal.add(calToAdd)
            (listView?.adapter as? FoodListAdapter)?.notifyDataSetChanged()


            updateCal -= newCal.text.toString().toInt()
            calRemain.text = updateCal.toString()
        }

        if(updateCal < 0) {
            calRemain.setTextColor(Color.RED)
        }
    }

    fun deleteFood(view: View?) {
        val taskToDelete = foodName.text.toString()
        val calToDelete = foodCal.text.toString()

        listOfFoods.remove(taskToDelete)
        listOfCal.remove(calToDelete)
        (listView?.adapter as? FoodListAdapter)?.notifyDataSetChanged()

        var updateCal = calRemain.text.toString().toInt()
        updateCal += calToDelete.toInt()
        calRemain.text = updateCal.toString()

        if(updateCal > 0) {
            calRemain.setTextColor(Color.BLACK)
        }
    }
}
