package com.example.dimi.multimoduleclean

import android.app.Application
import com.example.dimi.common.App
import com.example.dimi.multimoduleclean.di.AppComponent
import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.MainProvider
import com.example.dimi.di.MainScreenComponent

class AppImpl : Application(), App {

    private val appComponent: AppComponent by lazy { AppComponent.init(this) }

    private var mainScreenComponent: MainScreenComponent? = null

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }

    override fun getAppComponent(): AppProvider = appComponent

    override fun getMainScreenComponent(): MainProvider {
        return mainScreenComponent ?: MainScreenComponent.init(appComponent)
    }

    override fun clearMainScreenComponent() {
        mainScreenComponent = null
    }
}