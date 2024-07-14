package eu.wejsonekk.bombocraft.configuration.implementation

import eu.wejsonekk.bombocraft.configuration.ReloadableConfig
import net.dzikoysk.cdn.entity.Contextual
import net.dzikoysk.cdn.entity.Description
import net.dzikoysk.cdn.source.Resource
import net.dzikoysk.cdn.source.Source
import java.io.File
@Contextual
class MessageConfiguration : ReloadableConfig {



    @Description(" ", "# DEV Commands")
    @Description("# PLACEHOLDER IN MESSAGE")
    @Description("# {rank} - return player rank name (luckperms group)")
    @Description("# {rank-prefix} - return player rank prefix (luckperms group)")
    @Description("# {vault-group} - return player rank group name (vault)")
    @Description("# {vault-prefix} - return player rank group prefix (vault)")
    @Description("# {bombo-token} - return player bombo tokens in pocket")
    @Description("# {bombo-balance - return player bombo coins balance in pocket")
    @Description("# {server-name} - return player connected server name")
    @Description("# {server-group} - return player connected server group-name")

    var bugReportMessageSent: String = "&4&lBugReport &8» &aSuccessfuly sent bug-report message"
    var bugReportCooldown: String = "&4&lBugReport » &cPlease wait &e{cooldown} &cto sent next bug-report"

    var bugReportFormatMessage: String = "&4&lBugReport &8» {rank} {player} {message} "


    var helpCommand: List<String> = listOf(
        "",
        "&6&p HELP COMMANDS",
        "",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &6",
        "&8» &a",
        ""
    )
    var youtubeCommand: List<String> = listOf(
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
    )
    var WebsiteCommand: List<String> = listOf(
        "",
        "",
        "          <reset>                   <reset> <gradient:#fe6613:#ff3908><b>BOMBOCRAFT</gradient><reset>                 <reset>",
        "          <reset>  <reset> <gradient:#17b2ff:#2667ff><click:open_url:'https://www.bombocraft.com'>Get our a Website</click></gradient>",
        "          <reset>              <hover:show_text:'<gradient:#17b2ff:#2667ff>Click here, to get a website link'><click:open_url:'https://www.bombocraft.com'><gradient:#24a0ff:#1245ff>[GO TO A WEBSITE]</gradient></click></hover>",
        "          <reset>                                                          <reset>",
        ""
    )
    var StoreCommand: List<String> = listOf(
        "",
        "          <reset>                   <reset> <gradient:#fe6613:#ff3908><b>BOMBOCRAFT</gradient><reset>                 <reset>",
        "          <reset>  <reset> <gradient:#17b2ff:#2667ff><click:open_url:'https://bombocraft.tebex.io'>Get our a Store</click></gradient>",
        "          <reset>              <hover:show_text:'<gradient:#17b2ff:#2667ff>Click here, to get a store link'><click:open_url:'https://bombocraft.tebex.io'><gradient:#24a0ff:#1245ff>[GO TO A STORE]</gradient></click></hover>",
        "          <reset>                                                          <reset>",
        ""
    )
    var DiscordCommand: List<String> = listOf(
        "          <reset>                   <reset> <gradient:#fe6613:#ff3908><b>BOMBOCRAFT</gradient><reset>                 <reset>",
        "          <reset>  <reset> <gradient:#17b2ff:#2667ff><click:open_url:'https://bombocraft.com/discord'>Join our amazing community on Discord....</click></gradient>",
        "          <reset>              <hover:show_text:'<gradient:#17b2ff:#2667ff>Click Here to get a Discord'><click:open_url:'https://discord.gg/bombocraft'><gradient:#24a0ff:#1245ff>[DISCORD CLICK HERE]</gradient></click></hover>",
        "          <reset>                                                          <reset>"
    )

    var boughtItem: String = "&8» &aYou Bought &6{ITEM} "
    var sellItem: String = "&8» &aYou Sold &6{ITEM}"

    var BoughtBomboItem: String = "&8» &aYou Bought &6{BOMBO_ITEM} "
    var SellBomboItem: String = "&8» &aYou Sold &6{BOMBO_ITEM}"

    var invalidUsage: String = "&4Correct Usage &8>> &7{COMMAND}."


    var invalidUsageHeader: String = "&cCorrect Usage:"


    var invalidUsageEntry: String = "&8 >> &7 {COMMAND}"


    var noPermission: String = "&4&lError: &cYou don't have permission to this  &4{permissions}."

    var cantFindPlayer: String = "&4Player {target} not found !"

    var onlyForPlayer: String = "&4This Command only execude by players"

    override fun resource(folder: File?): Resource? {
        return folder?.let { Source.of(it, "messages.yml") }

    }
}

