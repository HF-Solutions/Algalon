package org.alcha.algalona.network;

/**
 * <p>Created by Alcha on 8/9/2017.</p>
 */

public class WoWDataResources implements GameRequest {
    private static final String LOG_TAG = "WoWDataResources";
    private String relativeUrl = "/wow/data";

    private WoWDataResources() {}

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
     * @return The current WoWRequest object with the provided parameter appended
     */
    public WoWDataResources appendParameter(String parameter) {
        relativeUrl += "/" + parameter.replace(" ", "%20").replace(",", "%2C");
        return this;
    }

    public WoWDataResources getBattlegroups() {
        return new WoWDataResources().appendParameter("battlegroups");
    }

    public WoWDataResources getCharacterRaces() {
        return new WoWDataResources()
                .appendParameter("character")
                .appendParameter("races");
    }

    public WoWDataResources getCharacterClasses() {
        return new WoWDataResources()
                .appendParameter("character")
                .appendParameter("classes");
    }

    public WoWDataResources getCharacterAchievements() {
        return new WoWDataResources()
                .appendParameter("character")
                .appendParameter("achievements");
    }

    public WoWDataResources getGuildRewards() {
        return new WoWDataResources()
                .appendParameter("guild")
                .appendParameter("rewards");
    }

    public WoWDataResources getGuildPerks() {
        return new WoWDataResources()
                .appendParameter("guild")
                .appendParameter("perks");
    }

    public WoWDataResources getGuildAchievements() {
        return new WoWDataResources()
                .appendParameter("guild")
                .appendParameter("achievements");
    }

    public WoWDataResources getItemClasses() {
        return new WoWDataResources()
                .appendParameter("item")
                .appendParameter("classes");
    }

    public WoWDataResources getTalents() {
        return new WoWDataResources().appendParameter("talents");
    }

    public WoWDataResources getPetTypes() {
        return new WoWDataResources()
                .appendParameter("pet")
                .appendParameter("types");
    }
}
