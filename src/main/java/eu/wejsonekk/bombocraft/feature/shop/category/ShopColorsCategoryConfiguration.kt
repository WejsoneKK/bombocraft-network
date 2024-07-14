package eu.wejsonekk.bombocraft.feature.shop.category

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig
import net.dzikoysk.cdn.source.Resource
import net.dzikoysk.cdn.source.Source
import java.io.File

class ShopColorsCategoryConfiguration : ReloadableConfig {
    override fun resource(folder: File?): Resource {

        return folder?.let { Source.of(it, "shops/colors-category.yml") }!!
    }
}
