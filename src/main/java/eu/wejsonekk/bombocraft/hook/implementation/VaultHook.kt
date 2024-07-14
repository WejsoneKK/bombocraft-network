package eu.wejsonekk.bombocraft.hook.implementation

import eu.wejsonekk.bombocraft.hook.Hook
import lombok.Getter
import net.milkbowl.vault.economy.Economy
import org.bukkit.Server

class VaultHook(private val server: Server) : Hook {
    @Getter
    private var economy: Economy? = null

    override fun initialize() {
        val economyProvider = server.servicesManager.getRegistration(
            Economy::class.java
        )

        checkNotNull(economyProvider) { "Vault founded, but you don't have a plugin that supports economy" }

        this.economy = economyProvider.provider
    }

    override fun pluginName(): String {
        return "Vault"
    }
}