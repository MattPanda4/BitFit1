package com.matt.bitfit1

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import layout.FoodListRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private var foods = mutableListOf<CurrentFood>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerviewFoods = findViewById<RecyclerView>(R.id.foodList)
        val adapter = FoodListRecyclerViewAdapter(foods)
        val foodAdapter = FoodListRecyclerViewAdapter(foods)

        lifecycleScope.launch {
            (application as MyApplication).db.foodDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    CurrentFood(
                        entity.foodName,
                        entity.foodCalories,
                    )
                }.also { mappedList ->
                    foods.addAll(mappedList)
                    foodAdapter.notifyDataSetChanged()
                }
            }
        }
        recyclerviewFoods.adapter = adapter
        recyclerviewFoods.layoutManager = LinearLayoutManager(this)

        val addButton = findViewById<Button>(R.id.button)
        addButton.setOnClickListener {
            val intent = Intent(this, AddFoodScreen::class.java)
            startActivity(intent)
        }
    }
}


