package eu.wejsonekk.bombocraft.feature.shop;

import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BomboStoreGui {

    private MiniMessage miniMessage;
    private MessageConfiguration messages;

    public BomboStoreGui(MiniMessage miniMessage, MessageConfiguration messages) {
        this.miniMessage = miniMessage;
        this.messages = messages;
    }


    public void openInventory(Player player){

        Gui bomboStoreGui = Gui
                .gui()
                .disableAllInteractions()
                .rows(4)
                .title(this.miniMessage.deserialize("<gradient:#fe6613:#ff3908><b>BOMBO STORE</gradient>"))
                .create();



        bomboStoreGui.getFiller()
                        .fillBorder(new GuiItem(Material.ORANGE_STAINED_GLASS_PANE, event -> {
                            event.setCancelled(true);
                        }));


        bomboStoreGui.open(player);
    }
}
