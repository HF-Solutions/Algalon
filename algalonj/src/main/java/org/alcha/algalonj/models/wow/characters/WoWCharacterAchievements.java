package org.alcha.algalonj.models.wow.characters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWCharacterAchievements extends WoWCharacterField {
    private int[] mAchievementsCompleted,
            mAchievementsCriteria,
            mAchievementCriteriaQuantity;

    private long[] mAchievementsCompletedTimeStamp,
            mAchievementsCriteriaCreated;

    private WoWCharacterAchievements() {
        setFieldName(Name.Achievements);
    }

    public static WoWCharacterAchievements newInstanceFromJSON(JSONObject object) throws JSONException {
        WoWCharacterAchievements achievements = new WoWCharacterAchievements();

        achievements.setAchievementsCompleted(parseAchievementsCompleted(object.getJSONArray("achievementsCompleted")));
        achievements.setAchievementsCriteria(parseAchievementsCriteria(object.getJSONArray("achievementsCriteria")));
        achievements.setAchievementsCriteriaQuantity(parseAchievementCriteriaQuantity(object.getJSONArray("achievementCriteriaQuantity")));
        achievements.setAchievementsCompletedTimeStamp(parseAchievementsCompletedTimeStamp(object.getJSONArray("achievementsCompletedTimeStamp")));
        achievements.setAchievementsCriteriaCreated(parseAchievementsCriteriaCreated(object.getJSONArray("achievementsCriteriaCreated")));

        return achievements;
    }

    private static long[] parseAchievementsCriteriaCreated(JSONArray criteriaCreated) {
        return new long[0];
    }

    private static int[] parseAchievementCriteriaQuantity(JSONArray criteriaQuantity) {

        return new int[0];
    }

    private static int[] parseAchievementsCriteria(JSONArray criteria) {

        return new int[0];
    }

    public static int[] parseAchievementsCompleted(JSONArray array) throws JSONException {

        return new int[0];
    }

    public static long[] parseAchievementsCompletedTimeStamp(JSONArray array) throws JSONException {

        return new long[0];
    }

    public static WoWCharacterAchievements newInstanceFromJSON() {
        return new WoWCharacterAchievements();
    }

    public void setAchievementsCompleted(int[] achievementsCompleted) {
        mAchievementsCompleted = achievementsCompleted;
    }

    public int[] getAchievementsCompleted() {
        return mAchievementsCompleted;
    }

    public void setAchievementsCompletedTimeStamp(long[] achievementsCompletedTimeStamp) {
        mAchievementsCompletedTimeStamp = achievementsCompletedTimeStamp;
    }

    public long[] getAchievementsCompletedTimeStamp() {
        return mAchievementsCompletedTimeStamp;
    }

    public void setAchievementsCriteria(int[] achievementsCriteria) {
        mAchievementsCriteria = achievementsCriteria;
    }

    public int[] getAchievementsCriteria() {
        return mAchievementsCriteria;
    }

    public void setAchievementsCriteriaQuantity(int[] achievementsCriteriaQuatity) {
        mAchievementCriteriaQuantity = achievementsCriteriaQuatity;
    }

    public int[] getAchievementsCriteriaQuantity() {
        return mAchievementCriteriaQuantity;
    }

    public long[] getAchievementsCriteriaCreated() {
        return mAchievementsCriteriaCreated;
    }

    public void setAchievementsCriteriaCreated(long[] achievementsCriteriaCreated) {
        mAchievementsCriteriaCreated = achievementsCriteriaCreated;
    }
}
