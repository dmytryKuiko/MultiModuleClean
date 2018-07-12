package com.example.dimi.common.di

import com.example.dimi.common.network.NetworkClient

interface NetworkProvider {
    fun provideNetworkClient(): NetworkClient
}