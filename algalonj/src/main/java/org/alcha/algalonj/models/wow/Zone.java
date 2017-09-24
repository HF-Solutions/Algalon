package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalonj.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 19:36.</p>
 */

public class Zone {
    private int mId;
    private String mName;
    private String mUrlSlug;
    private String mDescription;
    private Location mLocation;
    private int mExpansionId;
    private String mNumPlayers;
    private boolean mIsDungeon;
    private boolean mIsRaid;
    private int mAdvisedMinLevel;
    private int mAdvisedMaxLevel;
    private int mAdvisedHeroicMinLevel;
    private int mAdvisedHeroicMaxLevel;
    private String[] mAvailableModes;
    private int mLFGNormalMinGearLevel;
    private int mLFGHeroicMinGearLevel;
    private int mFloors;
    private List<Boss> mBosses;

    public Zone() {

    }

    @Override
    public String toString() {
        return "Id=" + mId + "; " +
                "Name=" + mName + "; " +
                "Description=" + mDescription + ";";
    }

    public static Zone newInstanceFromJson(JsonObject jsonObject) {
        Zone zone = new Zone();

        if (jsonObject.has("id"))
            zone.setId(jsonObject.get("id").getAsInt());
        else zone.setId(-1);

        if (jsonObject.has("name"))
            zone.setName(jsonObject.get("name").getAsString());
        else zone.setName("");

        if (jsonObject.has("urlSlug"))
            zone.setUrlSlug(jsonObject.get("urlSlug").getAsString());
        else zone.setUrlSlug("");

        if (jsonObject.has("description"))
            zone.setDescription(jsonObject.get("description").getAsString());
        else zone.setDescription("");

        if (jsonObject.has("location"))
            zone.setLocation(Location.newInstanceFromJson(jsonObject.getAsJsonObject("location")));
        else zone.setLocation(new Location());

        if (jsonObject.has("expansionId"))
            zone.setExpansionId(jsonObject.get("expansionId").getAsInt());
        else zone.setExpansionId(-1);

        if (jsonObject.has("numPlayers"))
            zone.setNumPlayers(jsonObject.get("numPlayers").getAsString());
        else zone.setNumPlayers("-1");

        if (jsonObject.has("isDungeon"))
            zone.setDungeon(jsonObject.get("isDungeon").getAsBoolean());
        else zone.setDungeon(false);

        if (jsonObject.has("isRaid"))
            zone.setRaid(jsonObject.get("isRaid").getAsBoolean());
        else zone.setRaid(false);

        if (jsonObject.has("advisedMinLevel"))
            zone.setAdvisedMinLevel(jsonObject.get("advisedMinLevel").getAsInt());
        else zone.setAdvisedMinLevel(-1);

        if (jsonObject.has("advisedMaxLevel"))
            zone.setAdvisedMaxLevel(jsonObject.get("advisedMaxLevel").getAsInt());
        else zone.setAdvisedMaxLevel(-1);

        if (jsonObject.has("advisedHeroicMinLevel"))
            zone.setAdvisedHeroicMinLevel(jsonObject.get("advisedHeroicMinLevel").getAsInt());
        else zone.setAdvisedHeroicMinLevel(-1);

        if (jsonObject.has("advisedHeroicMaxLevel"))
            zone.setAdvisedHeroicMaxLevel(jsonObject.get("advisedHeroicMaxLevel").getAsInt());
        else zone.setAdvisedHeroicMaxLevel(-1);

        if (jsonObject.has("availableModes"))
            zone.setAvailableModes(JsonAid.jsonArrayToArrayStr(jsonObject.getAsJsonArray("availableModes")));
        else zone.setAvailableModes(new String[0]);

        if (jsonObject.has("lfgNormalMinGearLevel"))
            zone.setLFGHeroicMinGearLevel(jsonObject.get("lfgNormalMinGearLevel").getAsInt());
        else zone.setLFGHeroicMinGearLevel(-1);

        if (jsonObject.has("lfgHeroicMinGearLevel"))
            zone.setLFGNormalMinGearLevel(jsonObject.get("lfgHeroicMinGearLevel").getAsInt());
        else zone.setLFGHeroicMinGearLevel(-1);

        if (jsonObject.has("floors"))
            zone.setFloors(jsonObject.get("floors").getAsInt());
        else zone.setFloors(-1);

        if (jsonObject.has("bosses"))
            zone.setBosses(Boss.parseJsonArray(jsonObject.getAsJsonArray("bosses")));
        else zone.setBosses(new ArrayList<Boss>());

        return zone;
    }

