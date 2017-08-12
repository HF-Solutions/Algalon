package org.alcha.algalona.models.wow.battlegroups;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.network.WoWDataResources;

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

    @Override
    public String toString() {
        return name();
    }

    public WoWEUBattlegroups newInstanceFromJson(JsonObject object) {
        if(object.has("name")) return WoWEUBattlegroups.fromString(object.get("name").getAsString());
        else return WoWEUBattlegroups.Unknown;
    }

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

    /**
     * <p>Parses the given {@link JsonArray} for a list of {@link WoWEUBattlegroups}. If the list is
     * found, each item in the list is added to a temp array which is then returned at the end of
     * of the method.</p>
     *
     * <p>This method is primarily used in conjunction with {@link WoWDataResources#getBattlegroups()}
     * as it provides the current list of Battlegroups available in WoW.</p>
     *
     * @param array JsonArray you wish to have parsed
     *
     * @return an Array of WoWEUBattlegroups
     */
    public static WoWEUBattlegroups[] parseBattlegroupsToArray(JsonArray array) {
        WoWEUBattlegroups[] tempArray = new WoWEUBattlegroups[array.size()];

        for (int x = 0; x < array.size(); x++) {
            JsonObject object = array.get(x).getAsJsonObject();

            if (object.has("name")) {
                WoWEUBattlegroups battlegroup = WoWEUBattlegroups.fromString(object.get("name").getAsString());
                tempArray[x] = battlegroup;
            }
        }

        return tempArray;
    }
}
