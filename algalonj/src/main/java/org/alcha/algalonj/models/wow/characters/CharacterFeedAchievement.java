package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Criteria;
import org.alcha.algalona.models.wow.Faction;
import org.alcha.algalona.models.wow.RewardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class CharacterFeedAchievement extends CharacterFeedEntry {
    private int mId, mPoints;
    private String mTitle, mDescription, mIcon;
    private List<RewardItem> mRewardItems;
    private List<Criteria> mCriteria;
    private boolean mAccountWide;
    private Faction mFaction;

    public CharacterFeedAchievement() {
        setEntryType(Type.ACHIEVEMENT);
    }

    public static CharacterFeedAchievement newInstanceFromJson(JsonObject jsonObject) {
        CharacterFeedAchievement achievement = new CharacterFeedAchievement();

        if (jsonObject.has("timestamp"))
            achievement.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else achievement.setTimestamp(-1);

        if (jsonObject.has("featOfStrength"))
            achievement.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());
        else achievement.setFeatOfStrength(false);

        if (jsonObject.has("id"))
            achievement.setId(jsonObject.get("id").getAsInt());
        else achievement.setId(-1);

        if (jsonObject.has("title"))
            achievement.setTitle(jsonObject.get("title").getAsString());
        else achievement.setTitle("");

        if (jsonObject.has("points"))
            achievement.setPoints(jsonObject.get("points").getAsInt());
        else achievement.setPoints(-1);

        if (jsonObject.has("description"))
            achievement.setDescription(jsonObject.get("description").getAsString());
        else achievement.setDescription("");

        if (jsonObject.has("rewardItems"))
            achievement.setRewardItems(RewardItem.parseRewardItems(jsonObject.getAsJsonArray("rewardItems")));
        else achievement.setRewardItems(new ArrayList<RewardItem>());

        if (jsonObject.has("icon"))
            achievement.setIcon(jsonObject.get("icon").getAsString());
        else achievement.setIcon("");

        if (jsonObject.has("criteria"))
            achievement.setCriteria(Criteria.parseJsonArray(jsonObject.getAsJsonArray("criteria")));
        else achievement.setCriteria(new ArrayList<Criteria>());

        if (jsonObject.has("accountWide"))
            achievement.setAccountWide(jsonObject.get("accountWide").getAsBoolean());
        else achievement.setAccountWide(false);

        if (jsonObject.has("factionId"))
            achievement.setFaction(Faction.fromId(jsonObject.get("factionId").getAsInt()));
        else achievement.setFaction(Faction.UNKNOWN);

        return achievement;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getPoints() {
        return mPoints;
    }

    public void setPoints(int points) {
        mPoints = points;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public List<RewardItem> getRewardItems() {
        return mRewardItems;
    }

    public void setRewardItems(List<RewardItem> rewardItems) {
        mRewardItems = rewardItems;
    }

    public List<Criteria> getCriteria() {
        return mCriteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        mCriteria = criteria;
    }

    public Faction getFaction() {
        return mFaction;
    }

    public void setFaction(Faction faction) {
        mFaction = faction;
    }

    public boolean isAccountWide() {
        return mAccountWide;
    }

    public void setAccountWide(boolean accountWide) {
        mAccountWide = accountWide;
    }
}
