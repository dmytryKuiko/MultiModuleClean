package com.example.dimi.data

import com.example.dimi.common.network.NetworkClient
import javax.inject.Inject

class MainRepositoryImpl
@Inject constructor(
    private val store: MainStore,
    private val mapper: MainDataMapper,
    private val networkClient: NetworkClient
) : MainRepository {
}