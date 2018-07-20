package com.example.dimi.common.paginator

import android.arch.lifecycle.LiveData
import com.example.dimi.common.paginator.model.PaginatorResult
import io.reactivex.Completable
import io.reactivex.Flowable

interface Paginator<T> {

    fun setCallbacks(
        init: () -> Completable,
        database: () -> Flowable<List<T>>,
        nextData: (Int) -> Completable
    )

    fun refresh()

    fun loadNewPage()

    fun getSingleEvent(): LiveData<String>

    fun getData(): LiveData<PaginatorResult<T>>

    fun disposeAll()
}