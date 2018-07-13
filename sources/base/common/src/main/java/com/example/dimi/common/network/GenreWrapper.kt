package com.example.dimi.common.network

interface GenreWrapper {
    val genres: List<Genre>
}

interface Genre {
    val id: Int
    val name: String
}