package org.alcha.algalona.models.wow.achievements;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 * Stores the criteria for a {@link WoWAchievement} that must be completed in order to gain said
 * achievement. Implements {@link Comparable} to allow sorting by the order index, and overrides the
 * toString method to output the stored data.
 */
public class WoWAchievementCriteria implements Comparable<WoWAchievementCriteria> {
    private static final String LOG_TAG = "WoWAchievementCriteria";
    private String mDescription;
    private int mId,
            mOrderIndex,
            mMax;

    private WoWAchievementCriteria() {
    }

    /**
     * Parses the given {@link JsonArray} for all {@link WoWAchievementCriteria} that are present in
     * the array. If/when one is located, it is passed to {@link #newInstanceFromJson(JsonObject)}
     * in order to get the Criteria as its POJO, and then it is added to a temp array, which is
     * returned when the method completes.
     *
     * @param criteria a JsonArray containing the criteria you wish to parse
     *
     * @return an array of WoWAchievementCriteria
     */
    public static WoWAchievementCriteria[] parseCriteriaToArray(JsonArray criteria) {
        WoWAchievementCriteria[] tempArray = new WoWAchievementCriteria[criteria.size()];

        for (int x = 0; x < criteria.size(); x++) {
            JsonObject jsonObject = criteria.get(x).getAsJsonObject();
            WoWAchievementCriteria achievementCriteria = WoWAchievementCriteria.newInstanceFromJson(jsonObject);

            tempArray[x] = achievementCriteria;
        }

        return tempArray;
    }

    /**
     * <p>Parses the given {@link JsonObject} for the fields of a {@link WoWAchievementCriteria} and if
     * they're present, are added to a temp Criteria object. If a field isn't located, a default
     * value is stored in its place. When the method completes, the temp Criteria object is returned
     * with its fields populated.</p>
     *
     * @param jsonObject a JsonObject containing the information for a given criteria
     *
     * @return a WoWAchievementCriteria object populated with the info of the given object
     */
    public static WoWAchievementCriteria newInstanceFromJson(JsonObject jsonObject) {
        WoWAchievementCriteria criteria = new WoWAchievementCriteria();
        criteria.setId(jsonObject.get("id").getAsInt());
        criteria.setDescription(jsonObject.get("description").getAsString());
        criteria.setOrderIndex(jsonObject.get("orderIndex").getAsInt());
        criteria.setMax(jsonObject.get("max").getAsInt());
        return criteria;
    }

    /**
     * <p>Returns a String representation of the stored data separated by semi-colons.</p>
     * <p>For example:<br/>
     * <code>id = 7553; description = To Honor One's Elders; orderIndex = 0; max = 1;</code></p>
     *
     * @return String containing stored data
     */
    @Override
    public String toString() {
        return "id = " + mId +
                "; description = " + mDescription +
                "; orderIndex = " + mOrderIndex +
                "; max = " + mMax + ";";
    }

    /**
     * Enables sorting by OrderIndex. Compares the OrderIndex of the provided object to the stored
     * OrderIndex and returns 1, -1, or 0 depending on the results. If the provided index is larger
     * than the one stored, 1 is returned, if it is less, -1 is returned, any other case and 0 is
     * returned.
     *
     * @param criteria {@link WoWAchievementCriteria}
     *
     * @return 1, -1, or 0.
     */
    @Override
    public int compareTo(@NonNull WoWAchievementCriteria criteria) {
        if (criteria.getOrderIndex() > mOrderIndex) return 1;
        else if (criteria.getOrderIndex() < mOrderIndex) return -1;
        else return 0;
    }

    void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    void setId(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    void setOrderIndex(int orderIndex) {
        mOrderIndex = orderIndex;
    }

    public int getOrderIndex() {
        return mOrderIndex;
    }

    void setMax(int max) {
        mMax = max;
    }

    public int getMax() {
        return mMax;
    }
}
