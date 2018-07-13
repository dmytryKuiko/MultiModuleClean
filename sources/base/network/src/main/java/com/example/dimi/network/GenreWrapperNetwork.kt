package com.example.dimi.network

import com.example.dimi.common.network.GenreWrapper
import com.example.dimi.common.network.Genre

class GenreWrapperNetwork(
    override val genres: List<GenreNetwork>
) : GenreWrapper

class GenreNetwork(
    override val id: Int,
    override val name: String
) : Genre