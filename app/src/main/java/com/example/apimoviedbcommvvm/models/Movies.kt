package com.example.apimoviedbcommvvm.models

import com.google.gson.annotations.SerializedName



data class Movies(
    @SerializedName("results")
    val listMovies: List<Movie>
):java.io.Serializable



data class Movie(
    @SerializedName("original_title")
    val title:String,

    @SerializedName("overview")
    val description:String,

    @SerializedName("poster_path")
    val poster:String
):java.io.Serializable



