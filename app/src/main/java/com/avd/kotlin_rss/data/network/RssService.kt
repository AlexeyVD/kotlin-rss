package com.avd.kotlin_rss.data.network

import com.avd.kotlin_rss.data.network.model.Rss
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

interface RssService {
    @GET("interesting")
    fun getRss(): Single<Rss>
}