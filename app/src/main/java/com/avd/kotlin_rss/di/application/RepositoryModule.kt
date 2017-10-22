package com.avd.kotlin_rss.di.application

import com.avd.kotlin_rss.data.network.RssService
import com.avd.kotlin_rss.data.repository.RssRetrofitRepository
import com.avd.kotlin_rss.domain.repository.RssRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 16.10.2017.
 */

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideRssRepository(repository: RssRetrofitRepository): RssRepository
}