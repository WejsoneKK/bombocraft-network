package eu.wejsonekk.bombocraft.feature.shop.category;

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;

import java.io.File;

public class ShopArmorCategoryConfiguration implements ReloadableConfig {
    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "shops/armor-category.yml");
    }
}
