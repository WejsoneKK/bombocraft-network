package eu.wejsonekk.bombocraft.commands.handler

import dev.rollczi.litecommands.handler.result.ResultHandlerChain
import dev.rollczi.litecommands.invalidusage.InvalidUsage
import dev.rollczi.litecommands.invalidusage.InvalidUsageHandler
import dev.rollczi.litecommands.invocation.Invocation
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer
import org.bukkit.command.CommandSender
import panda.utilities.text.Formatter

class InvalidUsageMessage(
    private val notificationAnnouncer: NotificationAnnouncer,
    private val messageConfiguration: MessageConfiguration
) : InvalidUsageHandler<CommandSender?> {
    override fun handle(
        invocation: Invocation<CommandSender?>?,
        result: InvalidUsage<CommandSender?>?,
        chain: ResultHandlerChain<CommandSender?>?
    ) {
        val sender = invocation?.sender()
        val schematic = result?.schematic

        if (schematic?.isOnlyFirst!!) {
            val formatter = Formatter()
                .register("{COMMAND}", schematic.first())
            notificationAnnouncer.sendMessage(sender, formatter.format(messageConfiguration.invalidUsage))
            return
        }
        notificationAnnouncer.sendMessage(sender, messageConfiguration.invalidUsageHeader)
        for (scheme in schematic.all()) {
            val formatter = Formatter()
                .register("{COMMAND}", scheme)


            notificationAnnouncer.sendMessage(
                sender,
                formatter.format(messageConfiguration.invalidUsageEntry)
            )
        }
    }
}