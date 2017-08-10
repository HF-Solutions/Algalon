package org.alcha.algalona.models.wow.guilds;

import android.util.Log;

import org.alcha.algalona.models.wow.characters.WoWCharacterField;
import org.alcha.algalona.models.wow.battlegroups.WoWBattlegroup;
import org.alcha.algalona.models.wow.battlegroups.WoWUSBattlegroups;
import org.alcha.algalona.models.wow.battlegroups.WoWEUBattlegroups;
import org.alcha.algalona.models.wow.realms.WoWEURealms;
import org.alcha.algalona.models.wow.realms.WoWRealm;
import org.alcha.algalona.models.wow.realms.WoWUSRealms;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * Represents a guild in WoW and stores the fields available from the Battle.net API as of file
 * creation.
 */
public class WoWGuild {
    /** A log tag to be used for debugging and error logs **/
    private static final String LOG_TAG = "WoWGuild";

    /**
     * Stores the Unix timestamp for when the stored guild info was last modified on the battle.net
     * servers. If the value is 0000000000000, it's most likely a guild for a
     * {@link WoWCharacterField} as the API
     * call for this object does not return a modified timestamp.
     */
    private long mLastModified = 0000000000000;

    /** Stores the name of the guild **/
    private String mName;

    /** Stores the WoWRealm where the guild is located **/
    private WoWRealm mRealm;

    /** Stores the WoWBattlegroup where the guild realm is located **/
    private WoWBattlegroup mBattlegroup;

    /** Stores the guilds custom emblem information **/
    private WoWGuildEmblem mEmblem;

    /** Stores the guild level **/
    private int mLevel;

    /** Stores the side/faction of the guild **/
    private int mSide;

    /** Stores the amount of achievement points the guild has earned **/
    private int mAchievementPoints;

    private WoWGuild() {
    }

    public static WoWGuild newInstance() {
        return new WoWGuild();
    }

    public static WoWGuild newInstanceFromJSON(JSONObject jsonObject) {
        WoWGuild guild = new WoWGuild();
        try {
            guild.setLastModified(jsonObject.getLong("lastModified"));
            guild.setName(jsonObject.getString("name"));
            guild.setRealm(parseGuildRealm(jsonObject));
            guild.setBattleGroup(parseGuildBattlegroup(jsonObject));
            guild.setSide(jsonObject.getInt("side"));
            guild.setAchievementPoints(jsonObject.getInt("achievementPoints"));
            guild.setEmblem(WoWGuildEmblem.fromJSON(jsonObject.getJSONObject("emblem")));
        } catch (JSONException ex) {
            Log.e(LOG_TAG, "newInstanceFromJSON: ", ex);
        }
        return guild;
    }

    private static WoWBattlegroup parseGuildBattlegroup(JSONObject jsonObject) throws JSONException {
        if (WoWUSBattlegroups.fromString(jsonObject.getString("battlegroup")).equals(WoWUSRealms.Unknown)) {
            if (WoWEURealms.fromString(jsonObject.getString("battlegroup")).equals(WoWEURealms.Unknown)) {
                return WoWUSBattlegroups.Unknown;
            } else {
                return WoWEUBattlegroups.fromString(jsonObject.getString("battlegroup"));
            }
        } else {
            return WoWUSBattlegroups.fromString(jsonObject.getString("battlegroup"));
        }
    }

    private static WoWRealm parseGuildRealm(JSONObject jsonObject) throws JSONException {
        if (WoWUSRealms.fromString(jsonObject.getString("realm")).equals(WoWUSRealms.Unknown)) {
            if (WoWEURealms.fromString(jsonObject.getString("realm")).equals(WoWEURealms.Unknown)) {
                return WoWUSRealms.Unknown;
            } else {
                return WoWEURealms.fromString(jsonObject.getString("realm"));
            }
        } else {
            return WoWUSRealms.fromString(jsonObject.getString("realm"));
        }
    }

    public long getLastModified() {
        return mLastModified;
    }

    private void setLastModified(long lastModified) {
        mLastModified = lastModified;
    }

    public String getName() {
        return mName;
    }

    private void setName(String name) {
        mName = name;
    }

    public WoWRealm getRealm() {
        return mRealm;
    }

    private void setRealm(WoWRealm realm) {
        mRealm = realm;
    }

    public int getLevel() {
        return mLevel;
    }

    private void setLevel(int level) {
        mLevel = level;
    }

    public int getSide() {
        return mSide;
    }

    private void setSide(int side) {
        mSide = side;
    }

    public int getAchievementPoints() {
        return mAchievementPoints;
    }

    private void setAchievementPoints(int achievementPoints) {
        mAchievementPoints = achievementPoints;
    }

    public WoWBattlegroup getBattleGroup() {
        return mBattlegroup;
    }

    private void setBattleGroup(WoWBattlegroup battleGroup) {
        mBattlegroup = battleGroup;
    }

    public WoWGuildEmblem getEmblem() {
        return mEmblem;
    }

    private void setEmblem(WoWGuildEmblem emblem) {
        mEmblem = emblem;
    }
}
