package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer
import org.bukkit.entity.Player

@Command(name = "website", aliases = ["strona"])
class WebSiteCommand(private val announcer: NotificationAnnouncer, private val messages: MessageConfiguration) {
    @Execute
    fun execute(@Context player: Player?) {
        messages.WebsiteCommand
            .stream()
            .forEach { messages: String? ->
                announcer.sendMessage(player, messages)
            }
    }
}
