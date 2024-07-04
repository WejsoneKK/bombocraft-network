package eu.wejsonekk.bombocraft.configuration.implementation;

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig;
import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;

import java.io.File;

public class PluginConfiguration implements ReloadableConfig {


    @Description({"", "# Ustawienia bazy danych (MariaDB/SQLITE)"})
    public DatabaseConfigSection database = new DatabaseConfigSection();

    @Description({"", "# Ustawienia kanałów wiadomości (redis pub/sub)", "#(NIE TYKAĆ JEŻELI NIE WIESZ CO ROBISZ KURWA NIE RUSZAJ KURWO JEBANA RABBITOWSKA!"})
    public RedisMessagingChannelsSection RedisMessagingChannels = new RedisMessagingChannelsSection();
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
    @Contextual
    public static class RedisMessagingChannelsSection {

        public String discordRewardChannel = "oneblock:discordreward";
        public String youtubeRewardChannel = "oneblock:youtubereward";
        public String tiktokRewardChannel = "oneblock:tiktokreward";
        public String mclistRewardChannel = "oneblock:mclist";
        public String MinecraftListaRewardChannel = "oneblock:minecraftlista";
        public String TablistaRewardChannel = "oneblock:tablista";
        public String discordSyncChannel = "starblock:discord_role_sync";
        public String helpopChannel = "starblock:helpop";
        public String reportChannel = "reports:oneblock";
    }
    @Contextual
    public static class RestApiConfigSection {


    }
    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "config.yml");

    }
}
