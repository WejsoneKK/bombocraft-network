package eu.wejsonekk.bombocraft.menu.ranks;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import eu.wejsonekk.bombocraft.util.Legacy;
import lombok.val;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import java.util.Arrays;
import java.util.List;

public class RanksMenu {

    private MiniMessage miniMessage;

    public RanksMenu(MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    public void openInventory(Player player){


        Gui ranksMenu = Gui
                .gui()
                .disableAllInteractions()
                .rows(6)
                .title(miniMessage.deserialize("Ranks - Preview"))
                .create();

        GuiItem vipRank = ItemBuilder.from(Material.GOLD_INGOT)
                .name(this.color("&aVIP"))
                .lore(this.color(
                        "&r",
                        "&7Features",
                        "",
                        "&8✔ &a&lVIP &7Prefix",
                        "&8✔ &7Acess to /feed",
                        "&8✔ &7Acess to /heal",
                        "&8✔ &7Acess to kit vip",
                        "&8✔ &7Weekly Rewards",
                        "&8✔ &7+3 Exclusive Tags",
                        "&8✔ &7+2 Exclusive Trails",
                        "&8✔ &7+2 Exclusive Colors",
                        "&8✔ &7+5 Items in Auctions",
                        "&7Price: &6$6.99 USD",
                        "",
                        "&8» &eClick to buy"
                ))
                .enchant(Enchantment.ARROW_INFINITE, 1, true)
                .flags(ItemFlag.HIDE_ENCHANTS)
                .asGuiItem();


        GuiItem vipPlusRank = ItemBuilder.from(Material.GOLD_INGOT)
                .name(this.color("&aVIP&e+"))
                .lore(this.color(
                        "&r",
                        "&7Features",
                        "&8✔ &a&lVIP&6+ &7Prefix",
                        "",
                        "&8✔ &7Acess to /feed",
                        "&8✔ &7Acess to /heal",
                        "&8✔ &7Acess to /nick",
                        "&8✔ &7Acess to kit vip",
                        "&8✔ &7Acess to kit vip+",
                        "&8✔ &7Weekly Rewards",
                        "&8✔ &7+8 Exclusive Tags",
                        "&8✔ &7+4 Exclusive Trails",
                        "&8✔ &7+6 Exclusive Colors",
                        "&8✔ &7+7 Items in Auctions",
                        "",
                        "&7Price: &6$14.99 USD",
                        "",
                        "&8» &eClick to buy"
                ))
                .enchant(Enchantment.ARROW_INFINITE, 1, true)
                .flags(ItemFlag.HIDE_ENCHANTS)
                .asGuiItem();


        GuiItem mvpRank = ItemBuilder.from(Material.GOLD_INGOT)
                .name(this.color("&bMVP"))
                .lore(this.color(
                        "&r",
                        "&7Features",
                        "&8✔ &b&lMVP &7Prefix",
                        "",
                        "&8✔ &7Acess to /feed",
                        "&8✔ &7Acess to /heal",
                        "&8✔ &7Acess to /nick",
                        "&8✔ &7Acess to /back",
                        "&8✔ &7Acess to kit vip",
                        "&8✔ &7Acess to kit vip+",
                        "&8✔ &7Acess to kit mvp",
                        "&8✔ &7Weekly Rewards",
                        "&8✔ &7+13 Exclusive Tags",
                        "&8✔ &7+7 Exclusive Trails",
                        "&8✔ &7+6 Exclusive Colors",
                        "&8✔ &7+11 Items in Auctions",
                        "",
                        "&7Price: &&6$29.99 USD",
                        "",
                        "&8» &eClick to buy"
                ))
                .enchant(Enchantment.ARROW_INFINITE, 1, true)
                .flags(ItemFlag.HIDE_ENCHANTS)
                .asGuiItem();

        GuiItem mvpPlusRank = ItemBuilder.from(Material.GOLD_INGOT)
                .name(this.color("&bMVP&c+"))
                .lore(this.color(
                        "&r",
                        "&7Features",
                        "&8✔ &b&lMVP&6+ &7Prefix",
                        "",
                        "&8✔ &7Acess to /feed",
                        "&8✔ &7Acess to /heal",
                        "&8✔ &7Acess to /nick",
                        "&8✔ &7Acess to /back",
                        "&8✔ &7Acess to /fly",
                        "&8✔ &7Acess to kit vip",
                        "&8✔ &7Acess to kit vip+",
                        "&8✔ &7Acess to kit mvp",
                        "&8✔ &7Acess to kit mvp+",
                        "&8✔ &7Weekly Rewards",
                        "&8✔ &7+18 Exclusive Tags",
                        "&8✔ &7+10 Exclusive Trails",
                        "&8✔ &7+10 Exclusive Colors",
                        "&8✔ &7+13 Items in Auctions",
                        "",
                        "&7Price: &6$44.99 USD",
                        "",
                        "&8» &eClick to buy"
                ))
                .enchant(Enchantment.ARROW_INFINITE, 1, true)
                .flags(ItemFlag.HIDE_ENCHANTS)
                .asGuiItem();


        ranksMenu.setItem(10, vipRank);
        ranksMenu.setItem(11, vipPlusRank);
        ranksMenu.setItem(12, mvpRank);
        ranksMenu.setItem(13, mvpPlusRank);


        ranksMenu.setDefaultClickAction( event -> { event.setCancelled(true); });

        ranksMenu.open(player);
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
