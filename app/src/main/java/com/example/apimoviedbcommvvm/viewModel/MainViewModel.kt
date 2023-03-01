package com.example.apimoviedbcommvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apimoviedbcommvvm.models.Movie
import com.example.apimoviedbcommvvm.models.Movies
import com.example.apimoviedbcommvvm.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    var formatMovieList = ArrayList<Movie>()

    fun getAllMoviesViewModel(){
        val response = repository.getMoviesRepository()
        response.enqueue(object : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                val items = response.body()?.listMovies
                for (item in items!!.iterator())
                    formatMovieList.add(item)
                movieList.postValue(items)
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                println(t.message)
            }

        })
    }

}