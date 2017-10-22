package com.avd.kotlin_rss.di.rss_list

import com.avd.kotlin_rss.presentation.view.rss_list.RssListActivity
import dagger.Subcomponent

/**
 * Created by Aleksey Dementyev on 16.10.2017.
 */

@Subcomponent(modules = arrayOf(RssListModule::class))
@RssListScope
interface RssListComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): RssListComponent
    }

    fun inject(rssListActivity: RssListActivity)
}