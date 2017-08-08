package org.alcha.algalona.models.wow.characters;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 */

public class WoWCharacterFeedEntry {
    public enum Type {
        ACHIEVEMENT,
        CRITERIA,
        BOSSKILL,
        LOOT
    }

    private Type mEntryType;

    void setEntryType(Type type) {
        mEntryType = type;
    }
}
