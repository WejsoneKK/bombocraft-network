package eu.wejsonekk.bombocraft.commands.implementation;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import org.bukkit.entity.Player;

@Command(name = "bombostore", aliases = {"bombosklep", "bomboshop", "bomboostore"})
public class BomboStoreCommand {

    @Execute
    void OpenBomboStore(@Context Player player){

    }
}
