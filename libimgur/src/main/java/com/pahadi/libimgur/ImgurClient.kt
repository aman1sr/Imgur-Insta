package com.pahadi.libimgur

import com.pahadi.libimgur.apis.ImgurAPI
import com.pahadi.libimgur.converters.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object ImgurClient {
    public const val API_KEY = "3b83342550039bd"   // todo: put the static api key,

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("Authorization","Client-ID $API_KEY")
                    .build()
                it.proceed(request)
            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("https://api.imgur.com/3/")        // todo: add base url
            .build()
    }

    val api : ImgurAPI by lazy {
        retrofit.create(ImgurAPI::class.java)
    }

}