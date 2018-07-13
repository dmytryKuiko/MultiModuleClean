package com.example.dimi.network.di

import android.util.Base64
import com.example.dimi.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor
@Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val httpUrlBuilder = request.url().newBuilder()

        val newUrl = httpUrlBuilder.addQueryParameter(API_KEY, API_KEY_VALUE).build()
        val requestBuilder = request.newBuilder().url(newUrl)

        return chain.proceed(requestBuilder.build())
    }


    companion object {

        const val API_KEY = "api_key"

        val API_KEY_VALUE: String = String(Base64.decode(BuildConfig.API_KEY, Base64.DEFAULT))
    }
}