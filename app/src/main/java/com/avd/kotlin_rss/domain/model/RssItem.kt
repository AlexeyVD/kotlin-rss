package com.avd.kotlin_rss.domain.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

data class RssItem (
        private val title: String,
        private val description: String,
        private val pubDate: String,
        private val link: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(pubDate)
        parcel.writeString(link)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<RssItem> {
        override fun createFromParcel(parcel: Parcel) = RssItem(parcel)

        override fun newArray(size: Int): Array<RssItem?> = arrayOfNulls(size)
    }
}