package com.avd.kotlin_rss

import android.app.Application
import android.content.Context
import com.avd.kotlin_rss.di.application.AppComponent
import com.avd.kotlin_rss.di.application.DaggerAppComponent
import com.avd.kotlin_rss.di.application.RetrofitModule

/**
 * Created by Aleksey Dementyev on 16.10.2017.
 */

class RssApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .context(this)
                .retrofitModule(RetrofitModule())
                .build();
    }

    fun getAppComponent() = appComponent
}