package eu.wejsonekk.bombocraft.configuration

import net.dzikoysk.cdn.source.Resource
import java.io.File

interface ReloadableConfig {
    fun resource(folder: File?): Resource?
}
