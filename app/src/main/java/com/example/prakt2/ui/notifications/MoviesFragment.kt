package com.example.prakt2.ui.notifications

import MovieAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prakt2.adapters.MoviesApi
import com.example.prakt2.databinding.FragmentMoviesBinding
import com.example.prakt2.models.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var movieApi: MoviesApi
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        val context = requireContext()

        retrofit = Retrofit.Builder()
            .baseUrl("https://dummyapi.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        movieApi = retrofit.create(MoviesApi::class.java)
        binding.rvMovies.layoutManager = LinearLayoutManager(context)
        fetchMovies()
        return binding.root
    }
    private fun fetchMovies() {
        movieApi.getMovies().enqueue(object : Callback<List<Movies>> {
            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {
                if (response.isSuccessful) {
                    val movies = response.body() ?: emptyList()
                    adapter = MovieAdapter(movies)
                    binding.rvMovies.adapter = adapter
                } else {
                    Log.d("NotificationsFragment", "Response not successful")
                }
            }
            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                Log.d("NotificationsFragment", "Request failed", t)
            }
        })
    }
}