package eu.wejsonekk.bombocraft.feature.automessage;

import eu.wejsonekk.bombocraft.notification.NotificationAnnouncer;

public interface AutoMessage {

    NotificationAnnouncer announcer();

    AutoMessageType type();


}
