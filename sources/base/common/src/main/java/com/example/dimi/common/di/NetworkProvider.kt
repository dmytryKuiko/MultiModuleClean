package com.example.dimi.common.di

import com.example.dimi.common.NetworkClient

interface NetworkProvider {
    fun provideNetworkClient(): NetworkClient
}