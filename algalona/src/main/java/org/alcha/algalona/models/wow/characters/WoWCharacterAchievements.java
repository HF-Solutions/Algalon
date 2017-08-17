package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

    public static WoWCharacterAchievements newInstanceFromJson(JsonObject object) {
        WoWCharacterAchievements achievements = new WoWCharacterAchievements();

        if (object.has("achievementsCompleted"))
            achievements.setAchievementsCompleted(parseAchievementsCompleted(object.getAsJsonArray("achievementsCompleted")));

        if (object.has("achievementsCriteria"))
            achievements.setAchievementsCriteria(parseAchievementsCriteria(object.getAsJsonArray("achievementsCriteria")));

        if (object.has("achievementCriteriaQuantity"))
            achievements.setAchievementsCriteriaQuantity(parseAchievementCriteriaQuantity(object.getAsJsonArray("achievementCriteriaQuantity")));

        if (object.has("achievementsCompletedTimeStamp"))
            achievements.setAchievementsCompletedTimeStamp(parseAchievementsCompletedTimeStamp(object.getAsJsonArray("achievementsCompletedTimeStamp")));

        if (object.has("achievementsCriteriaCreated"))
            achievements.setAchievementsCriteriaCreated(parseAchievementsCriteriaCreated(object.getAsJsonArray("achievementsCriteriaCreated")));

        return achievements;
    }

    @Override
    public String toString() {
        String tempStr = "Achievements Completed = ";

        for (int achievementId : mAchievementsCompleted) {
            tempStr += "; " + achievementId;
        }

        return tempStr;
    }

    private static long[] parseAchievementsCriteriaCreated(JsonArray criteriaCreated) {
        long[] tempArray = new long[criteriaCreated.size()];

        for (int x = 0; x < criteriaCreated.size(); x++) {
            tempArray[x] = criteriaCreated.get(x).getAsInt();
        }

        return tempArray;
    }

    private static int[] parseAchievementCriteriaQuantity(JsonArray criteriaQuantity) {
        int[] tempArray = new int[criteriaQuantity.size()];

        for (int x = 0; x < criteriaQuantity.size(); x++) {
            tempArray[x] = criteriaQuantity.get(x).getAsInt();
        }

        return tempArray;
    }

    private static int[] parseAchievementsCriteria(JsonArray criteria) {
        int[] tempArray = new int[criteria.size()];

        for (int x = 0; x < criteria.size(); x++) {
            tempArray[x] = criteria.get(x).getAsInt();
        }

        return tempArray;
    }

    public static int[] parseAchievementsCompleted(JsonArray array) {
        int[] tempArray = new int[array.size()];

        for (int x = 0; x < array.size(); x++) {
            tempArray[x] = array.get(x).getAsInt();
        }

        return tempArray;
    }

    public static long[] parseAchievementsCompletedTimeStamp(JsonArray array) {
        long[] tempArray = new long[array.size()];

        for (int x = 0; x < array.size(); x++) {
            tempArray[x] = array.get(x).getAsInt();
        }

        return tempArray;
    }

    public static WoWCharacterAchievements newInstanceFromJson() {
        return new WoWCharacterAchievements();
    }

    void setAchievementsCompleted(int[] achievementsCompleted) {
        mAchievementsCompleted = achievementsCompleted;
    }

    public int[] getAchievementsCompleted() {
        return mAchievementsCompleted;
    }

    void setAchievementsCompletedTimeStamp(long[] achievementsCompletedTimeStamp) {
        mAchievementsCompletedTimeStamp = achievementsCompletedTimeStamp;
    }

    public long[] getAchievementsCompletedTimeStamp() {
        return mAchievementsCompletedTimeStamp;
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
