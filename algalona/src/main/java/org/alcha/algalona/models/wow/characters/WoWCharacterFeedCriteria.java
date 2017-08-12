package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeedCriteria extends WoWCharacterFeedEntry {
    private WoWCharacterFeedCriteria() {
        setEntryType(Type.CRITERIA);
    }

    public WoWCharacterFeedCriteria newInstance() { return new WoWCharacterFeedCriteria();}

    public static WoWCharacterFeedCriteria newInstanceFromJson(JsonObject jsonObject) {
        WoWCharacterFeedCriteria feedCriteria = new WoWCharacterFeedCriteria();

        return feedCriteria;
    }
}
