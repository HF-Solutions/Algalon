package org.alcha.algalonj.models.wow.battlegroups;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

public enum WoWEUBattlegroups implements WoWBattlegroup {
    Blackout,
    Bloodlust,
    Blutdurst,
    Cataclysme,
    Conviction,
    Crueldad,
    Cyclone,
    Ferocite,
    Glutsturm,
    Hinterhalt,
    Misery,
    Nemesis,
    Nightfall,
    Proximamente,
    Rampage,
    Raserei,
    Reckoning,
    Represailles,
    Ruin,
    Schattenbrand,
    Sturmangriff,
    Todbringer,
    Unknown,
    Vengeance,
    VerderBnis,
    Vindication;

    private static final String LOG_TAG = "WoWEUBattlegroups";


    /**
     * Attempts to find a matching {@link WoWEUBattlegroups} value for the provided name. If no match
     * is found, the {@link WoWEUBattlegroups#Unknown} realm is returned as opposed to null.
     *
     * @param name
     *
     * @return
     */
    public static WoWEUBattlegroups fromString(String name) {
        for (WoWEUBattlegroups realm : WoWEUBattlegroups.values()) {
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
     * Get the slug version of the {@link WoWEUBattlegroups} that is used by the Battle.net API.
     *
     * @return String representing the slug of the Battlegroup
     */
    @Override
    public String getSlug() {
        return name().toLowerCase().replace('_', '-');
    }
}
