package com.example.apimoviedbcommvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apimoviedbcommvvm.RetrofitAPI.RetrofitAPI
import com.example.apimoviedbcommvvm.adapter.MovieAdapter
import com.example.apimoviedbcommvvm.databinding.ActivityMainBinding
import com.example.apimoviedbcommvvm.repository.MainRepository
import com.example.apimoviedbcommvvm.viewModel.MainViewModel
import com.example.apimoviedbcommvvm.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitAPI = RetrofitAPI.getInstanceRetrofit()
    private lateinit var adapter: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitAPI)))[MainViewModel::class.java]
        iniciarAdapter()
    }

    override fun onStart() {
        super.onStart()
        viewModel.movieList.observe(this, Observer {
           adapter.createListOfMovies(it)
        })
    }


    private fun iniciarAdapter(){
        adapter = MovieAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }


}


