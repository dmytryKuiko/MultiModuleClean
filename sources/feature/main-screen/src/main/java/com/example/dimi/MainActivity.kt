package com.example.dimi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dimi.common.network.RetrofitModel
import com.example.dimi.di.MainScreenComponent
import com.example.dimi.multimoduleclean.App
import io.reactivex.Single
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @JvmField var someInt: Int? = null

    @Inject lateinit var someString: String

    @Inject lateinit var model: Single<RetrofitModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        MainScreenComponent.init((application as App).getAppComponent()).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.subscribe{ t1, t2 ->
            var a = 3
            a++
        }
    }
}
