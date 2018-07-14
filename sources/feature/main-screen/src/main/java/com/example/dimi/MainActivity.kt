package com.example.dimi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dimi.di.MainScreenComponent
import com.example.dimi.common.App
import com.example.dimi.common.Main
import com.example.dimi.common.di.MainProvider

class MainActivity : AppCompatActivity(), Main {

    private val mainScreenComponent: MainScreenComponent by lazy {
        MainScreenComponent.init((application as App).getAppComponent(), this)
    }
//
//    @Inject
//    lateinit var model: NetworkClient
//
//    @Inject
//    lateinit var database: DatabaseClient

    override fun onCreate(savedInstanceState: Bundle?) {
        mainScreenComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        model.getMovieById(11).subscribe { t1, t2 ->
//            var a = 3
//            a++
//        }
//
//        model.getGenres().subscribe { t1, t2 ->
//            var a = 3
//            a++
//        }

//        database.getData().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                var a = 3
//                a++
//            },
//                {
//                    var a = 3
//                    a++
//                }
//            )

//        Completable.fromCallable {
//            database.insertData(object : Movie {
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

    override fun getMainScreenComponent(): MainProvider = mainScreenComponent
}
