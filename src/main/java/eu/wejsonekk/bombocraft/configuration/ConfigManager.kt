package eu.wejsonekk.bombocraft.configuration

import eu.wejsonekk.bombocraft.configuration.composer.DurationComposer
import net.dzikoysk.cdn.Cdn
import net.dzikoysk.cdn.CdnException
import net.dzikoysk.cdn.CdnFactory
import net.dzikoysk.cdn.reflect.Visibility
import java.io.File
import java.time.Duration

class ConfigManager(private val dataFolder: File) {
    private val cdn: Cdn = CdnFactory
        .createYamlLike()
        .settings
        .withMemberResolver(Visibility.PRIVATE)
        .withComposer(Duration::class.java, DurationComposer())
        .build()

    private val configs: MutableSet<ReloadableConfig> = HashSet()

    fun <T : ReloadableConfig?> load(config: T): T {
        cdn.load<T>(config!!.resource(this.dataFolder)!!, config)
            .orThrow { cause: CdnException? -> RuntimeException(cause) }

        cdn.render(config, config.resource(this.dataFolder)!!)
            .orThrow { cause: CdnException? -> RuntimeException(cause) }

        configs.add(config)

        return config
    }

    fun <T : ReloadableConfig> save(config: T) {
        cdn.render(config, config!!.resource(this.dataFolder)!!)
            .orThrow { cause: CdnException? -> RuntimeException(cause) }
    }

    fun reload() {
        for (config in this.configs) {
            this.load(config)
        }
    }
}
