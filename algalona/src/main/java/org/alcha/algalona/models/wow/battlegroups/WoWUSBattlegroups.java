package org.alcha.algalona.models.wow.battlegroups;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public enum WoWUSBattlegroups implements WoWBattlegroup {
    Bloodlust,
    Cataclysm,
    Cyclone,
    Emberstorm,
    Frenzy,
    Nightfall,
    Rampage,
    Reckoning,
    Retaliation,
    Ruin,
    Shadowburn,
    Stormstrike,
    Unknown,
    Vengeance,
    Vindication,
    Whirlwind;

    private static final String LOG_TAG = "WoWUSBattlegroups";


    /**
     * Attempts to find a matching {@link WoWUSBattlegroups} value for the provided name. If no match
     * is found, the {@link WoWUSBattlegroups#Unknown} realm is returned as opposed to null.
     *
     * @param name
     *
     * @return
     */
    public static WoWUSBattlegroups fromString(String name) {
        for (WoWUSBattlegroups realm : WoWUSBattlegroups.values()) {
            if (realm.name().equalsIgnoreCase(name)) {
                return realm;
            }
        }

        return Unknown;
    }

    @Override
    public String getRelativeUrl() {
        if (name().contains("\'")) {
            return name().toLowerCase().replace("_", "%20");
        } else {
            return this.toString().toLowerCase().replace("_", "%20");
        }
    }

    /**
     * Get the slug version of the {@link WoWUSBattlegroups} that is used by the Battle.net API.
     *
     * @return String representing the slug of the Battlegroup
     */
    @Override
    public String getSlug() {
        return name().toLowerCase().replace('_', '-');
    }
}
