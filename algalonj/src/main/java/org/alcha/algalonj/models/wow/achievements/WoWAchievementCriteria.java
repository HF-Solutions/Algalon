package org.alcha.algalonj.models.wow.achievements;

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

    /**
     * Returns a String representation of the stored data separated by semi-colons.<br/><br/>
     * For example:<br/>
     * <code>id = 7553; description = To Honor One's Elders; orderIndex = 0; max = 1;</code>
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
     * @param criteria  {@link WoWAchievementCriteria}
     * @return          1, -1, or 0.
     */
    @Override
    public int compareTo(WoWAchievementCriteria criteria) {
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
