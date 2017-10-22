package com.avd.kotlin_rss.di.application

import android.content.Context
import com.avd.kotlin_rss.di.rss_list.RssListComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Aleksey Dementyev on 11.10.2017.
 */

@Component(modules = arrayOf(RetrofitModule::class, RepositoryModule::class))
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun retrofitModule(retrofitModule: RetrofitModule): Builder
        fun build(): AppComponent
    }

    fun rssListComponentBuilder(): RssListComponent.Builder
}