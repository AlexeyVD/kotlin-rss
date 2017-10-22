package com.avd.kotlin_rss.presentation.view.rss_list

import android.os.Bundle
import android.support.transition.Fade
import android.support.transition.TransitionManager
import android.view.MenuItem
import com.avd.kotlin_rss.R
import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.ext.visible
import com.avd.kotlin_rss.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_rss_detail.*

/**
 * Created by Aleksey Dementyev on 22.10.2017.
 */

class RssDetailActivity : BaseActivity() {

    companion object {
        val RSS_ITEM = "RSS_ITEM"
    }

    private lateinit var item: RssItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getParcelableExtra(RSS_ITEM)
        item_title.text = item.title
//        val fade = Fade()
//        fade.duration = 5000
//        TransitionManager.beginDelayedTransition(detail_layout, fade)
        item_descr.loadData(item.description, "text/html; charset=utf-8", "UTF-8")
        item_descr.visible()

    }

    override fun getLayoutId() = R.layout.activity_rss_detail

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}