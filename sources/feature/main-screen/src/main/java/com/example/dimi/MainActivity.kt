package com.example.dimi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dimi.di.MainScreenComponent
import com.example.dimi.multimoduleclean.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @JvmField var someInt: Int? = null

    @Inject lateinit var someString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        MainScreenComponent.init((application as App).getAppComponent()).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
