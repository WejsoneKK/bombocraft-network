package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer
import org.bukkit.entity.Player

@Command(name = "youtube", aliases = ["yt"])
class YoutubeCommand(private val messages: MessageConfiguration, private val announcer: NotificationAnnouncer) {
    @Execute
    fun executeYoutube(@Context player: Player?) {
        messages.youtubeCommand
            .stream()
            .forEach { messages: String? ->
                announcer.sendMessage(player, messages)
            }
    }
}
