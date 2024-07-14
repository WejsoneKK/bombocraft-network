package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.context.Context
import dev.rollczi.litecommands.annotations.execute.Execute
import eu.wejsonekk.bombocraft.menu.ranks.RanksMenu
import org.bukkit.entity.Player

@Command(name = "ranks", aliases = ["rank", "rangi", "ranga", "rank-store", "rank-menu"])
class RanksCommand( private val ranksMenuGui: RanksMenu) {

    @Execute
    fun rankMenu(@Context player: Player) {
        this.ranksMenuGui.openInventory(player)
    }

}
