package eu.wejsonekk.bombocraft.feature.npc;

import eu.wejsonekk.bombocraft.hook.Hook;
import org.bukkit.Bukkit;

public class CitizensNPCHook implements Hook {

    @Override
    public void initialize() {

        Bukkit.getLogger().info("This feature available made in future");
    }

    @Override
    public String pluginName() {
        return "Citizens";
    }
}
