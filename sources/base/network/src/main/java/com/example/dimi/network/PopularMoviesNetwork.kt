package com.example.dimi.network

import com.example.dimi.common.network.PopularMovies
import com.google.gson.annotations.SerializedName

class PopularMoviesNetwork(
    @field:SerializedName("page") override val page: Int,
    @field:SerializedName("total_pages") override val totalPages: Int,
    @field:SerializedName("results") override val movieList: List<MovieNetwork>
) : PopularMovies {

}