    public static List<Zone> parseJsonArray(JsonElement jsonArray) {
        List<Zone> zones = new ArrayList<>();

        if (!(jsonArray instanceof JsonArray))
            jsonArray = jsonArray.getAsJsonObject().getAsJsonArray("zones");

        for (JsonElement element : jsonArray.getAsJsonArray())
            zones.add(newInstanceFromJson(element.getAsJsonObject()));

        return zones;
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

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public int getExpansionId() {
        return mExpansionId;
    }

    public void setExpansionId(int expansionId) {
        mExpansionId = expansionId;
    }

    public String getNumPlayers() {
        return mNumPlayers;
    }

    public void setNumPlayers(String numPlayers) {
        mNumPlayers = numPlayers;
    }

    public boolean isDungeon() {
        return mIsDungeon;
    }

    public void setDungeon(boolean dungeon) {
        mIsDungeon = dungeon;
    }

    public boolean isRaid() {
        return mIsRaid;
    }

    public void setRaid(boolean raid) {
        mIsRaid = raid;
    }

    public int getAdvisedMinLevel() {
        return mAdvisedMinLevel;
    }

    public void setAdvisedMinLevel(int advisedMinLevel) {
        mAdvisedMinLevel = advisedMinLevel;
    }

    public int getAdvisedMaxLevel() {
        return mAdvisedMaxLevel;
    }

    public void setAdvisedMaxLevel(int advisedMaxLevel) {
        mAdvisedMaxLevel = advisedMaxLevel;
    }

    public int getAdvisedHeroicMinLevel() {
        return mAdvisedHeroicMinLevel;
    }

    public void setAdvisedHeroicMinLevel(int advisedHeroicMinLevel) {
        mAdvisedHeroicMinLevel = advisedHeroicMinLevel;
    }

    public int getAdvisedHeroicMaxLevel() {
        return mAdvisedHeroicMaxLevel;
    }

    public void setAdvisedHeroicMaxLevel(int advisedHeroicMaxLevel) {
        mAdvisedHeroicMaxLevel = advisedHeroicMaxLevel;
    }

    public String[] getAvailableModes() {
        return mAvailableModes;
    }

    public void setAvailableModes(String[] availableModes) {
        mAvailableModes = availableModes;
    }

    public int getLFGNormalMinGearLevel() {
        return mLFGNormalMinGearLevel;
    }

    public void setLFGNormalMinGearLevel(int LFGNormalMinGearLevel) {
        mLFGNormalMinGearLevel = LFGNormalMinGearLevel;
    }

    public int getLFGHeroicMinGearLevel() {
        return mLFGHeroicMinGearLevel;
    }

    public void setLFGHeroicMinGearLevel(int LFGHeroicMinGearLevel) {
        mLFGHeroicMinGearLevel = LFGHeroicMinGearLevel;
    }

    public int getFloors() {
        return mFloors;
    }

    public void setFloors(int floors) {
        mFloors = floors;
    }

    public List<Boss> getBosses() {
        return mBosses;
    }

    public void setBosses(List<Boss> bosses) {
        mBosses = bosses;
    }

    public static class Location {
        private int id;
        private String name;

        public Location(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Location() {
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

        public static Location newInstanceFromJson(JsonObject jsonObject) {
            Location location = new Location();

            if (jsonObject.has("id"))
                location.setId(jsonObject.get("id").getAsInt());
            else location.setId(-1);

            if (jsonObject.has("name"))
                location.setName(jsonObject.get("name").getAsString());
            else location.setName("");

            return location;
        }
    }
}
