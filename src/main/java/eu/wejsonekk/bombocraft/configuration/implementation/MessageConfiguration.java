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
    @Description({" ", "# Wiadomości Sprawdzania"})
    public CheckMessages checkMessages = new CheckMessages();

    @Description({" ", "# Wiadomości z nagrodami"})
    @Description({" ", "# Podstawowe Komendy"})
    public StandardCommands standardCommands = new StandardCommands();

    public RewardMessages rewardMessage = new RewardMessages();

    @Contextual
    public static class RewardMessages {
        public String rewardNotification = "&cOdbierz nagrodę wykonując instrukcje podane pod /nagroda";
        public String rewardNotifySucess = "&aPomyślnie odebrano nagrodę";
        public String getRewardNotificationBroadcast = "&7Gracz &6{player} &7Odebrał nagrodę za &bdołączenie na discorda <newline> <green>Wpisz /nagroda <gold>Aby odebrać nagrodę";

    }


    @Contextual
    public static class CheckMessages {
        public String checkPlayerBroadcast = "&dSprawdzanie &8» &dGracz &f{NICK} &dJest Aktualnie sprawdzany przez {ADMIN}";
        public String checkPlayerNotification = "&4&lJESTEŚ SPRAWDZANY &cWykonuj polecenie administratora w innym przypadku możesz zostać zbanowany za brak współpracy";
        public List<String> checkPlayerHelpMessage = List.of(
                "",
                "&r            &r&4UWAGA Jesteś sprawdzany....",
                "&r     &cAby nie zostać zbanowanym wykonuj polecenia administratora",
                "&r    &cOdpowiedź na czacie lub używjaąć komendy /helpop <wiadomość>",
                "",
                "    &bNasz Discord: &b[Naciśnij Tutaj]",
                "    &7Dołącz na naszego discorda, i wejdź na wskazany przez administratora kanał pomocy, aby kontynuować sprawdzanie",
                "      ",
                "        &6Możesz również przyznać się do korzystania z cheatów",
                "       &7I otrzymać krótszą karę ",
                "      &7Jeżeli administrator wykryje u ciebie cheaty, otrzymasz bana za wykrycie Cheatów!",
                "    &4Logout w trakcie sprawdzania = 60dni bana",
                "");

        public String checkPlayerPrzyznajesie = "&dGracz &f{NICK} &dPrzyznał się do posiadania cheatów i otrzymał &6bana na 3 dni";
        public String checkPlayerLogout = "&dGracz &f{NICK} &dWylogował się podczas sprawdzania i otrzymał &6bana na 60 dni";
        public String checkPlayerClean = "&dGracz &f{NICK} &dZostał sprawdzony i nie wykryto u niego cheatów &aOby tak dalej! <newline>&4Nie cheatuj bo i tak cię złapiemy!";
        public String checkPlayerCheater = "&cAdministrator &f{ADMIN} &dWykrył Cheaty u gracza &f{NICK} &dPodczas sprawdzania!";


    }
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
                "          <reset>                                                          <reset>" ,
                "          <reset>                                                          <reset>" ,
                "               <reset><gradient:#0571ff:#24a0ff>Nasz Serwer discord...</gradient> ",
                "             <gray>Dołącz do niesamowitej społeczności na naszym serwerze discord",
                "           <gray>Nasz serwer discord znajdziesz klikając <click:open_url:'https://dc.starblock.pl'><gradient:#24a0ff:#1245ff>[KLIKNIJ TUTAJ]</gradient></click>",
                "          <reset>                                                          <reset>" ,
                "          <reset>                                                          <reset>"
        );
    }



    @Contextual
    public static class WrongUsage {
        public String invalidUsage = "&4Poprawne użycie &8>> &7{COMMAND}.";

        public String invalidUsageHeader = "&cPrawidłowe użycie:";

        public String invalidUsageEntry = "&8 >> &7 {COMMAND}";

        public String noPermission = "&4Błąd: &cNie posiadasz wymaganych uprawnień &4{permissions}.";

        public String cantFindPlayer = "&4Gracz o nazwie {target} nie został odnaleziony !";

        public String onlyForPlayer = "&4To polecenie jest dostępne tylko dla graczy";
    }

    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "messages.yml");

    }
}
