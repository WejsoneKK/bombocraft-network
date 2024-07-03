package eu.wejsonekk.bombocraft.feature.automessage;

import eu.wejsonekk.bombocraft.language.ILanguage;
import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;

public interface AutoMessage {

    NotificationAnnouncer announcer();

    ILanguage language();

    AutoMessageType type();


}
