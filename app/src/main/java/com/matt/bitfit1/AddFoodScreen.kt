package com.matt.bitfit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddFoodScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food_fragment)

        val addfoodbutton = findViewById<Button>(R.id.RecordFoodButton)

        addfoodbutton.setOnClickListener{
            val foodname = findViewById<TextView>(R.id.FoodNameInput).text.toString()
            val foodcal = findViewById<TextView>(R.id.calorieInput).text.toString()

            lifecycleScope.launch(IO){
                (application as MyApplication).db.foodDao().insert(
                    CurrentFood(foodname, foodcal)
                )
            }
            finish()
        }
    }
}