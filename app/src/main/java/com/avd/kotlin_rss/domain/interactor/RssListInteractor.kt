package com.avd.kotlin_rss.domain.interactor

import com.avd.kotlin_rss.domain.model.RssItem
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

interface RssListInteractor {
    fun getRssList(): Single<List<RssItem>>
}