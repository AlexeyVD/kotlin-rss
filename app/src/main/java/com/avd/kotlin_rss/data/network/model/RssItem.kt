package com.avd.kotlin_rss.data.network.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

@Root(name = "item", strict = false)
class RssItem() : Serializable {
    @Element(name = "title") lateinit var title: String
    @Element(name = "description") lateinit var description: String
    @Element(name = "pubDate") lateinit var pubDate: String
    @Element(name = "link") lateinit var link: String
    @Element(name = "guid") lateinit var guid: String

    constructor(title: String, description: String, pubDate: String, link: String,
                guid: String) : this() {
        this.title = title
        this.description = description
        this.pubDate = pubDate
        this.link = link
        this.guid = guid
    }
}