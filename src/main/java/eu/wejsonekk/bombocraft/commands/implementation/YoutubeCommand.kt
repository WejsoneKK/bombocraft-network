package eu.wejsonekk.bombocraft.commands.implementation;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import org.bukkit.entity.Player;

@Command(name = "youtube", aliases = {"yt"})
public class YoutubeCommand {

    private MessageConfiguration messages;
    private NotificationAnnouncer announcer;

    public YoutubeCommand(MessageConfiguration messages, NotificationAnnouncer announcer) {
        this.messages = messages;
        this.announcer = announcer;
    }

    @Execute
    void executeYoutube(@Context Player player){

        this.messages.standardCommands.youtubeCommand
                .stream()
                .forEach(messages -> {
                    this.announcer.sendMessage(player, messages);
                });
    }
}
