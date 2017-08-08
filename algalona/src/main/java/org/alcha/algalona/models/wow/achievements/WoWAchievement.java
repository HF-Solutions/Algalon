package org.alcha.algalona.models.wow.achievements;


import org.alcha.algalona.models.wow.WoWRewardItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

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
    private Map<Integer, WoWAchievementCriteria> mCriteria;
    private boolean mAccountWide;
    private int mFactionId;

    @Override
    public int compareTo(WoWAchievement o) {
        if (o.mId > mId) return 1;
        else if (o.mId < mId) return -1;
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
                "criteria = " + mCriteria.values() + "; " +
                "accountWide = " + mAccountWide + "; " +
                "factionId = " + mFactionId + ";";
    }

    /**
     * Accepts a {@link JSONObject} that is the response from <code>/wow/achievement/:id</code> and
     * populates the available fields.
     *
     * @param json <code>/wow/achievement/:id</code> response
     */
    public WoWAchievement(JSONObject json) {
        try {
            JSONArray criteria = json.getJSONArray("criteria");

            mId = json.getInt("id");
            mTitle = json.getString("title");
            mPoints = json.getInt("points");
            mDescription = json.getString("description");
            mReward = json.getString("reward");
            mIcon = json.getString("icon");
            mCriteria = parseAchievementCriteria(criteria);
            mAccountWide = json.getBoolean("accountWide");
            mFactionId = json.getInt("factionId");
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    private static Map<Integer, WoWAchievementCriteria> parseAchievementCriteria(JSONArray criteria) throws JSONException {
        Map<Integer, WoWAchievementCriteria> tempMap = new TreeMap<>();

        for (int x = 0; x < criteria.length(); x++) {
            WoWAchievementCriteria achievementCriteria = new WoWAchievementCriteria();
            achievementCriteria.setId(criteria.getJSONObject(x).getInt("id"));
            achievementCriteria.setDescription(criteria.getJSONObject(x).getString("description"));
            achievementCriteria.setOrderIndex(criteria.getJSONObject(x).getInt("orderIndex"));
            achievementCriteria.setMax(criteria.getJSONObject(x).getInt("max"));

            tempMap.put(achievementCriteria.getId(), achievementCriteria);
        }

        return tempMap;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getPoints() {
        return mPoints;
    }

    public void setPoints(int points) {
        mPoints = points;
    }

    public String getReward() {
        return mReward;
    }

    public void setReward(String reward) {
        mReward = reward;
    }

    public WoWRewardItem[] getRewardItems() {
        return mRewardItems;
    }

    public void setRewardItems(WoWRewardItem[] rewardItems) {
        mRewardItems = rewardItems;
    }

    public Map<Integer, WoWAchievementCriteria> getCriteria() {
        return mCriteria;
    }

    public void setCriteria(Map<Integer, WoWAchievementCriteria> criteria) {
        mCriteria = criteria;
    }

    public boolean isAccountWide() {
        return mAccountWide;
    }

    public void setAccountWide(boolean accountWide) {
        mAccountWide = accountWide;
    }

    public int getFactionId() {
        return mFactionId;
    }

    public void setFactionId(int factionId) {
        mFactionId = factionId;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }
}
