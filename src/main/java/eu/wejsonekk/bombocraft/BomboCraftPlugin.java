package eu.wejsonekk.bombocraft;

import com.google.common.base.Stopwatch;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import eu.wejsonekk.bombocraft.commands.handler.InvalidUsageMessage;
import eu.wejsonekk.bombocraft.commands.handler.MissingPermissionMessage;
import eu.wejsonekk.bombocraft.commands.implementation.*;
import eu.wejsonekk.bombocraft.configuration.ConfigManager;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.configuration.implementation.PluginConfiguration;
import eu.wejsonekk.bombocraft.feature.shop.BomboStoreConfiguration;
import eu.wejsonekk.bombocraft.feature.shop.BomboStoreMenu;
import eu.wejsonekk.bombocraft.feature.shop.category.*;
import eu.wejsonekk.bombocraft.menu.ranks.RanksMenu;
import eu.wejsonekk.bombocraft.menu.survival.SurvivalMainMenuGui;
import eu.wejsonekk.bombocraft.menu.survival.SurvivalMenuCommand;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import eu.wejsonekk.bombocraft.util.LegacyColorProcessor;
import net.kyori.adventure.platform.AudienceProvider;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BomboCraftPlugin extends JavaPlugin {



    private ConfigManager configurationManager;
    private PluginConfiguration pluginConfiguration;
    private MessageConfiguration messageConfiguration;
    private BomboStoreMenu bomboStoreGui;
    private BomboStoreConfiguration bomboStoreConfiguration;
    private ShopBlocksCategoryConfiguration shopBlocksCategory;
    private ShopBlocksDecorationCategoryConfiguration blockDecorationCategory;
    private ShopArmorCategoryConfiguration shopArmorCategory;
    private ShopMineralsCategoryConfiguration shopMineralsCategory;
    private ShopToolsCategoryConfiguration shopToolsCategory;

    private RanksMenu rankMenuGui;

    private SurvivalMainMenuGui survivalMainMenu;

    private AudienceProvider audienceProvider;
    private MiniMessage miniMessage;
    private NotificationAnnouncer notificationAnnouncer;

    private LiteCommands<CommandSender> liteCommands;

    @Override
    public void onDisable(){
        if(this.audienceProvider!=null){

            audienceProvider.close();
        }

        if (this.liteCommands != null) {
            this.liteCommands.getCommandManager().unregisterAll();
        }
    }




    @Override
    public void onEnable(){
        Stopwatch started = Stopwatch.createStarted();
        Server server = this.getServer();
        Logger logger;
        File dataFolder = this.getDataFolder();


        this.configurationManager = new ConfigManager(dataFolder);
        this.pluginConfiguration = configurationManager.load(new PluginConfiguration());
        this.messageConfiguration = configurationManager.load(new MessageConfiguration());
        this.shopBlocksCategory = configurationManager.load(new ShopBlocksCategoryConfiguration());
        this.bomboStoreConfiguration = configurationManager.load(new BomboStoreConfiguration());
        this.shopArmorCategory = configurationManager.load(new ShopArmorCategoryConfiguration());
        this.shopMineralsCategory = configurationManager.load(new ShopMineralsCategoryConfiguration());
        this.shopToolsCategory = configurationManager.load(new ShopToolsCategoryConfiguration());

        this.audienceProvider = BukkitAudiences.create(this);
        this.miniMessage = MiniMessage.builder()
                .postProcessor(new LegacyColorProcessor())
                .build();

        this.notificationAnnouncer = new NotificationAnnouncer(this.audienceProvider, this.miniMessage);
        this.bomboStoreGui = new BomboStoreMenu(miniMessage);
        this.survivalMainMenu = new SurvivalMainMenuGui();
        this.rankMenuGui = new RanksMenu(this.miniMessage);

//        registerListener(server)
        this.liteCommands = LiteBukkitFactory.builder("bombocraft")
                .settings(settings -> {
                    return settings.nativePermissions(true)
                            .fallbackPrefix("bombocraft");
                })
            .commands(
                new BomboStoreCommand(this.bomboStoreGui),
                new YoutubeCommand(this.messageConfiguration, this.notificationAnnouncer),
                new DiscordCommand(this.notificationAnnouncer, this.messageConfiguration),
                new BugReportCommand(this.pluginConfiguration, this.notificationAnnouncer, this.messageConfiguration),
                new WebSiteCommand(this.notificationAnnouncer, this.messageConfiguration),
                new StoreCommand(this.notificationAnnouncer, this.messageConfiguration),
                new RanksCommand(this.rankMenuGui),
                new SurvivalMenuCommand(this.survivalMainMenu)
        ).invalidUsage(new InvalidUsageMessage(this.notificationAnnouncer, this.messageConfiguration))
                .missingPermission(new MissingPermissionMessage(this.messageConfiguration, this.notificationAnnouncer))
                .build();

        long elapsed = started.elapsed(TimeUnit.MILLISECONDS);

    }
}
