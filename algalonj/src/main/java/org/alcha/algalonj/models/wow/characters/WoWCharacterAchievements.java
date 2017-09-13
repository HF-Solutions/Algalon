package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWCharacterAchievements extends WoWCharacterField {
    private int[] mAchievementsCompleted,
            mAchievementsCriteria,
            mAchievementCriteriaQuantity;

    private long[] mAchievementsCompletedTimestamp,
            mAchievementsCriteriaCreated;

    private WoWCharacterAchievements() {
        setFieldName(Name.Achievements);
    }

    public static WoWCharacterAchievements newInstanceFromJSON(JsonObject object) {
        WoWCharacterAchievements achievements = new WoWCharacterAchievements();

        achievements.setAchievementsCompleted(parseAchievementsCompleted(object.getAsJsonArray("achievementsCompleted")));
        achievements.setAchievementsCriteria(parseAchievementsCriteria(object.getAsJsonArray("achievementsCriteria")));
        achievements.setAchievementsCriteriaQuantity(parseAchievementCriteriaQuantity(object.getAsJsonArray("achievementCriteriaQuantity")));
        achievements.setAchievementsCompletedTimestamp(parseAchievementsCompletedTimestamp(object.getAsJsonArray("achievementsCompletedTimestamp")));
        achievements.setAchievementsCriteriaCreated(parseAchievementsCriteriaCreated(object.getAsJsonArray("achievementsCriteriaCreated")));

        return achievements;
    }

    private static long[] parseAchievementsCriteriaCreated(JsonArray criteriaCreated) {
        return new long[0];
    }

    private static int[] parseAchievementCriteriaQuantity(JsonArray criteriaQuantity) {

        return new int[0];
    }

    private static int[] parseAchievementsCriteria(JsonArray criteria) {

        return new int[0];
    }

    public static int[] parseAchievementsCompleted(JsonArray array)  {

        return new int[0];
    }

    public static long[] parseAchievementsCompletedTimestamp(JsonArray array)  {

        return new long[0];
    }

    public static WoWCharacterAchievements newInstanceFromJSON() {
        return new WoWCharacterAchievements();
    }

    void setAchievementsCompleted(int[] achievementsCompleted) {
        mAchievementsCompleted = achievementsCompleted;
    }

    public int[] getAchievementsCompleted() {
        return mAchievementsCompleted;
    }

    void setAchievementsCompletedTimestamp(long[] achievementsCompletedTimestamp) {
        mAchievementsCompletedTimestamp = achievementsCompletedTimestamp;
    }

    public long[] getAchievementsCompletedTimestamp() {
        return mAchievementsCompletedTimestamp;
    }

    void setAchievementsCriteria(int[] achievementsCriteria) {
        mAchievementsCriteria = achievementsCriteria;
    }

    public int[] getAchievementsCriteria() {
        return mAchievementsCriteria;
    }

    void setAchievementsCriteriaQuantity(int[] achievementsCriteriaQuatity) {
        mAchievementCriteriaQuantity = achievementsCriteriaQuatity;
    }

    public int[] getAchievementsCriteriaQuantity() {
        return mAchievementCriteriaQuantity;
    }

    public long[] getAchievementsCriteriaCreated() {
        return mAchievementsCriteriaCreated;
    }

    void setAchievementsCriteriaCreated(long[] achievementsCriteriaCreated) {
        mAchievementsCriteriaCreated = achievementsCriteriaCreated;
    }
}
