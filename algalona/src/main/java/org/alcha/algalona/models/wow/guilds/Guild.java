package org.alcha.algalona.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.battlegroups.WoWBattlegroup;
import org.alcha.algalona.models.wow.characters.CharacterField;
import org.alcha.algalona.models.wow.realms.WoWRealm;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * Represents a guild in WoW and stores the fields available from the Battle.net API.
 */
public class Guild {
    /** A log tag to be used for debugging and error logs **/
    private static final String LOG_TAG = "Guild";

    /**
     * Stores the Unix timestamp for when the stored guild info was last modified on the battle.net
     * servers. If the value is 0000000000000, it's most likely a guild for a
     * {@link CharacterField} as the API
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
    private GuildEmblem mEmblem;

    /** Stores the guild level **/
    private int mLevel;

    /** Stores the side/faction of the guild **/
    private int mSide;

    /** Stores the amount of achievement points the guild has earned **/
    private int mAchievementPoints;

    private Guild() {
    }

    public static Guild newInstanceFromJson(JsonObject jsonObject) {
        Guild guild = new Guild();

        if (jsonObject.has("lastModified"))
            guild.setLastModified(jsonObject.get("lastModified").getAsLong());
        else guild.setLastModified(-1);

        if (jsonObject.has("name"))
            guild.setName(jsonObject.get("name").getAsString());
        else guild.setName("");

        if (jsonObject.has("realm"))
            guild.setRealm(WoWRealm.newInstanceFromJson(jsonObject));
        else guild.setRealm(WoWRealm.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("battlegroup"))
            guild.setBattleGroup(WoWBattlegroup.newInstanceFromJson(jsonObject));
        else guild.setBattleGroup(WoWBattlegroup.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("side"))
            guild.setSide(jsonObject.get("side").getAsInt());
        else guild.setSide(-1);

        if (jsonObject.has("achievementPoints"))
            guild.setAchievementPoints(jsonObject.get("achievementPoints").getAsInt());
        else guild.setAchievementPoints(-1);

        if (jsonObject.has("emblem"))
            guild.setEmblem(GuildEmblem.newInstanceFromJson(jsonObject.getAsJsonObject("emblem")));
        else guild.setEmblem(GuildEmblem.newInstanceFromJson(new JsonObject()));

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

    public WoWRealm getRealm() {
        return mRealm;
    }

    public void setRealm(WoWRealm realm) {
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
        return mBattlegroup;
    }

    public void setBattleGroup(WoWBattlegroup battleGroup) {
        mBattlegroup = battleGroup;
    }

    public GuildEmblem getEmblem() {
        return mEmblem;
    }

    public void setEmblem(GuildEmblem emblem) {
        mEmblem = emblem;
    }
}
