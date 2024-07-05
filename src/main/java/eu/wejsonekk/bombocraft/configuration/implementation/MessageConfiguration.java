package eu.wejsonekk.bombocraft.configuration.implementation;

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig;
import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;

import java.io.File;
import java.util.List;

public class MessageConfiguration implements ReloadableConfig {


    @Description({ " ", "# Wrong command usage" })
    public WrongUsage wrongUsage = new WrongUsage();

    @Description({" ", "# Basic Commands sections"})
    public StandardCommands standardCommands = new StandardCommands();


    @Contextual
    public static class StandardCommands {
        public List<String> youtubeCommand = List.of(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );
        public List<String> DiscordCommand = List.of(
                "          <reset>                   <reset> <gradient:#fe6613:#ff3908><b>BOMBOCRAFT</gradient><reset>                 <reset>" ,
                "          <reset>  <reset> <gradient:#17b2ff:#2667ff><click:open_url:'https://bombocraft.com/discord'>Join our amazing community on Discord....</click></gradient>",
                "          <reset>              <hover:show_text:'<gradient:#17b2ff:#2667ff>Click Here to get a Discord'><click:open_url:'https://discord.gg/bombocraft'><gradient:#24a0ff:#1245ff>[DISCORD CLICK HERE]</gradient></click></hover>",
                "          <reset>                                                          <reset>"
        );
    }
    @Description({" ", " # (SHOP GUI MESSAGES SECTIOn )"})
    public StoreMessages ShopMessages = new StoreMessages();
    @Description({" ", " # BOMBO STORE SHOP GUI SECTION "})
    public BomboStoreMessages bomboStoreMessages = new BomboStoreMessages();

    @Contextual
    public static class StoreMessages {
        public String boughtItem = "&8» &aYou Bought &6{ITEM} ";
        public String sellItem = "&8» &aYou Sold &6{ITEM}";
    }
    @Contextual
    public static class BomboStoreMessages {

        public String BoughtBomboItem = "&8» &aYou Bought &6{BOMBO_ITEM} ";
        public String SellBomboItem = "&8» &aYou Sold &6{BOMBO_ITEM}";
    }
    @Contextual
    public static class WrongUsage {
        public String invalidUsage = "&4Correct Usage &8>> &7{COMMAND}.";

        public String invalidUsageHeader = "&cCorrect Usage:";

        public String invalidUsageEntry = "&8 >> &7 {COMMAND}";

        public String noPermission = "&4&lError: &cYou don't have permission to this  &4{permissions}.";

        public String cantFindPlayer = "&4Player {target} not found !";

        public String onlyForPlayer = "&4This Command only execude by players";
    }

    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "messages.yml");

    }
}
