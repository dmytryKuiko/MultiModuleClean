package com.example.dimi.common.di

import com.example.dimi.common.database.DatabaseClient

interface DatabaseProvider {
    fun provideDatabaseClient(): DatabaseClient
}