package com.avd.kotlin_rss.ext

import android.view.View

/**
 * Created by Aleksey Dementyev on 21.10.2017.
 */

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}