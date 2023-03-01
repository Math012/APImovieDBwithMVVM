package com.example.apimoviedbcommvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.apimoviedbcommvvm.R
import com.example.apimoviedbcommvvm.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val title = intent.getSerializableExtra("title")
        val image = intent.getSerializableExtra("image")
        val description = intent.getSerializableExtra("description")


        binding.textTitleDetail.setText(title.toString())

        Picasso.get()
            .load("https://image.tmdb.org/t/p/original" + image)
            .resize(300,300)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageDetail)

        binding.textDetails.setText(description.toString())
    }
}