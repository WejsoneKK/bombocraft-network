package eu.wejsonekk.bombocraft.hook;

public interface Hook {

    void Hook();

    void UnHook();

    boolean isHooked();

    String hookName();
    String versionHook();
}
