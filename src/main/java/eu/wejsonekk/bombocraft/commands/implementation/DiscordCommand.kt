package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import dev.rollczi.litecommands.annotations.permission.Permission
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer
import org.bukkit.entity.Player

@Command(name = "discord", aliases = ["dcserver", "teamspeak", "ts3", "dcserwer", "discordserwer"])
class DiscordCommand(private val announcer: NotificationAnnouncer, private val messages: MessageConfiguration) {
    @Execute
    fun execute(@Context player: Player?) {
        messages.DiscordCommand
            .stream().forEach { messages: String? -> announcer.sendMessage(player, messages) }
    }

    @Execute(name = "sync")
    @Permission("starblock.command.discord.sync")
    fun executeSyncDiscord(@Context player: Player?) {
        announcer.sendMessage(player, "not found message for common.discord.sync")
    }
}
