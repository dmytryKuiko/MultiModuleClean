package com.example.dimi.network

import com.example.dimi.common.network.RetrofitModel

class RetrofitModelRetrofitImpl(
    override val userId: Int,
    override val id: Int,
    override val title: String,
    override val body: String
) : RetrofitModel