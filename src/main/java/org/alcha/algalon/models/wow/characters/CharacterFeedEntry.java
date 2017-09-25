package org.alcha.algalon.models.wow.characters;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 */

public abstract class CharacterFeedEntry {
    public enum Type {
        ACHIEVEMENT,
        CRITERIA,
        BOSSKILL,
        LOOT;

        @Override
        public String toString() {
            return name();
        }
    }

    private long mTimestamp;
    private boolean mFeatOfStrength;

    private Type mEntryType;

    public Type getEntryType() {
        return mEntryType;
    }

    public void setEntryType(Type type) {
        mEntryType = type;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(long timestamp) {
        mTimestamp = timestamp;
    }

    public boolean isFeatOfStrength() {
        return mFeatOfStrength;
    }

    public void setFeatOfStrength(boolean featOfStrength) {
        mFeatOfStrength = featOfStrength;
    }
}
