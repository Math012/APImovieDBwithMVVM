package com.example.apimoviedbcommvvm.repository

import com.example.apimoviedbcommvvm.RetrofitAPI.RetrofitAPI
import retrofit2.Retrofit

class MainRepository constructor(private val retrofitAPI: RetrofitAPI) {
    fun getMoviesRepository() = retrofitAPI.getAllMoviesRetrofit()
}