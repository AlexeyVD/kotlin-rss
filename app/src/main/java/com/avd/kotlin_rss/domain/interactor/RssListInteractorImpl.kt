package com.avd.kotlin_rss.domain.interactor

import com.avd.kotlin_rss.domain.repository.RssRepository

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

class RssListInteractorImpl(private val repository: RssRepository) : RssListInteractor {
    override fun getRssList() = repository.getRssList()
}