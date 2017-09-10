package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class WoWCharacterAchievements extends WoWCharacterField {
    private List<Integer> mAchievementsCompleted;
    private List<Long> mAchievementsCompletedTimestamp;

    private List<Integer> mAchievementsCriteria;
    private List<Integer> mAchievementCriteriaQuantity;
    private List<Long> mAchievementsCriteriaTimestamp;
    private List<Long> mAchievementsCriteriaCreated;

    private WoWCharacterAchievements() {
        setFieldName(Name.Achievements);
    }

    @Override
    public String toString() {
        String tempStr = "Achievements Completed = ";

        for (int achievementId : mAchievementsCompleted) {
            tempStr += "; " + achievementId;
        }

        return tempStr;
    }

    public static WoWCharacterAchievements newInstanceFromJson(JsonObject object) {
        WoWCharacterAchievements achievements = new WoWCharacterAchievements();

        if (object.has("achievementsCompleted"))
            achievements.setAchievementsCompleted(parseAchievementsCompleted(object.getAsJsonArray("achievementsCompleted")));
        else achievements.setAchievementsCompleted(new ArrayList<Integer>());

        if (object.has("achievementsCompletedTimestamp"))
            achievements.setAchievementsCompletedTimestamp(parseAchievementsCompletedTimestamp(object.getAsJsonArray("achievementsCompletedTimestamp")));
        else achievements.setAchievementsCompletedTimestamp(new ArrayList<Long>());

        if (object.has("criteria"))
            achievements.setAchievementsCriteria(parseAchievementsCriteria(object.getAsJsonArray("criteria")));
        else achievements.setAchievementsCriteria(new ArrayList<Integer>());

        if (object.has("criteriaQuantity"))
            achievements.setAchievementsCriteriaQuantity(parseAchievementCriteriaQuantity(object.getAsJsonArray("criteriaQuantity")));
        else achievements.setAchievementsCriteriaQuantity(new ArrayList<Integer>());

        if (object.has("criteriaTimestamp"))
            achievements.setAchievementsCriteriaTimestamp(parseAchievementsCompletedTimestamp(object.getAsJsonArray("criteriaTimestamp")));
        else achievements.setAchievementsCriteriaTimestamp(new ArrayList<Long>());

        if (object.has("criteriaCreated"))
            achievements.setAchievementsCriteriaCreated(parseAchievementsCriteriaCreated(object.getAsJsonArray("criteriaCreated")));
        else achievements.setAchievementsCriteriaCreated(new ArrayList<Long>());

        return achievements;
    }

    private static List<Long> parseAchievementsCriteriaCreated(JsonArray criteriaCreated) {
        List<Long> tempList = new ArrayList<>();

        for (int x = 0; x < criteriaCreated.size(); x++) {
            tempList.add(criteriaCreated.get(x).getAsLong());
        }

        return tempList;
    }

    private static List<Integer> parseAchievementCriteriaQuantity(JsonArray criteriaQuantity) {
        List<Integer> tempList = new ArrayList<>();

        for (int x = 0; x < criteriaQuantity.size(); x++) {
            tempList.add(criteriaQuantity.get(x).getAsInt());
        }

        return tempList;
    }

    private static List<Integer> parseAchievementsCriteria(JsonArray criteria) {
        List<Integer> tempList = new ArrayList<>();

        for (int x = 0; x < criteria.size(); x++) {
            tempList.add(criteria.get(x).getAsInt());
        }

        return tempList;
    }

    public static List<Integer> parseAchievementsCompleted(JsonArray completed) {
        List<Integer> tempList = new ArrayList<>();

        for (int x = 0; x < completed.size(); x++) {
            tempList.add(completed.get(x).getAsInt());
        }

        return tempList;
    }

    public static List<Long> parseAchievementsCompletedTimestamp(JsonArray completedTimestamp) {
        List<Long> tempList = new ArrayList<>();

        for (int x = 0; x < completedTimestamp.size(); x++) {
            tempList.add(completedTimestamp.get(x).getAsLong());
        }

        return tempList;
    }

    public static WoWCharacterAchievements newInstanceFromJson() {
        return new WoWCharacterAchievements();
    }

    public void setAchievementsCompleted(List<Integer> achievementsCompleted) {
        mAchievementsCompleted = achievementsCompleted;
    }

    public List<Integer> getAchievementsCompleted() {
        return mAchievementsCompleted;
    }

    public void setAchievementsCompletedTimestamp(List<Long> achievementsCompletedTimestamp) {
        mAchievementsCompletedTimestamp = achievementsCompletedTimestamp;
    }

    public List<Long> getAchievementsCompletedTimestamp() {
        return mAchievementsCompletedTimestamp;
    }

    public void setAchievementsCriteria(List<Integer> achievementsCriteria) {
        mAchievementsCriteria = achievementsCriteria;
    }

    public List<Integer> getAchievementsCriteria() {
        return mAchievementsCriteria;
    }

    public void setAchievementsCriteriaQuantity(List<Integer> achievementsCriteriaQuantity) {
        mAchievementCriteriaQuantity = achievementsCriteriaQuantity;
    }

    public List<Integer> getAchievementsCriteriaQuantity() {
        return mAchievementCriteriaQuantity;
    }

    public List<Long> getAchievementsCriteriaCreated() {
        return mAchievementsCriteriaCreated;
    }

    public void setAchievementsCriteriaCreated(List<Long> achievementsCriteriaCreated) {
        mAchievementsCriteriaCreated = achievementsCriteriaCreated;
    }

    public List<Long> getAchievementsCriteriaTimestamp() {
        return mAchievementsCriteriaTimestamp;
    }

    public void setAchievementsCriteriaTimestamp(List<Long> achievementsCriteriaTimestamp) {
        mAchievementsCriteriaTimestamp = achievementsCriteriaTimestamp;
    }
}
