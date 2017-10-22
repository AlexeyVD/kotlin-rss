package com.avd.kotlin_rss.presentation.presenter.rss_list

import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.presentation.base.OnItemClickListener
import com.avd.kotlin_rss.presentation.presenter.Presenter
import com.avd.kotlin_rss.presentation.view.rss_list.RssListView

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

interface RssListPresenter : Presenter<RssListView>, OnItemClickListener<RssItem> {
    fun loadRssNews()
    fun updateRssNews()
}