package org.alcha.algalona.models.wow;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 * Stores the criteria for a {@link Achievement} that must be completed in order to gain said
 * achievement. Implements {@link Comparable} to allow sorting by the order index, and overrides the
 * toString method to output the stored data.
 */
public class Criteria implements Comparable<Criteria> {
    private static final String LOG_TAG = "Criteria";
    private String mDescription;
    private int mId;
    private int mOrderIndex;
    private int mMax;

    private Criteria() {
    }

    /**
     * <p>Returns a String representation of the stored data separated by semi-colons.</p>
     *
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
     * @param criteria {@link Criteria}
     *
     * @return 1, -1, or 0.
     */
    @Override
    public int compareTo(@NonNull Criteria criteria) {
        if (criteria.getOrderIndex() > mOrderIndex) return 1;
        else if (criteria.getOrderIndex() < mOrderIndex) return -1;
        else return 0;
    }

    /**
     * Parses the given {@link JsonArray} for all {@link Criteria} that are present in
     * the array. If/when one is located, it is passed to {@link #newInstanceFromJson(JsonObject)}
     * in order to get the Criteria as its POJO, and then it is added to a temp array, which is
     * returned when the method completes.
     *
     * @param criteria a JsonArray containing the criteria you wish to parse
     *
     * @return an array of Criteria
     */
    public static List<Criteria> parseJsonArray(JsonArray criteria) {
        List<Criteria> tempList = new ArrayList<>();

        for (int x = 0; x < criteria.size(); x++) {
            JsonObject jsonObject = criteria.get(x).getAsJsonObject();
            tempList.add(Criteria.newInstanceFromJson(jsonObject));
        }

        return tempList;
    }

    /**
     * <p>Parses the given {@link JsonObject} for the fields of a {@link Criteria} and if
     * they're present, are added to a temp Criteria object. If a field isn't located, a default
     * value is stored in its place. When the method completes, the temp Criteria object is returned
     * with its fields populated.</p>
     *
     * @param json a JsonObject containing the information for a given criteria
     *
     * @return a Criteria object populated with the info of the given object
     */
    public static Criteria newInstanceFromJson(JsonObject json) {
        Criteria criteria = new Criteria();

        if (json.has("id"))
            criteria.setId(json.get("id").getAsInt());
        else criteria.setId(-1);

        if (json.has("description"))
            criteria.setDescription(json.get("description").getAsString());
        else criteria.setDescription("");

        if (json.has("orderIndex"))
            criteria.setOrderIndex(json.get("orderIndex").getAsInt());
        else criteria.setOrderIndex(-1);

        if (json.has("max"))
            criteria.setMax(json.get("max").getAsInt());
        else criteria.setMax(-1);

        return criteria;
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

    public int getOrderIndex() {
        return mOrderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        mOrderIndex = orderIndex;
    }

    public int getMax() {
        return mMax;
    }

    public void setMax(int max) {
        mMax = max;
    }
}
