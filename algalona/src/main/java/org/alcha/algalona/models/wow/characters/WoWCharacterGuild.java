package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Region;
import org.alcha.algalona.models.wow.WoWFaction;
import org.alcha.algalona.models.wow.battlegroups.WoWBattlegroup;
import org.alcha.algalona.models.wow.battlegroups.WoWEUBattlegroups;
import org.alcha.algalona.models.wow.battlegroups.WoWUSBattlegroups;
import org.alcha.algalona.models.wow.guilds.WoWGuildEmblem;
import org.alcha.algalona.models.wow.realms.WoWEURealms;
import org.alcha.algalona.models.wow.realms.WoWRealm;
import org.alcha.algalona.models.wow.realms.WoWUSRealms;

import static org.alcha.algalona.network.AlgalonClient.getClientRegion;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterGuild extends WoWCharacterField {
    private static final String LOG_TAG = "WoWCharacterGuild";
    private long mLastModified;
    private String mName;
    private WoWRealm mRealm;
    private WoWBattlegroup mBattlegroup;
    private int mLevel;
    private WoWFaction mFaction;
    private int mAchievementPoints;
    private WoWGuildEmblem mEmblem;

    private WoWCharacterGuild() {

    }

    public static WoWCharacterGuild newInstance() {
        return new WoWCharacterGuild();
    }

    public static WoWCharacterGuild newInstanceFromJson(JsonObject jsonObject) {
        WoWCharacterGuild characterGuild = new WoWCharacterGuild();
        Region region = getClientRegion();

        if (jsonObject.has("lastModified"))
            characterGuild.setLastModified(jsonObject.get("lastModified").getAsLong());

        if (jsonObject.has("name"))
            characterGuild.setName(jsonObject.get("name").getAsString());

        if (jsonObject.has("realm")) {
            if (region == Region.US) {
                characterGuild.setRealm(WoWUSRealms.fromString(jsonObject.get("realm").getAsString()));
            } else if (region == Region.EU) {
                characterGuild.setRealm(WoWEURealms.fromString(jsonObject.get("realm").getAsString()));
            }
        }

        if (jsonObject.has("battlegroup")) {
            if (region == Region.US) {
                characterGuild.setBattlegroup(WoWUSBattlegroups.fromString(jsonObject.get("battlegroup").getAsString()));
            } else if (region == Region.EU) {
                characterGuild.setBattlegroup(WoWEUBattlegroups.fromString(jsonObject.get("battlegroup").getAsString()));
            }
        }

        if (jsonObject.has("level"))
            characterGuild.setLevel(jsonObject.get("level").getAsInt());

        if (jsonObject.has("side"))
            characterGuild.setFaction(WoWFaction.fromId(jsonObject.get("side").getAsInt()));

        if (jsonObject.has("achievementPoints"))
            characterGuild.setAchievementPoints(jsonObject.get("achievementPoints").getAsInt());

        if (jsonObject.has("emblem"))
            characterGuild.setEmblem(WoWGuildEmblem.newInstanceFromJSON(jsonObject.getAsJsonObject("emblem")));

        return characterGuild;
    }

    void setEmblem(WoWGuildEmblem emblem) {
        mEmblem = emblem;
    }

    void setLastModified(long lastModified) {
        mLastModified = lastModified;
    }

    public long getLastModified() {
        return mLastModified;
    }

    void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    <T extends WoWRealm> void setRealm(T realm) {
        mRealm = realm;
    }

    public WoWRealm getRealm() {
        return mRealm;
    }

    <T extends WoWBattlegroup> void setBattlegroup(T battlegroup) {
        mBattlegroup = battlegroup;
    }

    public WoWBattlegroup getBattlegroup() {
        return mBattlegroup;
    }

    void setLevel(int level) {
        mLevel = level;
    }

    public int getLevel() {
        return mLevel;
    }

    void setFaction(WoWFaction faction) {
        mFaction = faction;
    }

    public WoWFaction getFaction() {
        return mFaction;
    }

    void setAchievementPoints(int achievementPoints) {
        mAchievementPoints = achievementPoints;
    }

    public int getAchievementPoints() {
        return mAchievementPoints;
    }
}
