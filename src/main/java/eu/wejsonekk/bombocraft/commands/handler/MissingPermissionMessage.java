package eu.wejsonekk.bombocraft.commands.handler;

import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.permission.MissingPermissions;
import dev.rollczi.litecommands.permission.MissingPermissionsHandler;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import org.bukkit.command.CommandSender;
import panda.utilities.text.Formatter;

public class MissingPermissionMessage implements MissingPermissionsHandler<CommandSender> {

    private final MessageConfiguration messageConfiguration;
    private final NotificationAnnouncer messageAnnouncer;

    public MissingPermissionMessage(MessageConfiguration messageConfiguration, NotificationAnnouncer messageAnnouncer) {
        this.messageConfiguration = messageConfiguration;
        this.messageAnnouncer = messageAnnouncer;
    }


    @Override
    public void handle(Invocation<CommandSender> invocation, MissingPermissions missingPermissions, ResultHandlerChain<CommandSender> resultHandlerChain) {

        String permissions = missingPermissions.asJoinedText();
        CommandSender sender = invocation.sender();

        Formatter formatter = new Formatter()
                .register("{PERMISSION}", missingPermissions.getPermissions().get(0))
                .register("{permission}", missingPermissions.getPermissions().get(0));
        this.messageAnnouncer.sendMessage(sender, formatter.format(this.messageConfiguration.wrongUsage.noPermission));

    }
}