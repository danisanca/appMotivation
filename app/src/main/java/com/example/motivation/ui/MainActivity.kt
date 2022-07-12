package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        handleUserName()
        handleFilterClick(R.id.image_all)
        handleNextPhrase()

        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Ola, $name!!!"
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_New_Phrase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            handleFilterClick(view.id)
        }
    }

    private fun handleNextPhrase() {
        binding.phrase.text = Mock().getPhrase(categoryId)
    }

    private fun handleFilterClick(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this,R.color.purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this,R.color.purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this,R.color.purple))
        if(id == R.id.image_all){
            binding.imageAll.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstants.FILTER.ALL
        }else if(id == R.id.image_sunny){
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstants.FILTER.SUNNY
        }else if(id == R.id.image_happy){
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstants.FILTER.HAPPY
        }
        Toast.makeText(this, "$categoryId", Toast.LENGTH_SHORT).show()
    }
}

