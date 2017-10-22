package com.avd.kotlin_rss.presentation.view.rss_list

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.avd.kotlin_rss.R
import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.ext.getApp
import com.avd.kotlin_rss.ext.gone
import com.avd.kotlin_rss.ext.visible
import com.avd.kotlin_rss.presentation.base.BaseActivity
import com.avd.kotlin_rss.presentation.presenter.rss_list.RssListPresenter
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_rss_list.*
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import android.view.View
import kotlinx.android.synthetic.main.item_rss_list.*


/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

class RssListActivity : BaseActivity(), RssListView {

    @Inject lateinit var mPresenter: RssListPresenter

    private lateinit var mAdapter: RssListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApp().getAppComponent()
                .rssListComponentBuilder()
                .build()
                .inject(this)
        initPresenter()
        initRecycler()
    }

    override fun getLayoutId() = R.layout.activity_rss_list

    private fun initPresenter() {
        mPresenter.attachView(this)
        mPresenter.loadRssNews()
        initSwipeToRefresh()
    }

    private fun initRecycler() {
        mAdapter = RssListAdapter(mPresenter)
        rss_list_recycler.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_gray))
        rss_list_recycler.addItemDecoration(decoration)
        rss_list_recycler.adapter = mAdapter
    }

    private fun initSwipeToRefresh() {
        swipe_to_refresh.setColorSchemeResources(R.color.colorAccent)
        swipe_to_refresh.setOnRefreshListener { mPresenter.updateRssNews() }
    }

    override fun setNews(newsList: List<RssItem>) {
        Log.i("RssListActivity", "${newsList.size}")
        mAdapter.setElements(newsList)
        mAdapter.notifyDataSetChanged()
        rss_list_recycler.scheduleLayoutAnimation()
    }

    override fun hideLoading() {
        progress.gone()
        rss_list_recycler.visible()
        swipe_to_refresh.isRefreshing = false
    }

    override fun showLoading() {
        progress.visible()
        rss_list_recycler.gone()
    }

    override fun startDetailView(item: RssItem, view: View) {
        val intent = Intent(this, RssDetailActivity::class.java)
        intent.putExtra(RssDetailActivity.RSS_ITEM, item)
//        val options = makeSceneTransitionAnimation(this, view, "item_title")
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            startActivity(intent, options.toBundle())
//        } else {
//            startActivity(intent)
//        }
        startActivity(intent)
    }
}