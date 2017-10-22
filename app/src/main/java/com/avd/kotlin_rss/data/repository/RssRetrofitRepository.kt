package com.avd.kotlin_rss.data.repository

import com.avd.kotlin_rss.data.network.RssService
import com.avd.kotlin_rss.domain.model.RssItem
import com.avd.kotlin_rss.domain.repository.RssRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

@Singleton
class RssRetrofitRepository @Inject constructor(val rssService: RssService) : RssRepository {
    override fun getRssList(): Single<List<RssItem>> =
            rssService.getRss()
                    .map {
                        it.channel.rssList.map {
                            RssItem(it.title, it.description, it.pubDate, it.link)
                        }
                    }

}