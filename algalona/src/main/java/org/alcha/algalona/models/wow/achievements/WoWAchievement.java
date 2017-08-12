package org.alcha.algalona.models.wow.achievements;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.WoWRewardItem;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 * Stores all information related to an Achievement in WoW.
 */
public class WoWAchievement implements Comparable<WoWAchievement> {
    private static final String LOG_TAG = "WoWAchievement";
    private int mId;
    private String mTitle;
    private int mPoints;
    private String mDescription;
    private String mReward;
    private WoWRewardItem[] mRewardItems;
    private String mIcon;
    private WoWAchievementCriteria[] mCriteria;
    private boolean mAccountWide;
    private int mFactionId;

    private WoWAchievement() {

    }

    @Override
    public int compareTo(@NonNull WoWAchievement achievement) {
        if (achievement.getId() > mId) return 1;
        else if (achievement.getId() < mId) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "id = " + mId + "; " +
                "title = " + mTitle + "; " +
                "points = " + mPoints + ";\n" +
                "description = " + mDescription + "; " +
                "reward = " + mReward + "; " +
                "icon = " + mIcon + ";\n" +
                "criteria.length = " + mCriteria.length + "; " +
                "accountWide = " + mAccountWide + "; " +
                "factionId = " + mFactionId + ";";
    }

    /**
     * Accepts a {@link JsonObject} that is the response from <code>/wow/achievement/:id</code> and
     * populates the available fields.
     *
     * @param json <code>/wow/achievement/:id</code> response
     */
    public static WoWAchievement newInstanceFromJson(JsonObject json) {
        WoWAchievement achievement = new WoWAchievement();

        achievement.setId(json.get("id").getAsInt());
        achievement.setTitle(json.get("title").getAsString());
        achievement.setPoints(json.get("points").getAsInt());
        achievement.setDescription(json.get("description").getAsString());
        achievement.setReward(json.get("reward").getAsString());
        achievement.setRewardItems(WoWRewardItem.parseRewardItems(json.getAsJsonArray("rewardItems")));
        achievement.setIcon(json.get("icon").getAsString());
        achievement.setCriteria(WoWAchievementCriteria.parseCriteriaToArray(json.getAsJsonArray("criteria")));
        achievement.setAccountWide(json.get("accountWide").getAsBoolean());
        achievement.setFactionId(json.get("factionId").getAsInt());

        return achievement;
    }

    public String getDescription() {
        return mDescription;
    }

    void setDescription(String description) {
        mDescription = description;
    }

    public int getId() {
        return mId;
    }

    void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    void setTitle(String title) {
        mTitle = title;
    }

    public int getPoints() {
        return mPoints;
    }

    void setPoints(int points) {
        mPoints = points;
    }

    public String getReward() {
        return mReward;
    }

    void setReward(String reward) {
        mReward = reward;
    }

    public WoWRewardItem[] getRewardItems() {
        return mRewardItems;
    }

    void setRewardItems(WoWRewardItem[] rewardItems) {
        mRewardItems = rewardItems;
    }

    public WoWAchievementCriteria[] getCriteria() {
        return mCriteria;
    }

    void setCriteria(WoWAchievementCriteria[] criteria) {
        mCriteria = criteria;
    }

    public boolean isAccountWide() {
        return mAccountWide;
    }

    void setAccountWide(boolean accountWide) {
        mAccountWide = accountWide;
    }

    public int getFactionId() {
        return mFactionId;
    }

    void setFactionId(int factionId) {
        mFactionId = factionId;
    }

    public String getIcon() {
        return mIcon;
    }

    void setIcon(String icon) {
        mIcon = icon;
    }
}
