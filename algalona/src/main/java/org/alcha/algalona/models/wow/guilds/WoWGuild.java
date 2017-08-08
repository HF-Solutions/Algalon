package org.alcha.algalona.models.wow.guilds;

import org.alcha.algalona.models.wow.WoWBattlegroup;
import org.alcha.algalona.models.wow.realms.WoWRealms;
import org.json.JSONObject;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * Represents a guild in WoW and stores the fields available from the Battle.net API as of file
 * creation.
 */
public class WoWGuild {
    /** Represents a guilds custom emblem. */
    public static class Emblem {
        public String iconColor,
                borderColor,
                backgroundColor;

        public int icon,
                iconId,
                border,
                borderId,
                backgroundColorId;

        public Emblem() {
        }
    }

    /**
     * Stores the Unix timestamp for when the stored guild info was last modified on the battle.net
     * servers. If the value is 0000000000000, it's most likely a guild for a
     * {@link org.alcha.algalona.models.wow.characters.WoWCharacterField WoWCharacterField} as the API
     * call for this object does not return a modified timestamp.
     */
    private long mLastModified = 0000000000000;
    private String mName;
    private WoWRealms mRealm;
    private WoWBattlegroup mBattleGroup;
    private Emblem mEmblem;

    private int mLevel,
            mSide,
            mAchievementPoints;

    private WoWGuild() {
    }

    public static WoWGuild newInstance() {
        return new WoWGuild();
    }

    public static WoWGuild newInstanceFromJSON(JSONObject jsonObject) {
        WoWGuild guild = new WoWGuild();

        return guild;
    }

    public long getLastModified() {
        return mLastModified;
    }

    public void setLastModified(long lastModified) {
        mLastModified = lastModified;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public WoWRealms getRealm() {
        return mRealm;
    }

    public void setRealm(WoWRealms realm) {
        mRealm = realm;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getSide() {
        return mSide;
    }

    public void setSide(int side) {
        mSide = side;
    }

    public int getAchievementPoints() {
        return mAchievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        mAchievementPoints = achievementPoints;
    }

    public WoWBattlegroup getBattleGroup() {
        return mBattleGroup;
    }

    public void setBattleGroup(WoWBattlegroup battleGroup) {
        mBattleGroup = battleGroup;
    }

    public Emblem getEmblem() {
        return mEmblem;
    }

    public void setEmblem(Emblem emblem) {
        mEmblem = emblem;
    }
}
