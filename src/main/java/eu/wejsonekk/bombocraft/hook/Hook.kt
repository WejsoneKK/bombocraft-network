package eu.wejsonekk.bombocraft.hook

interface Hook {
    fun initialize()

    fun pluginName(): String?
}