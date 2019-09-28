package ru.nikiz.legocatalog.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nikiz.data.net.LegoService
import ru.nikiz.legocatalog.BuildConfig
import java.util.concurrent.TimeUnit


val network = module {
    single { createOkHttpClient() }
    single { createWebService<LegoService>(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.BASIC
    }
    return OkHttpClient.Builder()
        .connectTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(LegoService.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(T::class.java)
}