package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/12/2017.</p>
 */

public class WoWBoss {
    public static class NPC {
        private int id;
        private String name;
        private String urlSlug;
        private int creatureDisplayId;

        @Override
        public String toString() {
            return "id = " + id + "; " +
                    "name = " + name + "; " +
                    "urlSlug = " + urlSlug + "; " +
                    "creatureDisplayId = " + creatureDisplayId + ";";
        }

        public static NPC newInstanceFromJson(JsonObject jsonObject) {
            NPC npc = new NPC();
            if (jsonObject.has("id"))
                npc.setId(jsonObject.get("id").getAsInt());
            if (jsonObject.has("name"))
                npc.setName(jsonObject.get("name").getAsString());
            if (jsonObject.has("urlSlug"))
                npc.setUrlSlug(jsonObject.get("urlSlug").getAsString());
            if (jsonObject.has("creatureDisplayId"))
                npc.setCreatureDisplayId(jsonObject.get("creatureDisplayId").getAsInt());

            return npc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrlSlug() {
            return urlSlug;
        }

        public void setUrlSlug(String urlSlug) {
            this.urlSlug = urlSlug;
        }

        public int getCreatureDisplayId() {
            return creatureDisplayId;
        }

        public void setCreatureDisplayId(int creatureDisplayId) {
            this.creatureDisplayId = creatureDisplayId;
        }
    }

    private static final String LOG_TAG = "WoWBoss";
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
    private NPC[] npcs;

    private WoWBoss() {

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

    public static WoWBoss newInstanceFromJson(JsonObject jsonObject) {
        WoWBoss boss = new WoWBoss();

        if (jsonObject.has("id"))
            boss.setId(jsonObject.get("id").getAsInt());
        else
            boss.setId(-1);

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
            boss.setNPCs(parseNPCs(jsonObject.getAsJsonArray("npcs")));
        else boss.setNPCs(new NPC[0]);

        return boss;
    }

    public static NPC[] parseNPCs(JsonArray jsonArray) {
        NPC[] npcs = new NPC[jsonArray.size()];

        for (int x = 0; x < jsonArray.size(); x++) {
            JsonObject jsonObject = jsonArray.get(x).getAsJsonObject();

            npcs[x] = NPC.newInstanceFromJson(jsonObject);
        }

        return npcs;
    }

    public int getId() {
        return mId;
    }

    void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    void setName(String name) {
        mName = name;
    }

    public String getUrlSlug() {
        return mUrlSlug;
    }

    void setUrlSlug(String urlSlug) {
        mUrlSlug = urlSlug;
    }

    public String getDescription() {
        return mDescription;
    }

    void setDescription(String description) {
        mDescription = description;
    }

    public int getZoneId() {
        return mZoneId;
    }

    void setZoneId(int zoneId) {
        mZoneId = zoneId;
    }

    public boolean isAvailableInNormalMode() {
        return mAvailableInNormalMode;
    }

    void setIsAvailableInNormalMode(boolean isAvailableInNormalMode) {
        mAvailableInNormalMode = isAvailableInNormalMode;
    }

    public boolean isAvailableInHeroicMode() {
        return mAvailableInHeroicMode;
    }

    void setIsAvailableInHeroicMode(boolean isAvailableInHeroicMode) {
        mAvailableInHeroicMode = isAvailableInHeroicMode;
    }

    public long getHealth() {
        return mHealth;
    }

    void setHealth(long health) {
        mHealth = health;
    }

    public long getHeroicHealth() {
        return mHeroicHealth;
    }

    void setHeroicHealth(long heroicHealth) {
        mHeroicHealth = heroicHealth;
    }

    public int getLevel() {
        return mLevel;
    }

    void setLevel(int level) {
        mLevel = level;
    }

    public int getHeroicLevel() {
        return mHeroicLevel;
    }

    void setHeroicLevel(int heroicLevel) {
        mHeroicLevel = heroicLevel;
    }

    public int getJournalId() {
        return mJournalId;
    }

    void setJournalId(int journalId) {
        mJournalId = journalId;
    }

    public NPC[] getNPCs() {
        return npcs;
    }

    void setNPCs(NPC[] npcs) {
        this.npcs = npcs;
    }
}
