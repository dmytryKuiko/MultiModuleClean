package com.example.dimi.multimoduleclean

import android.app.Application
import com.example.dimi.common.App
import com.example.dimi.multimoduleclean.di.AppComponent
import com.example.dimi.common.di.AppProvider

class AppImpl : Application(), App {

    private val appComponent: AppComponent by lazy { AppComponent.init(this) }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }

    override fun getAppComponent(): AppProvider = appComponent
}