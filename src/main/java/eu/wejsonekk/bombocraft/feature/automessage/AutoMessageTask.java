package eu.wejsonekk.bombocraft.feature.automessage;

import eu.wejsonekk.bombocraft.BomboCraftPlugin;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
@AllArgsConstructor
public class AutoMessageTask extends BukkitRunnable {

    private BomboCraftPlugin plugin;
    private NotificationAnnouncer announcer;

    @Override
    public void run() {

        // send message from configuration file

        for(Player players : Bukkit.getOnlinePlayers()){
            this.announcer.sendMessage(players, "BOMBOCRAFT AUTO-MSG " + getTaskId());
        }
        this.runTaskTimer(this.plugin, 0L, 60L * 20L);
    }
}
