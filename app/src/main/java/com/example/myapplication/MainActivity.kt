package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)

        binding.detailsButton1.setOnClickListener {
            onClickHandler(createAnimal("cat", "fd_cat", "cat"))
        }

        binding.detailsButton2.setOnClickListener {
            onClickHandler(createAnimal("dog", "fd_dog", "dog"))
        }

        binding.detailsButton3.setOnClickListener {
            onClickHandler(createAnimal("owl", "fd_owl", "owl"))
        }
    }

    private fun onClickHandler(animal: Animals){
        val intent = Intent(this, DescriptionAnimals::class.java)

        intent.putExtra("animal", animal)
        startActivity(intent)
    }

    @SuppressLint("DiscouragedApi")
    private fun createAnimal(name: String, description: String, image: String): Animals {
        val res: Resources = resources

        val resNameId = resources.getIdentifier(name, "string", packageName)
        val name: String = res.getString(resNameId)

        val resDescriptionId = resources.getIdentifier(description, "string", packageName)
        val description: String = res.getString(resDescriptionId)

        return Animals(name, description, image)
    }
}