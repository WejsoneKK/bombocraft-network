package eu.wejsonekk.bombocraft.commands.implementation;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import org.bukkit.entity.Player;

@Command(name = "store", aliases = {"bombo-store", "getastore", "buyabombo"})
public class StoreCommand {

    private NotificationAnnouncer announcer;
    private MessageConfiguration messages;

    public StoreCommand(NotificationAnnouncer announcer, MessageConfiguration messages) {
        this.announcer = announcer;
        this.messages = messages;
    }


    @Execute
    void sendStore(@Context Player player){
        this.messages.standardCommands.StoreCommand
                .stream()
                .forEach(messages -> {
                    this.announcer.sendMessage(player, messages);
                });
    }
}
