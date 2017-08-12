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

    private long mTimestamp;
    private boolean mFeatOfStrength;

    private Type mEntryType;

    public Type getEntryType() {
        return mEntryType;
    }

    void setEntryType(Type type) {
        mEntryType = type;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    void setTimestamp(long timestamp) {
        mTimestamp = timestamp;
    }

    public boolean isFeatOfStrength() {
        return mFeatOfStrength;
    }

    void setFeatOfStrength(boolean featOfStrength) {
        mFeatOfStrength = featOfStrength;
    }
}
