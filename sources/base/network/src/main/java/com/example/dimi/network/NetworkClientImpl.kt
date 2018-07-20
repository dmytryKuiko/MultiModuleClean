package com.example.dimi.network

import com.example.dimi.common.network.GenreWrapper
import com.example.dimi.common.network.NetworkClient
import com.example.dimi.common.network.Movie
import com.example.dimi.common.network.PopularMovies
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class NetworkClientImpl
@Inject constructor(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory,
    rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
) : NetworkClient {

    private val retrofitService: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build().create(RetrofitService::class.java)
    }

    override fun getGenres(): Single<out GenreWrapper> = retrofitService.getGenres()

    override fun getMovieById(id: Int): Single<out Movie> = retrofitService.getMovieById(id)

    override fun getPopularMoviesByPage(page: Int): Single<out PopularMovies> =
        retrofitService.getPopularMoviesByPage(page)

    companion object {
        const val SERVER_URL = "https://api.themoviedb.org/"
    }
}