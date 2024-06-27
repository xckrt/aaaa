package com.example.prakt2.adapters

import com.example.prakt2.models.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {
    @GET("movies")
    fun getMovies(): Call<List<Movies>>
}