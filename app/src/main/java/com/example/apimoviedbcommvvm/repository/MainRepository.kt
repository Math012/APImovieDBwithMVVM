package com.example.apimoviedbcommvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apimoviedbcommvvm.RetrofitAPI.RetrofitAPI
import com.example.apimoviedbcommvvm.models.Movie
import com.example.apimoviedbcommvvm.models.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainRepository constructor(private val retrofitAPI: RetrofitAPI) {


    fun getMoviesRepository() = retrofitAPI.getAllMoviesRetrofit()

    fun getMoviePageRepository(numberPage: Int): MutableLiveData<List<Movie>>{
        val pageMovie = MutableLiveData<List<Movie>>()


        retrofitAPI.getMoviesPages(numberPage).enqueue(object : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                var items = response.body()?.listMovies
                pageMovie.value = items
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {

            }

        })

        return pageMovie
    }


}