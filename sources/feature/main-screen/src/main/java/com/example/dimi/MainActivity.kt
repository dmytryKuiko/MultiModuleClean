package com.example.dimi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dimi.common.network.NetworkClient
import com.example.dimi.di.MainScreenComponent
import com.example.dimi.common.App
import com.example.dimi.common.database.DatabaseClient
import com.example.dimi.common.network.RetrofitModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var model: NetworkClient

    @Inject
    lateinit var database: DatabaseClient

    override fun onCreate(savedInstanceState: Bundle?) {
        MainScreenComponent.init((application as App).getAppComponent()).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.getRetrofitModel().subscribe { t1, t2 ->
            var a = 3
            a++
        }

        database.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                var a = 3
                a++
            },
                {
                    var a = 3
                    a++
                }
            )

//        Completable.fromCallable {
//            database.insertData(object : RetrofitModel {
//                override val userId: Int
//                    get() = 11
//                override val id: Int
//                    get() = 22
//                override val title: String
//                    get() = "33"
//                override val body: String
//                    get() = "44"
//            })
//        }.subscribeOn(Schedulers.io())
//            .subscribe(Action {
//                var a = 3
//                a++
//            }, Consumer {
//                var a = 3
//                a++
//            })
    }
}
