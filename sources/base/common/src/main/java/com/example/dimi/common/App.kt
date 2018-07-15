package com.example.dimi.common

import android.content.Context
import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.MainProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): AppProvider
    fun getMainScreenComponent(): MainProvider
    fun clearMainScreenComponent()
}