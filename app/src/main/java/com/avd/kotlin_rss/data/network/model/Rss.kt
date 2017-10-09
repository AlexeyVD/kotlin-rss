package com.avd.kotlin_rss.data.network.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

/**
 * Created by Aleksey Dementyev on 09.10.2017.
 */

@Root(name = "rss", strict = false)
class Rss() : Serializable {
    @Element(name = "channel") lateinit var channel: Channel

    constructor(channel: Channel) : this() {
        this.channel = channel
    }
}