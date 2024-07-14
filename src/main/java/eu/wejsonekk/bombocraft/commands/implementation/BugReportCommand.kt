package eu.wejsonekk.bombocraft.commands.implementation;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.join.Join;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.wejsonekk.bombocraft.configuration.implementation.PluginConfiguration;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import panda.utilities.text.Formatter;

@Command(name = "bugreport", aliases = {"bug-report", "br", "breport"})
@Permission("bombocraft.command.bugreport.sent")
public class BugReportCommand {

    private PluginConfiguration configuration;
    private NotificationAnnouncer announcer;

    public BugReportCommand(PluginConfiguration configuration, NotificationAnnouncer announcer) {
        this.configuration = configuration;
        this.announcer = announcer;
    }

    @Execute
    void sendReportMessage(@Context Player player, @Join String message){

        for(Player players : Bukkit.getOnlinePlayers()){
            if(players.hasPermission("bombocraft.command.bugreport.see")){
                Formatter bugReportPLaceholder = new Formatter()
                        .register("{message}", message)
                        .register("{MESSAGE}", message);

                this.announcer.sendMessage(players, bugReportPLaceholder.format("&4&lBUGREPORT &8» {message}"));
            }
        }
    }
}
