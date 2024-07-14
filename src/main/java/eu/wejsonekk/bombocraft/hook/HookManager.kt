package eu.wejsonekk.bombocraft.hook

import org.bukkit.Server
import java.util.logging.Logger

class HookManager(private val server: Server, private val logger: Logger) {
    fun initialize(hook: Hook) {
        val pluginManager = server.pluginManager

        if (pluginManager.isPluginEnabled(hook.pluginName()!!)) {
            hook.initialize()

            logger.info("Hooked into " + hook.pluginName())
        }
    }
}