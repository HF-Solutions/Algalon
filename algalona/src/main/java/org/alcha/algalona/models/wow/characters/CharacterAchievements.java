package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class CharacterAchievements extends CharacterField {
    private List<Integer> mAchievementsCompleted;
    private List<Long> mAchievementsCompletedTimestamp;

    private List<Integer> mAchievementsCriteria;
    private List<Integer> mAchievementCriteriaQuantity;
    private List<Long> mAchievementsCriteriaTimestamp;
    private List<Long> mAchievementsCriteriaCreated;

    public CharacterAchievements() {
        setFieldName(Name.Achievements);
    }

    @Override
    public String toString() {
        return "ACHIEVEMENTS Completed = " + mAchievementsCompleted.size();
    }

    public static CharacterAchievements newInstanceFromJson(JsonObject object) {
        CharacterAchievements achievements = new CharacterAchievements();

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

    public static List<Long> parseAchievementsCriteriaCreated(JsonArray criteriaCreated) {
        return JsonAid.jsonArrayToListLong(criteriaCreated);
    }

    public static List<Integer> parseAchievementCriteriaQuantity(JsonArray criteriaQuantity) {
        return JsonAid.jsonArrayToListInt(criteriaQuantity);
    }

    public static List<Integer> parseAchievementsCriteria(JsonArray criteria) {
        return JsonAid.jsonArrayToListInt(criteria);
    }

    public static List<Integer> parseAchievementsCompleted(JsonArray completed) {
        return JsonAid.jsonArrayToListInt(completed);
    }

    public static List<Long> parseAchievementsCompletedTimestamp(JsonArray completedTimestamp) {
        return JsonAid.jsonArrayToListLong(completedTimestamp);
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
