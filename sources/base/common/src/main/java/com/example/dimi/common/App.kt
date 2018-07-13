package com.example.dimi.common

import android.content.Context
import com.example.dimi.common.di.AppProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): AppProvider
}