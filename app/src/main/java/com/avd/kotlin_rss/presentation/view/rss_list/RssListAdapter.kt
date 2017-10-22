package com.avd.kotlin_rss.presentation.view.rss_list

import android.view.View
import com.avd.kotlin_rss.R
import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.presentation.base.BaseAdapter
import com.avd.kotlin_rss.presentation.base.OnItemClickListener

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

class RssListAdapter(private val listener: OnItemClickListener<RssItem>) :
        BaseAdapter<RssItem, RssListViewHolder>() {

    override fun getItemLayoutId() = R.layout.item_rss_list

    override fun getViewHolder(itemView: View) = RssListViewHolder(itemView, listener)
}