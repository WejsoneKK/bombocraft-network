package eu.wejsonekk.bombocraft.menu.survival;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class SurvivalMainMenuGui {
    public void openInventory(Player player) {
        Gui survivalMenu = Gui.gui()
                .disableAllInteractions()
                .title(Component.text("Survival Menu"))
                .rows(6).create();


        survivalMenu.getFiller().fillBorder(
                List.of(ItemBuilder
                        .from(Material.ORANGE_STAINED_GLASS_PANE)
                        .name(Component.text(" "))
                        .asGuiItem(), ItemBuilder
                        .from(Material.WHITE_STAINED_GLASS_PANE)
                        .name(Component.text(" "))
                        .asGuiItem()));



        GuiItem shopMenu = ItemBuilder.from(Material.EMERALD)
                .name(Component.text("bombocraft.survivalmenu.shopgui.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.shopgui.lore")))
                .asGuiItem();




        GuiItem cosmeticMenu = ItemBuilder.from(Material.DRAGON_BREATH)
                .name(Component.text("bombocraft.survivalmenu.cosmeticmenu.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.cosmeticmenu.lore")))
                .asGuiItem();

        GuiItem questAndChallangesMenu = ItemBuilder.from(Material.WRITABLE_BOOK)
                .name(Component.text("bombocraft.survivalmenu.questandchallanges.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.questandchallanges.lore")))
                .asGuiItem();

        GuiItem settingsMenu = ItemBuilder.from(Material.REPEATER)
                .name(Component.text("bombocraft.survivalmenu.settingsgui.title"))
                .lore(List.of(Component.text(""), Component.text("bombocraft.survivalmenu.settingsgui.lore")))
                .asGuiItem();

        GuiItem profileMenu = ItemBuilder.skull()
                .name(Component.text("bombocraft.survivalmenu.profilegui.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.profielgui.lore")))
                .asGuiItem();

        GuiItem warpMenu = ItemBuilder.from(Material.OAK_SIGN)
                .name(Component.text("bombocraft.survivalmenu.warp.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.warp.lore")))
                .asGuiItem();

        GuiItem jobMenu = ItemBuilder.from(Material.BELL)
                .name(Component.text("bombocraft.survivalmenu.job.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.warp.lore")))
                .asGuiItem();
        GuiItem kitsMenu = ItemBuilder.from(Material.ENCHANTED_GOLDEN_APPLE)
                .name(Component.text("bombocraft.survivalmenu.kits.title"))
                .lore(List.of(Component.text("bombocraft.survivalmenu.warp.lore")))
                .asGuiItem();


        survivalMenu.setItem(20, jobMenu);
        survivalMenu.setItem(21, cosmeticMenu);
        survivalMenu.setItem(29, shopMenu);
        survivalMenu.setItem(28, kitsMenu);

        survivalMenu.setItem(23, questAndChallangesMenu);
        survivalMenu.setItem(30, settingsMenu);
        survivalMenu.setItem(32, profileMenu);
        survivalMenu.setItem(33, warpMenu);

        survivalMenu.open(player);
    }
}
