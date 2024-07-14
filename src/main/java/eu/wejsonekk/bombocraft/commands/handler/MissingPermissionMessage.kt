package eu.wejsonekk.bombocraft.commands.handler

import dev.rollczi.litecommands.handler.result.ResultHandlerChain
import dev.rollczi.litecommands.invocation.Invocation
import dev.rollczi.litecommands.permission.MissingPermissions
import dev.rollczi.litecommands.permission.MissingPermissionsHandler
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer
import org.bukkit.command.CommandSender
import panda.utilities.text.Formatter

class MissingPermissionMessage(
    private val messageConfiguration: MessageConfiguration,
    private val messageAnnouncer: NotificationAnnouncer
) : MissingPermissionsHandler<CommandSender?> {
    override fun handle(
        invocation: Invocation<CommandSender?>,
        missingPermissions: MissingPermissions,
        resultHandlerChain: ResultHandlerChain<CommandSender?>
    ) {
        val permissions = missingPermissions.asJoinedText()
        val sender = invocation.sender()

        val formatter = Formatter()
            .register("{permissions}", permissions)
            .register("{PERMISSIONS}", permissions)
            .register("{PERMISSION}", permissions)
            .register("{permission}", permissions)

        messageAnnouncer.sendMessage(sender, formatter.format(messageConfiguration.noPermission))
    }
}