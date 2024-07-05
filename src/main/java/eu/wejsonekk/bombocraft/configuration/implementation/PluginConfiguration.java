package eu.wejsonekk.bombocraft.configuration.implementation;

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig;
import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;

import java.io.File;

public class PluginConfiguration implements ReloadableConfig {


    @Description({"", "# DATABASE SETTINGS (MariaDB/SQLITE)"})
    public DatabaseConfigSection database = new DatabaseConfigSection();

//    @Description({"", "# REDIS CHANNEL MESSAGING SETTINGS SECTION | DO NOT TOUCH!"})
//    public RedisMessagingChannelsSection RedisMessagingChannels = new RedisMessagingChannelsSection();
    @Contextual
    public static class DatabaseConfigSection {
        public String hostname = "127.0.0.1";
        public String database = "database";
        public String username = "user";
        public int port = 4406;
        public String password = "password";
        public String type = "mysql";
        public boolean useSSL = false;

    }
    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "config.yml");

    }
}
