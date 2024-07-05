package eu.wejsonekk.bombocraft.hook.implementation;

import eu.wejsonekk.bombocraft.hook.Hook;
import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Server;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook implements Hook {

    private final Server server;
    @Getter
    private Economy economy;

    public VaultHook(Server server) {
        this.server = server;
    }

    @Override
    public void initialize() {
        RegisteredServiceProvider<Economy> economyProvider = this.server.getServicesManager().getRegistration(Economy.class);

        if (economyProvider == null) {
            throw new IllegalStateException("Vault founded, but you don't have a plugin that supports economy");
        }

        this.economy = economyProvider.getProvider();
    }

    @Override
    public String pluginName() {
        return "Vault";
    }

}