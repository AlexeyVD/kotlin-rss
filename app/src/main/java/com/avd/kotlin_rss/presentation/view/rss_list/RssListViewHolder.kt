package com.avd.kotlin_rss.presentation.view.rss_list

import android.view.View
import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.presentation.base.BaseViewHolder
import com.avd.kotlin_rss.presentation.base.OnItemClickListener
import kotlinx.android.synthetic.main.item_rss_list.view.*

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

class RssListViewHolder(itemView: View, private val listener: OnItemClickListener<RssItem>) :
        BaseViewHolder<RssItem>(itemView), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    lateinit var mItem: RssItem

    override fun bind(item: RssItem) {
        mItem = item
        itemView.item_title.text = item.title
    }

    override fun onClick(p0: View?) {
        listener.onItemClick(mItem, itemView)
    }
}