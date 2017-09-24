package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 18:19.</p>
 */

public class PvPLeaderboards {
    private int mClassId;
    private Faction mFaction;
    private int mGender;
    private String mName;
    private Race mRace;
    private int mRanking;
    private int mRating;
    private int mRealmId;
    private String mRealmName;
    private String mRealmSlug;
    private int mSeasonLosses;
    private int mSeasonWins;
    private int mSpecId;
    private int mWeeklyLosses;
    private int mWeeklyWins;

    public PvPLeaderboards() {
    }

    public static PvPLeaderboards newInstanceFromJson(JsonObject jsonObject) {
        PvPLeaderboards leaderboards = new PvPLeaderboards();

        if (jsonObject.has("classId"))
            leaderboards.setClassId(jsonObject.get("classId").getAsInt());
        else leaderboards.setClassId(-1);

        if (jsonObject.has("factionId"))
            leaderboards.setFaction(Faction.fromId(jsonObject.get("factionId").getAsInt()));
        else leaderboards.setFaction(Faction.UNKNOWN);

        if (jsonObject.has("genderId"))
            leaderboards.setGender(jsonObject.get("genderId").getAsInt());
        else leaderboards.setGender(-1);

        if (jsonObject.has("name"))
            leaderboards.setName(jsonObject.get("name").getAsString());
        else leaderboards.setName("");

        if (jsonObject.has("raceId"))
            leaderboards.setRace(Race.fromId(jsonObject.get("raceId").getAsInt()));
        else leaderboards.setRace(Race.fromId(42));

        if (jsonObject.has("ranking"))
            leaderboards.setRanking(jsonObject.get("ranking").getAsInt());
        else leaderboards.setRanking(-1);

        if (jsonObject.has("rating"))
            leaderboards.setRating(jsonObject.get("rating").getAsInt());
        else leaderboards.setRating(-1);

        if (jsonObject.has("realmId"))
            leaderboards.setRealmId(jsonObject.get("realmId").getAsInt());
        else leaderboards.setRealmId(-1);

        if (jsonObject.has("realmName"))
            leaderboards.setRealmName(jsonObject.get("realmName").getAsString());
        else leaderboards.setRealmName("");

        if (jsonObject.has("realmSlug"))
            leaderboards.setRealmSlug(jsonObject.get("realmSlug").getAsString());
        else leaderboards.setRealmSlug("");

        if (jsonObject.has("seasonLosses"))
            leaderboards.setSeasonLosses(jsonObject.get("seasonLosses").getAsInt());
        else leaderboards.setSeasonLosses(-1);

        if (jsonObject.has("seasonWins"))
            leaderboards.setSeasonWins(jsonObject.get("seasonWins").getAsInt());
        else leaderboards.setSeasonWins(-1);

        if (jsonObject.has("weeklyLosses"))
            leaderboards.setWeeklyLosses(jsonObject.get("weeklyLosses").getAsInt());
        else leaderboards.setWeeklyLosses(-1);

        if (jsonObject.has("weeklyWins"))
            leaderboards.setWeeklyWins(jsonObject.get("weeklyWins").getAsInt());
        else leaderboards.setWeeklyWins(-1);

        return leaderboards;
    }

    public static List<PvPLeaderboards> parseJsonArray(JsonElement jsonArray) {
        List<PvPLeaderboards> tempList = new ArrayList<>();

        if (!(jsonArray instanceof JsonArray))
            jsonArray = jsonArray.getAsJsonObject().getAsJsonArray("rows");

        for (JsonElement element : jsonArray.getAsJsonArray())
            tempList.add(newInstanceFromJson(element.getAsJsonObject()));

        return tempList;
    }

    public int getClassId() {
        return mClassId;
    }

    public void setClassId(int classId) {
        mClassId = classId;
    }

    public Faction getFaction() {
        return mFaction;
    }

    public void setFaction(Faction faction) {
        mFaction = faction;
    }

    public int getGender() {
        return mGender;
    }

    public void setGender(int gender) {
        mGender = gender;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Race getRace() {
        return mRace;
    }

    public void setRace(Race race) {
        mRace = race;
    }

    public int getRanking() {
        return mRanking;
    }

    public void setRanking(int ranking) {
        mRanking = ranking;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        mRating = rating;
    }

    public int getRealmId() {
        return mRealmId;
    }

    public void setRealmId(int realmId) {
        mRealmId = realmId;
    }

    public String getRealmName() {
        return mRealmName;
    }

    public void setRealmName(String realmName) {
        mRealmName = realmName;
    }

    public String getRealmSlug() {
        return mRealmSlug;
    }

    public void setRealmSlug(String realmSlug) {
        mRealmSlug = realmSlug;
    }

    public int getSeasonLosses() {
        return mSeasonLosses;
    }

    public void setSeasonLosses(int seasonLosses) {
        mSeasonLosses = seasonLosses;
    }

    public int getSeasonWins() {
        return mSeasonWins;
    }

    public void setSeasonWins(int seasonWins) {
        mSeasonWins = seasonWins;
    }

    public int getSpecId() {
        return mSpecId;
    }

    public void setSpecId(int specId) {
        mSpecId = specId;
    }

    public int getWeeklyLosses() {
        return mWeeklyLosses;
    }

    public void setWeeklyLosses(int weeklyLosses) {
        mWeeklyLosses = weeklyLosses;
    }

    public int getWeeklyWins() {
        return mWeeklyWins;
    }

    public void setWeeklyWins(int weeklyWins) {
        mWeeklyWins = weeklyWins;
    }
}
