package org.alcha.algalona.models.wow.characters;

import org.json.JSONObject;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeedLoot extends WoWCharacterFeedEntry {
    private WoWCharacterFeedLoot() {
        setEntryType(Type.LOOT);
    }

    public WoWCharacterFeedLoot newInstance() {
        return new WoWCharacterFeedLoot();
    }

    public WoWCharacterFeedLoot newInstanceFromJSON(JSONObject jsonObject) {
        WoWCharacterFeedLoot feedLoot = new WoWCharacterFeedLoot();

        return feedLoot;
    }
}
