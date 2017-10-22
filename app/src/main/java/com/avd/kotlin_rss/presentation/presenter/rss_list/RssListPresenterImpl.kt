package com.avd.kotlin_rss.presentation.presenter.rss_list

import android.util.Log
import android.view.View
import com.avd.kotlin_rss.domain.interactor.RssListInteractor
import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.presentation.view.rss_list.RssListView
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */


class RssListPresenterImpl @Inject constructor(val interactor: RssListInteractor) :
        RssListPresenter {

    companion object {
        val TAG: String = RssListPresenterImpl::class.java.simpleName
    }

    private var mView: RssListView? = null

    override fun attachView(view: RssListView) {
        mView = view;
    }

    override fun detachView() {
        mView = null
    }

    override fun loadRssNews() {
        mView?.showLoading()
        updateRssNews()
    }

    override fun updateRssNews() {
        interactor.getRssList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView?.setNews(it)
                    mView?.hideLoading()
                }, { it.printStackTrace()})
    }

    override fun onItemClick(item: RssItem, view: View) {
        mView?.startDetailView(item, view)
    }
}