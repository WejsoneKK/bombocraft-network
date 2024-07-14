package eu.wejsonekk.bombocraft.configuration.implementation

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig
import net.dzikoysk.cdn.entity.Contextual
import net.dzikoysk.cdn.source.Resource
import net.dzikoysk.cdn.source.Source
import java.io.File
@Contextual
class PluginConfiguration : ReloadableConfig {


    private var isDebugMode = false

    override fun resource(folder: File?): Resource? {
        return folder?.let { Source.of(it, "config.yml") }
    }
}
