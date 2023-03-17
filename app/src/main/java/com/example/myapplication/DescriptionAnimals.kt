package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DescriptionAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_animal)
        //Get an Animal class object
        val animal = intent.getParcelableExtra<Animals>("animal")
//then we set the data in the widgets
        val nameLabel = findViewById<TextView>(R.id.nameView)
        nameLabel.text = animal?.name

        val imageView = findViewById<ImageView>(R.id.imageView)
        val resId = resources.getIdentifier(animal?.image, "drawable", packageName)
        imageView.setImageResource(resId)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = animal?.description
    }
}