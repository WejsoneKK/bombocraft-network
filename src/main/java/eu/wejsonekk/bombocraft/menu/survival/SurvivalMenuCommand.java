package eu.wejsonekk.bombocraft.menu.survival;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;

@Command(name = "survival-menu", aliases = {"help", "pomoc", "menu", "survivalmenu", "svmenu"})
public class SurvivalMenuCommand {

    private SurvivalMainMenuGui survivalMainMenuGui;

    public SurvivalMenuCommand(SurvivalMainMenuGui survivalMainMenuGui) {
        this.survivalMainMenuGui = survivalMainMenuGui;
    }

    @Execute
    void openSurvivalMenu(@Context Player player){
        this.survivalMainMenuGui.openInventory(player);
    }
    @Permission("profile")
    @Execute(name = "profile")
    void openProfileMenu(@Context Player player){

    }

}
