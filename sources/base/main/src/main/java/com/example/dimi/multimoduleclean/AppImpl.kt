package com.example.dimi.multimoduleclean

import android.app.Application
import com.example.dimi.multimoduleclean.di.AppComponent
import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.NetworkClient
import javax.inject.Inject

class AppImpl : Application(), App {

    val appComponent: AppComponent by lazy { AppComponent.init(this) }

    @Inject lateinit var networkClient: NetworkClient

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
        val a = networkClient.getInt()
        var aa = 3
        aa++
    }

    override fun getAppComponent(): AppProvider = appComponent
}