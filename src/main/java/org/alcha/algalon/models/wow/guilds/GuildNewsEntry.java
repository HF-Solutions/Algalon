package org.alcha.algalon.models.wow.guilds;

import org.alcha.algalon.interfaces.FieldName;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 06:38.</p>
 */

public abstract class GuildNewsEntry {
    public enum Type implements FieldName {
        ITEM_CRAFT("itemCraft"),
        ITEM_LOOT("itemLoot"),
        ITEM_PURCHASE("itemPurchase"),
        PLAYER_ACHIEVEMENT("playerAchievement"),
        GUILD_ACHIEVEMENT("guildAchievement"),
        UNKNOWN("unknown");

        public String type;

        Type(String type) {
            this.type = type;
        }

        @Override
        public String getSlug() {
            return type;
        }

        @Override
        public String toString() {
            return name();
        }

        public static Type fromString(String string) {
            for (Type type : Type.values()) {
                if (type.type.equalsIgnoreCase(string)) return type;
            }

            return Type.UNKNOWN;
        }
    }

    private Type mType;
    private String mCharacterName;
    private long mTimestamp;
    private String mContext;
    private int[] mBonusLists;

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public String getCharacterName() {
        return mCharacterName;
    }

    public void setCharacterName(String characterName) {
        mCharacterName = characterName;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(long timestamp) {
        mTimestamp = timestamp;
    }

    public String getContext() {
        return mContext;
    }

    public void setContext(String context) {
        mContext = context;
    }

    public int[] getBonusLists() {
        return mBonusLists;
    }

    public void setBonusLists(int[] bonusLists) {
        mBonusLists = bonusLists;
    }
}
