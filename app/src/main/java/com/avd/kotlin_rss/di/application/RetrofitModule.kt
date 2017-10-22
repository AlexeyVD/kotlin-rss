package com.avd.kotlin_rss.di.application

import com.avd.kotlin_rss.BuildConfig
import com.avd.kotlin_rss.data.network.RssService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 11.10.2017.
 */

@Module
class RetrofitModule {

    companion object {
        val TIMEOUT_SECONDS = 30L
    }

    @Provides
    @Singleton
    fun provideTimeout() = TIMEOUT_SECONDS

    @Provides
    @Singleton
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient(timeout: Long): OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(timeout, TimeUnit.SECONDS)
                    .readTimeout(timeout, TimeUnit.SECONDS)
                    .writeTimeout(timeout, TimeUnit.SECONDS)
                    .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(baseUrl)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()

    @Provides
    @Singleton
    fun provideRssService(retrofit: Retrofit): RssService = retrofit.create(RssService::class.java)
}