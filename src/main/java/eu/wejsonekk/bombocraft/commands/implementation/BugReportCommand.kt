package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import dev.rollczi.litecommands.annotations.join.Join
import dev.rollczi.litecommands.annotations.permission.Permission
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration
import eu.wejsonekk.bombocraft.configuration.implementation.PluginConfiguration
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import panda.utilities.text.Formatter

@Command(name = "bugreport", aliases = ["bug-report", "br", "breport"])
@Permission("bombocraft.command.bugreport.sent")
class BugReportCommand(
    private val configuration: PluginConfiguration,
    private val announcer: NotificationAnnouncer,
    private val messages: MessageConfiguration
) {
    @Execute
    fun sendReportMessage(@Context player: Player, @Join message: String?) {
        for (players in Bukkit.getOnlinePlayers()) {
            if (players.hasPermission("bombocraft.command.bugreport.see")) {
                val bugReportPLaceholder: Formatter = Formatter()
                    .register("{message}", message)
                    .register("{player}", player.name)
                    .register("{nick}", player.name);

                announcer.sendMessage(
                    players,
                    bugReportPLaceholder.format(messages.bugReportFormatMessage)
                )
            }
            announcer.sendMessage(player, messages.bugReportMessageSent)
        }
    }
}
