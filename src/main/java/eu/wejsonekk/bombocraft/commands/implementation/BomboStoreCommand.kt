package eu.wejsonekk.bombocraft.commands.implementation;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import eu.wejsonekk.bombocraft.feature.shop.BomboStoreGui;
import org.bukkit.entity.Player;

@Command(name = "bombostore", aliases = {"bombosklep", "bomboshop", "bomboostore"})
public class BomboStoreCommand {

    private BomboStoreGui bomboStoreGui;

    public BomboStoreCommand(BomboStoreGui bomboStoreGui) {
        this.bomboStoreGui = bomboStoreGui;
    }

    @Execute
    void OpenBomboStore(@Context Player player){
        this.bomboStoreGui.openInventory(player);
    }
}
