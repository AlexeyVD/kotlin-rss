package com.avd.kotlin_rss.domain.repository

import com.avd.kotlin_rss.domain.model.RssItem
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

interface RssRepository {
    fun getRssList(): Single<List<RssItem>>
}