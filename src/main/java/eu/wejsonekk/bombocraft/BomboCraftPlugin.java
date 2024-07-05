package eu.wejsonekk.bombocraft;

import com.github.benmanes.caffeine.cache.Scheduler;
import com.google.common.base.Stopwatch;
import com.j256.ormlite.support.ConnectionSource;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteCommandsBukkit;
import eu.wejsonekk.bombocraft.commands.handler.InvalidUsageMessage;
import eu.wejsonekk.bombocraft.commands.handler.MissingPermissionMessage;
import eu.wejsonekk.bombocraft.commands.implementation.BomboStoreCommand;
import eu.wejsonekk.bombocraft.commands.implementation.DiscordCommand;
import eu.wejsonekk.bombocraft.commands.implementation.YoutubeCommand;
import eu.wejsonekk.bombocraft.configuration.ConfigManager;
import eu.wejsonekk.bombocraft.configuration.implementation.MessageConfiguration;
import eu.wejsonekk.bombocraft.configuration.implementation.PluginConfiguration;
import eu.wejsonekk.bombocraft.database.DatabaseManager;
import eu.wejsonekk.bombocraft.feature.shop.BomboStoreGui;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;
import eu.wejsonekk.bombocraft.user.User;
import eu.wejsonekk.bombocraft.user.UserRepository;
import eu.wejsonekk.bombocraft.user.UserService;
import eu.wejsonekk.bombocraft.util.LegacyColorProcessor;
import lombok.SneakyThrows;
import net.kyori.adventure.platform.AudienceProvider;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Logger;

public class BomboCraftPlugin extends JavaPlugin {
    private Scheduler scheduler;

    private PluginConfiguration pluginConfiguration;
    private MessageConfiguration messageConfiguration;
    private BomboStoreGui bomboStoreGui;


    private AudienceProvider audienceProvider;
    private MiniMessage miniMessage;
    private NotificationAnnouncer notificationAnnouncer;

    private LiteCommands<CommandSender> liteCommands;

    @Override
    public void onDisable() {
        if (this.audienceProvider != null) {
            this.audienceProvider.close();
        }

        if (this.liteCommands != null) {
            this.liteCommands.getCommandManager().unregisterAll();
        }
    }
    private void registerListener(Server server){

//        Stream.of(
//                new NeverNoHungerListener(this.miniMessage, this.notificationAnnouncer),
//                new UserController(this.userService)
//        ).forEach(listener -> server.getPluginManager().registerEvents(listener, this));
    }
    @SneakyThrows
    @Override
    public void onEnable() {
        Stopwatch started = Stopwatch.createStarted();
        Server server = this.getServer();
        Logger logger = this.getLogger();
        File dataFolder = this.getDataFolder();



        ConfigManager configurationManager = new ConfigManager(this.getDataFolder());
        this.pluginConfiguration = configurationManager.load(new PluginConfiguration());
        this.messageConfiguration = configurationManager.load(new MessageConfiguration());

        this.audienceProvider = BukkitAudiences.create(this);
        this.miniMessage = MiniMessage.builder()
                .postProcessor(new LegacyColorProcessor())
                .build();

        try {
            DatabaseManager.createTables();

            ConnectionSource connectionSource = DatabaseManager.getConnectionSource();
            UserRepository userRepository = new UserRepository(connectionSource);
            UserService userService = new UserService(userRepository);

            User user = new User("WejsoneKK", UUID.randomUUID());
            userService.addUser(user);

            User retrievedUser = userService.getUserById(user.getId());
            System.out.println("Retrieved User: " + retrievedUser.getName());

            connectionSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new SQLException(e);
        }


        this.notificationAnnouncer = new NotificationAnnouncer(this.audienceProvider, this.miniMessage);
        this.bomboStoreGui = new BomboStoreGui(this.miniMessage, this.messageConfiguration);

        registerListener(this.getServer());
        this.liteCommands = LiteCommandsBukkit.builder("bombocraft-network")
                .settings(liteBukkitSettings -> {
                    return liteBukkitSettings.nativePermissions(true);
                })
                .commands(
                        new BomboStoreCommand(this.bomboStoreGui),
                        new YoutubeCommand(this.messageConfiguration, this.notificationAnnouncer),
                        new DiscordCommand(this.notificationAnnouncer, this.messageConfiguration)
                ).invalidUsage(new InvalidUsageMessage(this.notificationAnnouncer, this.messageConfiguration))
                .missingPermission(new MissingPermissionMessage(this.messageConfiguration, this.notificationAnnouncer))
                .build();

        long elapsed = started.elapsed().toMillis();
        this.getLogger().info("Successfully loaded starblock-oneblock-core in " + elapsed + "ms");
    }
}