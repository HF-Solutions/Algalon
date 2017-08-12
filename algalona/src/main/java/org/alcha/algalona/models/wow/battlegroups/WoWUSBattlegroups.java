package org.alcha.algalona.models.wow.battlegroups;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.network.WoWDataResources;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public enum WoWUSBattlegroups implements WoWBattlegroup {
    Aunz_Battle_Group("AU/NZ Battle Group"),
    Bloodlust("Bloodlust"),
    Cataclysm("Cataclysm"),
    Cyclone("Cyclone"),
    Emberstorm("Emberstorm"),
    Frenzy("Frenzy"),
    Nightfall("Nightfall"),
    Rampage("Rampage"),
    Reckoning("Reckoning"),
    Retaliation("Retaliation"),
    Ruin("Ruin"),
    Shadowburn("Shadowburn"),
    Stormstrike("Stormstrike"),
    Unknown("Unknown"),
    Vengeance("Vengeance"),
    Vindication("Vindication"),
    Whirlwind("Whirlwind");
    private static final String LOG_TAG = "WoWUSBattlegroups";

    private String mName;

    WoWUSBattlegroups(String name) {
        mName = name;
    }

    public WoWUSBattlegroups newInstanceFromJson(JsonObject object) {
        if(object.has("name")) return WoWUSBattlegroups.fromString(object.get("name").getAsString());
        else return WoWUSBattlegroups.Unknown;
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

    @Override
    public String toString() {
        return name();
    }

    /**
     * Returns the display name for the current {@link WoWUSBattlegroups} object.
     *
     * @return a String representing the battlegroup name
     */
    public String getName() {
        return mName;
    }

    /**
     * Attempts to find a matching {@link WoWUSBattlegroups} value for the provided name. If no match
     * is found, the {@link WoWUSBattlegroups#Unknown} realm is returned as opposed to null.
     *
     * @param name String version of the battlegroup name
     *
     * @return a WoWUSBattlegroup with the name provided or Unknown if none can be located
     */
    public static WoWUSBattlegroups fromString(String name) {
        for (WoWUSBattlegroups realm : WoWUSBattlegroups.values()) {
            if (realm.name().equalsIgnoreCase(name)) {
                return realm;
            }
        }

        return Unknown;
    }

    /**
     * <p>Parses the given {@link JsonArray} for a list of {@link WoWUSBattlegroups}. If the list is
     * found, each item in the list is added to a temp array which is then returned at the end of
     * of the method.</p>
     *
     * <p>This method is primarily used in conjunction with {@link WoWDataResources#getBattlegroups()}
     * as it provides the current list of Battlegroups available in WoW.</p>
     *
     * @param array JsonArray you wish to have parsed
     *
     * @return an Array of WoWUSBattlegroups
     */
    public static WoWUSBattlegroups[] parseBattlegroupsToArray(JsonArray array) {
        WoWUSBattlegroups[] tempArray = new WoWUSBattlegroups[array.size()];

        for (int x = 0; x < array.size(); x++) {
            JsonObject object = array.get(x).getAsJsonObject();

            if (object.has("name")) {
                WoWUSBattlegroups battlegroup = WoWUSBattlegroups.fromString(object.get("name").getAsString());
                tempArray[x] = battlegroup;
            }
        }

        return tempArray;
    }
}
