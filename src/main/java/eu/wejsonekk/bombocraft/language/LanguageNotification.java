package eu.wejsonekk.bombocraft.language;

import eu.wejsonekk.bombocraft.notification.NotificationType;

public interface LanguageNotification {

    void sendMessage(Player player, Language NotificationType notificationType, String message);

}
