package com.avd.kotlin_rss.presentation.base

import android.view.View

/**
 * Created by Aleksey Dementyev on 22.10.2017.
 */

interface OnItemClickListener<T> {
    fun onItemClick(item: T, view: View)
}