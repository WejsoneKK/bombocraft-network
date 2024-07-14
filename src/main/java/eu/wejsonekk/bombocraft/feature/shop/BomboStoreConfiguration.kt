package eu.wejsonekk.bombocraft.feature.shop

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig
import net.dzikoysk.cdn.source.Resource
import net.dzikoysk.cdn.source.Source
import java.io.File


class BomboStoreConfiguration : ReloadableConfig {




    override fun resource(folder: File?): Resource? {
        return folder?.let { Source.of(it, "shops/bombostore.yml") }
    }
}
