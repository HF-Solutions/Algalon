package org.alcha.algalonj.models.wow.guilds;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.Battlegroup;
import org.alcha.algalonj.models.wow.Realm;
import org.alcha.algalonj.models.wow.characters.CharacterField;

import java.util.Map;
import java.util.TreeMap;

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

    /** Stores the Realm where the guild is located **/
    private Realm mRealm;

    /** Stores the Battlegroup where the guild realm is located **/
    private Battlegroup mBattlegroup;

    /** Stores the guilds custom emblem information **/
    private GuildEmblem mEmblem;

    /** Stores the guild level **/
    private int mLevel;

    /** Stores the side/faction of the guild **/
    private int mSide;

    /** Stores the amount of achievement points the guild has earned **/
    private int mAchievementPoints;

    private Map<GuildField.Name, GuildField> mFieldMap;

    public Guild() {
        mFieldMap = new TreeMap<>();
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
            guild.setRealm(Realm.newInstanceFromJson(jsonObject));
        else guild.setRealm(Realm.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("battlegroup"))
            guild.setBattleGroup(Battlegroup.newInstanceFromJson(jsonObject));
        else guild.setBattleGroup(Battlegroup.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("side"))
            guild.setSide(jsonObject.get("side").getAsInt());
        else guild.setSide(-1);

        if (jsonObject.has("achievementPoints"))
            guild.setAchievementPoints(jsonObject.get("achievementPoints").getAsInt());
        else guild.setAchievementPoints(-1);

        if (jsonObject.has("emblem"))
            guild.setEmblem(GuildEmblem.newInstanceFromJson(jsonObject.getAsJsonObject("emblem")));
        else guild.setEmblem(GuildEmblem.newInstanceFromJson(new JsonObject()));

        guild = parseOptionalFields(guild, jsonObject);

        return guild;
    }

    public static Guild parseOptionalFields(Guild guild, JsonObject jsonObject) {

        if (jsonObject.has("members") && jsonObject.get("members") instanceof JsonArray)
            guild.addField(GuildMembers.newInstanceFromJson(jsonObject.getAsJsonArray("members")));

        if (jsonObject.has("achievements"))
            guild.addField(GuildAchievements.newInstanceFromJson(jsonObject.getAsJsonObject("achievements")));

        if (jsonObject.has("news"))
            guild.addField(GuildNews.newInstanceFromJson(jsonObject.getAsJsonArray("news")));

        if (jsonObject.has("challenge"))
            guild.addField(GuildChallenges.newInstanceFromJson(jsonObject.getAsJsonArray("challenge")));

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

    public Realm getRealm() {
        return mRealm;
    }

    public void setRealm(Realm realm) {
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

    public Battlegroup getBattleGroup() {
        return mBattlegroup;
    }

    public void setBattleGroup(Battlegroup battleGroup) {
        mBattlegroup = battleGroup;
    }

    public GuildEmblem getEmblem() {
        return mEmblem;
    }

    public void setEmblem(GuildEmblem emblem) {
        mEmblem = emblem;
    }

    public Map<GuildField.Name, GuildField> getFieldMap() {
        return mFieldMap;
    }

    public void setFieldMap(Map<GuildField.Name, GuildField> fieldMap) {
        mFieldMap = fieldMap;
    }

    public void addField(GuildField field) {
        mFieldMap.put(field.getFieldName(), field);
    }

    public <T extends GuildField> T getField(GuildField.Name fieldName) {
        return (T) mFieldMap.get(fieldName);
    }
}
