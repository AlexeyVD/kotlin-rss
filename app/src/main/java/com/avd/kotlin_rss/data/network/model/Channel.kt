package com.avd.kotlin_rss.data.network.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

@Root(name = "channel", strict = false)
class Channel() : Serializable {
    @ElementList(inline = true, name = "item") lateinit var rssList: List<RssItem>

    constructor(rssList: List<RssItem>) : this() {
        this.rssList = rssList
    }
}