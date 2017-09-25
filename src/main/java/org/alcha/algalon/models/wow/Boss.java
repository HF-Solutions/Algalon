package org.alcha.algalon.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/12/2017.</p>
 */

public class Boss {
    private static final String LOG_TAG = "Boss";
    private int mId;
    private String mName;
    private String mUrlSlug;
    private String mDescription;
    private int mZoneId;
    private boolean mAvailableInNormalMode;
    private boolean mAvailableInHeroicMode;
    private long mHealth;
    private long mHeroicHealth;
    private int mLevel;
    private int mHeroicLevel;
    private int mJournalId;
    private List<NPC> mNPCs;

    private Boss() {

    }

    @Override
    public String toString() {
        return "id = " + mId + "; " +
                "name = " + mName + "; " +
                "urlSlug = " + mUrlSlug + "; " +
                "description = " + mDescription + "; " +
                "zoneId = " + mZoneId + "; " +
                "health = " + mHealth + "; " +
                "heroicHealth = " + mHeroicHealth + "; " +
                "level = " + mLevel + "; " +
                "heroicLevel = " + mHeroicLevel + ";";
    }

    public static Boss newInstanceFromJson(JsonObject jsonObject) {
        Boss boss = new Boss();

        if (jsonObject.has("id"))
            boss.setId(jsonObject.get("id").getAsInt());
        else boss.setId(-1);

        if (jsonObject.has("name"))
            boss.setName(jsonObject.get("name").getAsString());
        else boss.setName("Unknown");

        if (jsonObject.has("urlSlug"))
            boss.setUrlSlug(jsonObject.get("urlSlug").getAsString());
        else boss.setUrlSlug("Unknown");

        if (jsonObject.has("description"))
            boss.setDescription(jsonObject.get("description").getAsString());
        else boss.setDescription("Unknown");

        if (jsonObject.has("zoneId"))
            boss.setZoneId(jsonObject.get("zoneId").getAsInt());
        else boss.setZoneId(-1);

        if (jsonObject.has("availableInNormalMode"))
            boss.setIsAvailableInNormalMode(jsonObject.get("availableInNormalMode").getAsBoolean());
        else boss.setIsAvailableInNormalMode(false);

        if (jsonObject.has("availableInHeroicMode"))
            boss.setIsAvailableInHeroicMode(jsonObject.get("availableInHeroicMode").getAsBoolean());
        else boss.setIsAvailableInHeroicMode(false);

        if (jsonObject.has("health"))
            boss.setHealth(jsonObject.get("health").getAsLong());
        else boss.setHealth(-1);

        if (jsonObject.has("heroicHealth"))
            boss.setHeroicHealth(jsonObject.get("heroicHealth").getAsLong());
        else boss.setHeroicHealth(-1);

        if (jsonObject.has("level"))
            boss.setLevel(jsonObject.get("level").getAsInt());
        else boss.setLevel(-1);

        if (jsonObject.has("heroicLevel"))
            boss.setHeroicLevel(jsonObject.get("heroicLevel").getAsInt());
        else boss.setHeroicLevel(-1);

        if (jsonObject.has("journalId"))
            boss.setJournalId(jsonObject.get("journalId").getAsInt());
        else boss.setJournalId(-1);

        if (jsonObject.has("npcs"))
            boss.setNPCs(NPC.parseJsonArray(jsonObject.getAsJsonArray("npcs")));
        else boss.setNPCs(new ArrayList<NPC>());

        return boss;
    }

    public static List<Boss> parseJsonArray(JsonArray jsonArray) {
        List<Boss> bosses = new ArrayList<>();

        for (JsonElement element : jsonArray)
            bosses.add(newInstanceFromJson(element.getAsJsonObject()));

        return bosses;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrlSlug() {
        return mUrlSlug;
    }

    public void setUrlSlug(String urlSlug) {
        mUrlSlug = urlSlug;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getZoneId() {
        return mZoneId;
    }

    public void setZoneId(int zoneId) {
        mZoneId = zoneId;
    }

    public boolean isAvailableInNormalMode() {
        return mAvailableInNormalMode;
    }

    public void setIsAvailableInNormalMode(boolean isAvailableInNormalMode) {
        mAvailableInNormalMode = isAvailableInNormalMode;
    }

    public boolean isAvailableInHeroicMode() {
        return mAvailableInHeroicMode;
    }

    public void setIsAvailableInHeroicMode(boolean isAvailableInHeroicMode) {
        mAvailableInHeroicMode = isAvailableInHeroicMode;
    }

    public long getHealth() {
        return mHealth;
    }

    public void setHealth(long health) {
        mHealth = health;
    }

    public long getHeroicHealth() {
        return mHeroicHealth;
    }

    public void setHeroicHealth(long heroicHealth) {
        mHeroicHealth = heroicHealth;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getHeroicLevel() {
        return mHeroicLevel;
    }

    public void setHeroicLevel(int heroicLevel) {
        mHeroicLevel = heroicLevel;
    }

    public int getJournalId() {
        return mJournalId;
    }

    public void setJournalId(int journalId) {
        mJournalId = journalId;
    }

    public List<NPC> getNPCs() {
        return mNPCs;
    }

    public void setNPCs(List<NPC> NPCs) {
        mNPCs = NPCs;
    }
}
