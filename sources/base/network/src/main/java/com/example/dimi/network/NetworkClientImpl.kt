package com.example.dimi.network

import com.example.dimi.common.NetworkClient
import javax.inject.Inject

class NetworkClientImpl
@Inject constructor() : NetworkClient {
    override fun getInt(): Int = 2
}