package org.alcha.algalona.models.wow.battlegroups;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 * Interface that represents a Battlegroup in WoW. Since there's a separate list for EU and US, each
 * one has overlapping names. Instead of using one giant enum and then trying to figure out which
 * belongs where, this interface is the middleman for {@link WoWUSBattlegroups} and
 * {@link WoWEUBattlegroups}.
 */
public abstract class WoWBattlegroup {
    /** Returns the slug to be used for URL request fields **/
    public String getSlug() {
        return "";
    }

    /** Returns the relative URL to be used for URL request parameters **/
    public String getRelativeUrl() {
        return "";
    }

    public static WoWBattlegroup newInstanceFromJson(JsonObject jsonObject) {
        if (WoWUSBattlegroups.fromString(jsonObject.get("realm").getAsString()).getName().equals(WoWUSBattlegroups.Name.Unknown)) {
            if (WoWEUBattlegroups.fromString(jsonObject.get("realm").getAsString()).getName().equals(WoWEUBattlegroups.Name.Unknown)) {
                WoWUSBattlegroups unknown = new WoWUSBattlegroups();
                unknown.setName(WoWUSBattlegroups.Name.Unknown);
                return unknown;
            } else {

                return WoWEUBattlegroups.fromString(jsonObject.get("realm").getAsString());
            }
        } else {
            return WoWUSBattlegroups.fromString(jsonObject.get("realm").getAsString());
        }
    }
}
