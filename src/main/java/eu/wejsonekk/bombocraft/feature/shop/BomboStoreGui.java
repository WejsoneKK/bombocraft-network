package eu.wejsonekk.bombocraft.feature.shop;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.util.Legacy;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
                .rows(5)
                .title(this.miniMessage.deserialize("<gradient:#fe6613:#ff3908><b>BOMBO STORE</gradient>"))
                .create();



        bomboStoreGui.getFiller()
                        .fillBorder(new GuiItem(Material.ORANGE_STAINED_GLASS_PANE, event -> {
                            event.setCancelled(true);
                        }));

        ItemBuilder pickaxe = ItemBuilder.from(Material.DIAMOND_PICKAXE);
        pickaxe.name(this.color("<gradient:gold:yellow>BOMBO PICKAXE"));
        pickaxe.lore(this.color("&8PRICES"), this.color("&fSell: &a-/-$"), this.color("&fBuy: &b250K$"));
        pickaxe.enchant(Map.of(Enchantment.DIG_SPEED, 15, Enchantment.DAMAGE_ALL, 10, Enchantment.DURABILITY, 255, Enchantment.SILK_TOUCH, 9, Enchantment.LUCK, 5), true);
        GuiItem bomboPickaxe = pickaxe
                .asGuiItem(event -> {
                    if(event.isRightClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombopickaxe.buy)");
                    }else if(event.isLeftClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombopickaxe.sell)");
                    }});

        ItemBuilder hat = ItemBuilder.from(Material.CHAINMAIL_HELMET);
        hat.name(this.color("<gradient:gold:yellow>BOMBO HAT"));
        hat.lore(this.color("&r", "&8PRICES: ", "&fSell: &a-/-$", "&fBuy: &b250K$"));
        hat.enchant(Map.of(Enchantment.PROTECTION_ENVIRONMENTAL, 10, Enchantment.DURABILITY, 10), true);
        GuiItem bomboHat = hat
                .asGuiItem(event -> {
                    if(event.isRightClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombohat.buy)");
                    }else if(event.isLeftClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombohat.sell)");
                    }});
        ItemBuilder jacket = ItemBuilder.from(Material.CHAINMAIL_CHESTPLATE);
        jacket.name(this.color("<gradient:gold:yellow>BOMBO JACKET"));
        jacket.lore(this.color("&r", "&8PRICES: ", "&fSell: &a-/-$", "&fBuy: &b250K$"));
        jacket.enchant(Map.of(Enchantment.PROTECTION_ENVIRONMENTAL, 10, Enchantment.DURABILITY, 10), true);
        GuiItem bomboJacket = jacket
                .asGuiItem(event -> {
                    if(event.isRightClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombohat.buy)");
                    }else if(event.isLeftClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombohat.sell)");
                    }});
        ItemBuilder leggins = ItemBuilder.from(Material.CHAINMAIL_LEGGINGS);
        leggins.name(this.color("<gradient:gold:yellow>BOMBO SHORTS"));
        leggins.lore(this.color("&r", "&8PRICES: ", "&fSell: &a-/-$", "&fBuy: &b250K$"));
        leggins.enchant(Map.of(Enchantment.PROTECTION_ENVIRONMENTAL, 10, Enchantment.DURABILITY, 10), true);
        GuiItem bomboLeggins = leggins
                .asGuiItem(event -> {
                    if(event.isRightClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombohat.buy)");
                    }else if(event.isLeftClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombohat.sell)");
                    }});

        ItemBuilder flops = ItemBuilder.from(Material.CHAINMAIL_BOOTS);
        flops.name(this.color("<gradient:gold:yellow>BOMBO FLIP-FLOPS"));
        flops.lore(this.color("&r", "&8PRICES: ", "&fSell: &a-/-$", "&fBuy: &b500K$"));
        flops.enchant(Map.of(Enchantment.PROTECTION_ENVIRONMENTAL, 10, Enchantment.DURABILITY, 10), true);
        GuiItem BomboFlapFlops = flops
                .asGuiItem(event -> {
                    if(event.isRightClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bomboflapflops.buy)");
                    }else if(event.isLeftClick()){
                        event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bomboflapflops.sell)");
                    }});

        ItemBuilder axe = ItemBuilder.from(Material.NETHERITE_AXE);
        axe.name(this.color("<gradient:gold:yellow>BOMBO AXE"));
        axe.lore(this.color("&r", "&8PRICES", "&fSell: &a-/-$", "&fBuy: &b500K$"));
        axe.enchant(Enchantment.DAMAGE_ALL, 10, true);
        GuiItem BomboAxe = axe.asGuiItem(event -> {
            if(event.isRightClick()){
                event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bomboaxe.buy)");
            }else if(event.isLeftClick()){
                event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bomboaxe.sell)");
        }});

        ItemBuilder totem = ItemBuilder.from(Material.TOTEM_OF_UNDYING);
        totem.name(this.color("<gradient:gold:yellow>TOTEM OF BOMBO"));
        totem.lore(this.color("&r", "&8PRICES: ", "&fSell: &a-/-$", "&fBuy: &b250K$"));
        totem.enchant(Enchantment.ARROW_INFINITE, 1, true)
                        .flags(ItemFlag.HIDE_ENCHANTS);

        GuiItem bomboTotem = totem.asGuiItem(event -> {
            if(event.isRightClick()){
                event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombototem.buy)");
            }else if(event.isLeftClick()){
                event.getWhoClicked().sendMessage("not found message for (bombocraft.store.bombostore.item.bombototem.sell)");
            }});
        bomboStoreGui.setItem(19, bomboPickaxe);
        bomboStoreGui.setItem(20, bomboHat);
        bomboStoreGui.setItem(21, bomboJacket);
        bomboStoreGui.setItem(22, bomboLeggins);
        bomboStoreGui.setItem(23, BomboFlapFlops);
        bomboStoreGui.setItem(24, BomboAxe);
        bomboStoreGui.setItem(25, bomboTotem);

        bomboStoreGui.open(player);
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
