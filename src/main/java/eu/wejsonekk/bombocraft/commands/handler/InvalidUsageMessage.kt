package eu.wejsonekk.bombocraft.commands.handler;

import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invalidusage.InvalidUsageHandler;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.schematic.Schematic;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import org.bukkit.command.CommandSender;
import panda.utilities.text.Formatter;

public class InvalidUsageMessage implements InvalidUsageHandler<CommandSender> {

    private final NotificationAnnouncer notificationAnnouncer;
    private final MessageConfiguration messageConfiguration;

    public InvalidUsageMessage(NotificationAnnouncer notificationAnnouncer, MessageConfiguration messageConfiguration) {
        this.notificationAnnouncer = notificationAnnouncer;
        this.messageConfiguration = messageConfiguration;
    }


    @Override
    public void handle(Invocation<CommandSender> invocation, dev.rollczi.litecommands.invalidusage.InvalidUsage<CommandSender> result, ResultHandlerChain<CommandSender> chain) {
        CommandSender sender = invocation.sender();
        Schematic schematic = result.getSchematic();

        if (schematic.isOnlyFirst()) {
            Formatter formatter = new Formatter()
                    .register("{COMMAND}", schematic.first());
            this.notificationAnnouncer.sendMessage(sender, formatter.format(this.messageConfiguration.wrongUsage.invalidUsage));
            return;
        }
        this.notificationAnnouncer.sendMessage(sender, this.messageConfiguration.wrongUsage.invalidUsageHeader);
        for(String scheme : schematic.all()){
            Formatter formatter = new Formatter()
                    .register("{COMMAND}", scheme);


            this.notificationAnnouncer.sendMessage(sender, formatter.format(this.messageConfiguration.wrongUsage.invalidUsageEntry));
        }
    }
}