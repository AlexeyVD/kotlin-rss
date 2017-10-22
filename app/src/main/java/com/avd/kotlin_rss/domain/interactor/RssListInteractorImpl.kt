package com.avd.kotlin_rss.domain.interactor

import com.avd.kotlin_rss.di.rss_list.RssListScope
import com.avd.kotlin_rss.domain.repository.RssRepository
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

@RssListScope
class RssListInteractorImpl @Inject constructor(val repository: RssRepository) : RssListInteractor {
    override fun getRssList() = repository.getRssList()
}