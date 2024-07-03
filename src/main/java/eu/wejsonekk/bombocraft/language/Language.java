package eu.wejsonekk.bombocraft.language;

import eu.wejsonekk.bombocraft.notification.NotificationType;

public interface Language {

    void message(String message, NotificationType notificationType);
    boolean isConsole();
    LanguageType languageType = LanguageType.ENGLISH;

}
