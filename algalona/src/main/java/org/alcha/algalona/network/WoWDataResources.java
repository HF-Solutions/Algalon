package org.alcha.algalona.network;

import org.alcha.algalona.interfaces.APIRequest;

/**
 * <p>Created by Alcha on 8/9/2017.</p>
 */

public class WoWDataResources implements APIRequest {
    private static final String LOG_TAG = "WoWDataResources";
    private String relativeUrl = "/wow/data";

    private WoWDataResources() {
    }

    @Override
    public String getRelativeUrl() {
        return relativeUrl;
    }

    /**
     * <p>Appends the provided String to the end of the current relative URL. The parameter will
     * have any spaces replaced with %20, and commas with %2C so they're safe for use in a URL.</p>
     *
     * @param parameter String typed parameter
     *
     * @return The current WoWCommunityRequest object with the provided parameter appended
     */
    public WoWDataResources appendParameter(String parameter) {
        relativeUrl += "/" + parameter.replace(" ", "%20").replace(",", "%2C");
        return this;
    }

    public static WoWDataResources getBattlegroups() {
        return new WoWDataResources().appendParameter("battlegroups/");
    }

    public static WoWDataResources getCharacterRaces() {
        return new WoWDataResources()
                .appendParameter("character")
                .appendParameter("races");
    }

    public static WoWDataResources getCharacterClasses() {
        return new WoWDataResources()
                .appendParameter("character")
                .appendParameter("classes");
    }

    public static WoWDataResources getCharacterAchievements() {
        return new WoWDataResources()
                .appendParameter("character")
                .appendParameter("achievements");
    }

    public static WoWDataResources getGuildRewards() {
        return new WoWDataResources()
                .appendParameter("guild")
                .appendParameter("rewards");
    }

    public static WoWDataResources getGuildPerks() {
        return new WoWDataResources()
                .appendParameter("guild")
                .appendParameter("perks");
    }

    public static WoWDataResources getGuildAchievements() {
        return new WoWDataResources()
                .appendParameter("guild")
                .appendParameter("achievements");
    }

    public static WoWDataResources getItemClasses() {
        return new WoWDataResources()
                .appendParameter("item")
                .appendParameter("classes");
    }

    public static WoWDataResources getTalents() {
        return new WoWDataResources().appendParameter("talents");
    }

    public static WoWDataResources getPetTypes() {
        return new WoWDataResources()
                .appendParameter("pet")
                .appendParameter("types");
    }
}
