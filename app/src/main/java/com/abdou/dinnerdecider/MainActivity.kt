package com.abdou.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.abdou.dinnerdecider.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    // Create local variables to store components from activity_main.xml
    lateinit var string: String
    lateinit var selectedFoodText: TextView
    lateinit var decideButton: Button
    lateinit var addFoodText: TextView
    lateinit var addFoodButton: Button

    val foodList = arrayListOf("Chinese", "Hamburger", "Pizza", "McDonalds", "Salem House of Pizza")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set each component to a local variable
        selectedFoodText = findViewById(R.id.selectedFoodText)
        decideButton = findViewById(R.id.decideButton)
        addFoodText = findViewById(R.id.addFoodText)
        addFoodButton = findViewById(R.id.addFoodButton)

        // Data Binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.selectedFoodText.text = "Burger King"

        // Decides what to eat
        decideButton.setOnClickListener {
            //Create a variable of the imported Random class then set the random food index
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodText.text = foodList[randomFood]
        }

        // Adds food to the arralist
        addFoodButton.setOnClickListener {
            val newFood = addFoodText.text.toString()
            val check = foodList.toArray()
            var dupl: Boolean = false
            for (a in check) {
                //println("b count = $a")
                if (newFood == a) {
                    println("$newFood already exists!")
                    dupl = true
                }
            }

            if(dupl == false) {
                foodList.add(newFood)
                addFoodText.text = ""
                println(foodList)
            }else{
                dupl == false
                println(foodList)
            }
        }
        }



    }