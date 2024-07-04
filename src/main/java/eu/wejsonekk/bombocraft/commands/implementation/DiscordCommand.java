package eu.wejsonekk.bombocraft.commands.implementation;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import lombok.Getter;
import org.bukkit.entity.Player;

@Command(name = "discord", aliases = {"dcserver", "teamspeak", "ts3", "dcserwer", "discordserwer"})
public class DiscordCommand {

    private final NotificationAnnouncer announcer;
    private final MessageConfiguration messages;

    public DiscordCommand(NotificationAnnouncer announcer, MessageConfiguration messages) {
        this.announcer = announcer;
        this.messages = messages;
    }

    @Execute
    void execute(@Context Player player){
        this.messages.standardCommands.DiscordCommand
                .stream().forEach(messages -> this.announcer.sendMessage(player, messages));
    }
    @Execute(name = "sync")
    @Permission("starblock.command.discord.sync")
    void executeSyncDiscord(@Context Player player){
        this.announcer.sendMessage(player, "not found message for common.discord.sync");
    }


}
