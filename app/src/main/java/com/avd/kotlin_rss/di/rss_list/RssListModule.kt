package com.avd.kotlin_rss.di.rss_list

import com.avd.kotlin_rss.domain.interactor.RssListInteractor
import com.avd.kotlin_rss.domain.interactor.RssListInteractorImpl
import com.avd.kotlin_rss.presentation.presenter.rss_list.RssListPresenter
import com.avd.kotlin_rss.presentation.presenter.rss_list.RssListPresenterImpl
import dagger.Binds
import dagger.Module

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

@Module
@RssListScope
interface RssListModule {

    @Binds
    @RssListScope
    fun provideRssListInteractor(interactor: RssListInteractorImpl): RssListInteractor

    @Binds
    @RssListScope
    fun provideRssListPresenter(presenter: RssListPresenterImpl): RssListPresenter
}