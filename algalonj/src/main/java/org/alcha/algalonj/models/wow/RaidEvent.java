package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 13:06.</p>
 */

public class RaidEvent {
    private String mName;
    private int mLFR;
    private int mNormal;
    private int mHeroic;
    private int mMythic;
    private int mId;
    private List<BossKill> mBosses;

    public RaidEvent() {

    }

    public static RaidEvent newInstanceFromJson(JsonObject jsonObject) {
        RaidEvent event = new RaidEvent();
        if (jsonObject.has("name"))
            event.setName(jsonObject.get("name").getAsString());
        else event.setName("");

        if (jsonObject.has("lfr"))
            event.setLFR(jsonObject.get("lfr").getAsInt());
        else event.setLFR(-1);

        if (jsonObject.has("normal"))
            event.setNormal(jsonObject.get("normal").getAsInt());
        else event.setNormal(-1);

        if (jsonObject.has("heroic"))
            event.setHeroic(jsonObject.get("heroic").getAsInt());
        else event.setHeroic(-1);

        if (jsonObject.has("mythic"))
            event.setMythic(jsonObject.get("mythic").getAsInt());
        else event.setMythic(-1);

        if (jsonObject.has("id"))
            event.setId(jsonObject.get("id").getAsInt());

        if (jsonObject.has("bosses")) {
            JsonArray bosses = jsonObject.getAsJsonArray("bosses");

            for (int x = 0; x < bosses.size(); x++) {
                BossKill bossKill = new BossKill().newInstanceFromJson(bosses.get(x).getAsJsonObject());
                event.addBoss(bossKill);
            }
        }

        return event;
    }

    public static List<RaidEvent> parseJsonArray(JsonArray raids) {
        List<RaidEvent> tempList = new ArrayList<>();

        for (int x = 0; x < raids.size(); x++) {
            tempList.add(newInstanceFromJson(raids.get(x).getAsJsonObject()));
        }

        return tempList;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getLFR() {
        return mLFR;
    }

    public void setLFR(int LFR) {
        mLFR = LFR;
    }

    public int getNormal() {
        return mNormal;
    }

    public void setNormal(int normal) {
        mNormal = normal;
    }

    public int getHeroic() {
        return mHeroic;
    }

    public void setHeroic(int heroic) {
        mHeroic = heroic;
    }

    public int getMythic() {
        return mMythic;
    }

    public void setMythic(int mythic) {
        mMythic = mythic;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public BossKill getBoss(int index) {
        return mBosses.get(index);
    }

    public List<BossKill> getBosses() {
        return mBosses;
    }

    public void setBosses(List<BossKill> bosses) {
        mBosses = bosses;
    }

    public void addBoss(BossKill boss) {
        mBosses.add(boss);
    }

    public void addBoss(int index, BossKill boss) {
        mBosses.add(index, boss);
    }

    public void addBosses(List<BossKill> bosses) {
        mBosses.addAll(bosses);
    }

    public static class BossKill {
        public int id;
        public String name;
        public int lfrKills;
        public long lfrTimestamp;
        public int normalKills;
        public long normalTimestamp;
        public int heroicKills;
        public long heroicTimestamp;
        public int mythicKills;
        public long mythicTimestamp;

        public BossKill() {

        }

        public BossKill newInstanceFromJson(JsonObject jsonObject) {
            if (jsonObject.has("id")) this.id = jsonObject.get("id").getAsInt();
            else this.id = -1;

            if (jsonObject.has("name")) this.name = jsonObject.get("name").getAsString();
            else this.name = "";

            if (jsonObject.has("lfrKills")) this.lfrKills = jsonObject.get("lfrKills").getAsInt();
            else this.lfrKills = -1;

            if (jsonObject.has("lfrTimestamp"))
                this.lfrTimestamp = jsonObject.get("lfrTimestamp").getAsLong();
            else this.lfrTimestamp = -1;

            if (jsonObject.has("normalKills"))
                this.normalKills = jsonObject.get("normalKills").getAsInt();
            else this.normalKills = -1;

            if (jsonObject.has("normalTimestamp"))
                this.normalTimestamp = jsonObject.get("normalTimestamp").getAsLong();
            else this.normalTimestamp = -1;

            if (jsonObject.has("heroicKills"))
                this.heroicKills = jsonObject.get("heroicKills").getAsInt();
            else this.heroicKills = -1;

            if (jsonObject.has("heroicTimestamp"))
                this.heroicTimestamp = jsonObject.get("heroicTimestamp").getAsLong();
            else this.heroicTimestamp = -1;

            if (jsonObject.has("mythicKills"))
                this.mythicKills = jsonObject.get("mythicKills").getAsInt();
            else this.mythicKills = -1;

            if (jsonObject.has("mythicTimestamp"))
                this.mythicTimestamp = jsonObject.get("mythicTimestamp").getAsLong();
            else this.mythicTimestamp = -1;

            return this;
        }
    }
}
