package com.avd.kotlin_rss.presentation.view.rss_list

import android.view.View
import com.avd.kotlin_rss.domain.model.RssItem

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

interface RssListView {
    fun showLoading()
    fun hideLoading()
    fun setNews(newsList: List<RssItem>)
    fun startDetailView(item: RssItem, view: View)
}