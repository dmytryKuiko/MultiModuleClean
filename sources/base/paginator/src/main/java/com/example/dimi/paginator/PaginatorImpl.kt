package com.example.dimi.paginator

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.dimi.common.SingleEventLiveData
import com.example.dimi.common.paginator.Paginator
import com.example.dimi.common.paginator.model.ContentState
import com.example.dimi.common.paginator.model.PaginatorData
import com.example.dimi.common.paginator.model.PaginatorResult
import com.example.dimi.common.paginator.model.ViewState
import com.example.dimi.common.plus
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PaginatorImpl<T>
@Inject constructor() : Paginator<T> {

    companion object {
        const val FIRST_PAGE = 1
    }

    private lateinit var initRequest: () -> Completable
    private lateinit var databaseStream: () -> Flowable<List<T>>
    private lateinit var networkRequest: (Int) -> Completable

    private var paginatorResult: PaginatorResult<T>? = null
        set(value) {
            field = value
            paginatorResultLiveData.postValue(value)
            value?.let {
                if(it.viewState == ViewState.ERROR_MESSAGE) databaseMessageLiveData.postValue("DATABASE")
            }
        }

    private val paginatorResultLiveData: MutableLiveData<PaginatorResult<T>> = MutableLiveData()
    private val databaseMessageLiveData: MutableLiveData<String> = SingleEventLiveData()

    private var currentData: MutableList<T> = mutableListOf()
    private var currentState: State<T> = EMPTY()
    private var currentPage = 0
    private var requestDisposable: Disposable? = null
    private var databaseDisposable: CompositeDisposable = CompositeDisposable()

    override fun getData(): LiveData<PaginatorResult<T>> = paginatorResultLiveData

    override fun getSingleEvent(): LiveData<String> = databaseMessageLiveData

    override fun disposeAll() {
        currentState.release()
    }

    override fun setCallbacks(
        init: () -> Completable,
        database: () -> Flowable<List<T>>,
        nextData: (Int) -> Completable
    ) {
        initRequest = init
        databaseStream = database
        networkRequest = nextData
    }

    override fun refresh() {
        currentState.refresh()
    }

    override fun loadNewPage() {
        currentState.loadNewPage()
    }

    private fun loadPage(page: Int) {
        requestDisposable?.dispose()
        requestDisposable = networkRequest.invoke(page)
            .subscribe(
                { },
                { currentState.fail(it) }
            )
    }

    private fun makeInitRequest() {
        requestDisposable?.dispose()
        requestDisposable = initRequest.invoke()
            .doAfterTerminate(::checkDataBaseDisposable)
            .subscribe(
                { },
                { currentState.fail(it) }
            )
    }

    private fun checkDataBaseDisposable() {
        if (databaseDisposable.size() == 0) subscribeToDB()
    }

    private fun subscribeToDB() {
        databaseDisposable += databaseStream.invoke()
            .subscribe(
                { currentState.newData(it) },
                { currentState.fail(it) }
            )
    }

    private interface State<T> {
        fun refresh() {}
        fun loadNewPage() {}
        fun release() {}
        fun newData(data: List<T>) {}
        fun fail(error: Throwable) {}
    }

    private inner class EMPTY : State<T> {

        override fun refresh() {
            currentState = EMPTY_PROGRESS()
            paginatorResult =
                    PaginatorResult(viewState = ViewState.EMPTY_PROGRESS)
            makeInitRequest()
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class EMPTY_PROGRESS : State<T> {

        override fun newData(data: List<T>) {
            if (data.isNotEmpty()) {
                currentState = DATA()
                currentData.clear()
                currentData.addAll(data)
                currentPage = FIRST_PAGE
                val paginatorData = PaginatorData(
                    content = data,
                    state = ContentState.DATA
                )
                paginatorResult = PaginatorResult(
                    viewState = ViewState.DATA,
                    paginatorModelData = paginatorData
                )
            } else {
                currentState = EMPTY_DATA()
                paginatorResult =
                        PaginatorResult(viewState = ViewState.EMPTY_VIEW)
            }
        }

        override fun fail(error: Throwable) {
            currentState = DATABASE()
            paginatorResult = PaginatorResult(
                viewState = ViewState.ERROR_MESSAGE,
                paginatorModelData = PaginatorData(
                    content = currentData,
                    state = ContentState.DATA
                )
            )
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class DATABASE : State<T> {

        override fun refresh() {
            currentState = EMPTY_PROGRESS()
            paginatorResult =
                    PaginatorResult(viewState = ViewState.EMPTY_PROGRESS)
            makeInitRequest()
        }

        override fun newData(data: List<T>) {
            currentState = EMPTY()
            paginatorResult = if (data.isNotEmpty()) {
                currentData.clear()
                currentData.addAll(data)
                val paginatorData = PaginatorData(
                    content = data,
                    state = ContentState.DATA
                )
                PaginatorResult(paginatorModelData = paginatorData)
            } else {
                PaginatorResult(viewState = ViewState.EMPTY_VIEW)
            }
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class EMPTY_DATA : State<T> {

        override fun refresh() {
            currentState = EMPTY_PROGRESS()
            paginatorResult =
                    PaginatorResult(viewState = ViewState.EMPTY_PROGRESS)
            makeInitRequest()
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class DATA : State<T> {

        override fun refresh() {
            currentState = REFRESH()
            paginatorResult =
                    PaginatorResult(viewState = ViewState.REFRESH)
            makeInitRequest()
        }

        override fun loadNewPage() {
            currentState = PAGE_PROGRESS()
            val paginatorData = PaginatorData(
                content = currentData,
                state = ContentState.PROGRESS
            )
            paginatorResult =
                    PaginatorResult(paginatorModelData = paginatorData)
            loadPage(currentPage + 1)
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class REFRESH : State<T> {

        override fun newData(data: List<T>) {
            paginatorResult = if (data.isNotEmpty()) {
                currentState = DATA()
                currentData.clear()
                currentData.addAll(data)
                currentPage = FIRST_PAGE
                val paginatorData = PaginatorData(
                    content = data,
                    state = ContentState.DATA
                )
                PaginatorResult(paginatorModelData = paginatorData)
            } else {
                currentState = EMPTY_DATA()
                currentData.clear()
                val paginatorData = PaginatorData(
                    content = currentData,
                    state = ContentState.DATA
                )
                PaginatorResult(
                    viewState = ViewState.EMPTY_VIEW,
                    paginatorModelData = paginatorData
                )
            }
        }

        override fun fail(error: Throwable) {
            currentState = DATA()
            val paginatorData = PaginatorData(
                content = currentData,
                state = ContentState.ERROR
            )
            paginatorResult =
                    PaginatorResult(paginatorModelData = paginatorData)
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class PAGE_PROGRESS : State<T> {

        override fun newData(data: List<T>) {
            if (data.isNotEmpty()) {
                currentState = DATA()
                currentData.clear()
                currentData.addAll(data)
                currentPage++
            } else {
                currentState = ALL_DATA()
            }
            val paginatorData = PaginatorData(
                content = data,
                state = ContentState.DATA
            )
            paginatorResult =
                    PaginatorResult(paginatorModelData = paginatorData)
        }

        override fun refresh() {
            currentState = REFRESH()
            paginatorResult =
                    PaginatorResult(viewState = ViewState.REFRESH)
            makeInitRequest()
        }

        override fun fail(error: Throwable) {
            currentState = DATA()
            val paginatorData = PaginatorData(
                content = currentData,
                state = ContentState.ERROR
            )
            paginatorResult =
                    PaginatorResult(paginatorModelData = paginatorData)
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class ALL_DATA : State<T> {

        override fun refresh() {
            currentState = REFRESH()
            paginatorResult =
                    PaginatorResult(viewState = ViewState.REFRESH)
            makeInitRequest()
        }

        override fun release() {
            currentState = RELEASED()
            requestDisposable?.dispose()
            databaseDisposable.clear()
        }
    }

    private inner class RELEASED : State<T>
}