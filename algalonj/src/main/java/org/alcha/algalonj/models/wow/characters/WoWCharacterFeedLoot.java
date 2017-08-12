package org.alcha.algalonj.models.wow.characters;

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
