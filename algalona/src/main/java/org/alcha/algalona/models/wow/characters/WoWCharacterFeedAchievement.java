package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.WoWFaction;
import org.alcha.algalona.models.wow.WoWRewardItem;
import org.alcha.algalona.models.wow.achievements.WoWAchievementCriteria;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeedAchievement extends WoWCharacterFeedEntry {
    private int mId, mPoints;
    private String mTitle, mDescription, mIcon;
    private WoWRewardItem[] mRewardItems;
    private WoWAchievementCriteria[] mCriteria;
    private boolean mAccountWide;
    private WoWFaction mFaction;

    private WoWCharacterFeedAchievement() {
        setEntryType(Type.ACHIEVEMENT);
    }

    public WoWCharacterFeedAchievement newInstance() {
        return new WoWCharacterFeedAchievement();
    }

    public static WoWCharacterFeedAchievement newInstanceFromJson(JsonObject jsonObject) {
        WoWCharacterFeedAchievement achievement = new WoWCharacterFeedAchievement();

        if (jsonObject.has("id"))
            achievement.setId(jsonObject.get("id").getAsInt());
        if (jsonObject.has("title"))
            achievement.setTitle(jsonObject.get("title").getAsString());
        if (jsonObject.has("points"))
            achievement.setPoints(jsonObject.get("points").getAsInt());
        if (jsonObject.has("description"))
            achievement.setDescription(jsonObject.get("description").getAsString());
        if (jsonObject.has("rewardItems"))
            achievement.setRewardItems(WoWRewardItem.parseRewardItems(jsonObject.getAsJsonArray("rewardItems")));
        if (jsonObject.has("icon"))
            achievement.setIcon(jsonObject.get("icon").getAsString());
        if (jsonObject.has("criteria"))
            achievement.setCriteria(WoWAchievementCriteria.parseCriteriaToArray(jsonObject.getAsJsonArray("criteria")));
        if (jsonObject.has("accountWide"))
            achievement.setAccountWide(jsonObject.get("accountWide").getAsBoolean());
        if (jsonObject.has("factionId"))
            achievement.setFaction(WoWFaction.fromId(jsonObject.get("factionId").getAsInt()));

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

    public WoWRewardItem[] getRewardItems() {
        return mRewardItems;
    }

    public void setRewardItems(WoWRewardItem[] rewardItems) {
        mRewardItems = rewardItems;
    }

    public WoWAchievementCriteria[] getCriteria() {
        return mCriteria;
    }

    public void setCriteria(WoWAchievementCriteria[] criteria) {
        mCriteria = criteria;
    }

    public WoWFaction getFaction() {
        return mFaction;
    }

    public void setFaction(WoWFaction faction) {
        mFaction = faction;
    }

    public boolean isAccountWide() {
        return mAccountWide;
    }

    public void setAccountWide(boolean accountWide) {
        mAccountWide = accountWide;
    }
}
