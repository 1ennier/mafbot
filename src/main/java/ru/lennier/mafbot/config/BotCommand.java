package ru.lennier.mafbot.config;

import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;

public enum BotCommand {

    VERSION("version", "Shows bot version");

    private String name;
    private String description;
    private Locality locality;
    private Privacy privacy;

    BotCommand(String name, String description) {
        this.name = name;
        this.description = description;
        this.locality = Locality.ALL;
        this.privacy = Privacy.PUBLIC;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Locality getLocality() {
        return locality;
    }

    public Privacy getPrivacy() {
        return privacy;
    }
}
