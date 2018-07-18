package com.example.dimi.common.network

interface PopularMovies {
    val page: Int
    val totalPages: Int
    val movieList: List<Movie>
}