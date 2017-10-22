package com.avd.kotlin_rss.data.network.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

@Root(name = "item", strict = false)
class RssItem() : Serializable {

    @set:Element(name = "title")
    @get:Element(name = "title")
    lateinit var title: String

    @set:Element(name = "description")
    @get:Element(name = "description")
    lateinit var description: String

    @set:Element(name = "pubDate")
    @get:Element(name = "pubDate")
    lateinit var pubDate: String

    @set:Element(name = "link")
    @get:Element(name = "link")
    lateinit var link: String

    @set:Element(name = "guid")
    @get:Element(name = "guid")
    lateinit var guid: String


    constructor(title: String, description: String, pubDate: String, link: String,
                guid: String) : this() {
        this.title = title
        this.description = description
        this.pubDate = pubDate
        this.link = link
        this.guid = guid
    }
}