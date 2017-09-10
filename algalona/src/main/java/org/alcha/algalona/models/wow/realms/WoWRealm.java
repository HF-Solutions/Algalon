package org.alcha.algalona.models.wow.realms;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

public abstract class WoWRealm {
    public String getSlug() {
        return "";
    }

    public String getRelativeUrl() {
        return "";
    }

    public static WoWRealm newInstanceFromJson(JsonObject jsonObject) {
        if (WoWUSRealms.fromString(jsonObject.get("realm").getAsString()).getName().equals(WoWUSRealms.Name.Unknown)) {
            if (WoWEURealms.fromString(jsonObject.get("realm").getAsString()).getName().equals(WoWEURealms.Name.Unknown)) {
                WoWUSRealms unknown = new WoWUSRealms();
                unknown.setName(WoWUSRealms.Name.Unknown);
                return unknown;
            } else {
                return WoWEURealms.fromString(jsonObject.get("realm").getAsString());
            }
        } else {
            return WoWUSRealms.fromString(jsonObject.get("realm").getAsString());
        }
    }
}
