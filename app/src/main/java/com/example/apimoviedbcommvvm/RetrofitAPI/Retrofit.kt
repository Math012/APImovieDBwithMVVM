package com.example.apimoviedbcommvvm.RetrofitAPI

import com.example.apimoviedbcommvvm.models.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface RetrofitAPI {

    @GET("3/movie/popular?{CHAVE API}language=en-US&page=1")
    fun getAllMoviesRetrofit() : Call<Movies>

    companion object {
        private val retrofitAPI: RetrofitAPI by lazy{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RetrofitAPI::class.java)
        }
        fun getInstanceRetrofit() : RetrofitAPI{
            return retrofitAPI
        }
    }
}