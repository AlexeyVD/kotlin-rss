package com.avd.kotlin_rss.presentation.presenter

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

interface Presenter<T> {
    fun attachView(view: T)
    fun detachView()
}