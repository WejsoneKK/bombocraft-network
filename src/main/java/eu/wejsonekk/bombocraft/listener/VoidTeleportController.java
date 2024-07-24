package eu.wejsonekk.bombocraft.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class VoidTeleportController implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();

        Location loc = player.getLocation();

        if(loc.getBlockY() < -50 ){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/spawn " + player.getName());
        }
    }
}
