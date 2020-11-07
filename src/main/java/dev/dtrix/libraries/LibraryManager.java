package dev.dtrix.libraries;

public class LibraryManager {

    private static LibraryManager instance;
    private MinecraftVersion version;

    private LibraryManager() {
        this.version = new MinecraftVersion("1.16.3");
    }

    public static LibraryManager getInstance() {
        if(instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    pu
}
