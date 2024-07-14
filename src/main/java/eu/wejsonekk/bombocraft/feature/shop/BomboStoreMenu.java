package eu.wejsonekk.bombocraft.feature.shop;

import dev.triumphteam.gui.guis.Gui;
import eu.wejsonekk.bombocraft.util.Legacy;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class BomboStoreMenu {

    private MiniMessage miniMessage;

    public BomboStoreMenu(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }


    public void openInventory(Player player) {
        Gui store = Gui.gui()

                .rows(5)
                .title(this.miniMessage.deserialize("<gold>BomboStore"))
                .disableAllInteractions()
                .create();





        store.open(player);
    }



    private Component color(String text) {
        return Legacy.RESET_ITALIC.append(this.miniMessage.deserialize(text));
    }

    private List<Component> color(String... lore) {
        return Arrays.stream(lore)
                .map(this::color)
                .toList();
    }

}
