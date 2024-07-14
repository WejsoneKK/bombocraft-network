package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import eu.wejsonekk.bombocraft.feature.shop.BomboStoreMenu
import org.bukkit.entity.Player

@Command(name = "bombostore", aliases = ["bombosklep", "bomboshop", "bomboostore"])
class BomboStoreCommand(private val bomboStoreMenu: BomboStoreMenu) {
    @Execute
    fun openBomboStore(@Context player: Player) {

        this.bomboStoreMenu.openInventory(player)
    }
}
