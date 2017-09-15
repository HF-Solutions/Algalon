package org.alcha.algalona.models.wow.challenges;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:17.</p>
 */

public class ChallengeCritiera {
    public enum Type {
        BRONZE_CRITERIA("bronzeCriteria"),
        SILVER_CRITERIA("silverCriteria"),
        GOLD_CRITERIA("goldCriteria"),
        UNKNOWN("unknown");

        public String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Type fromString(String typeName) {
            for (Type type : Type.values()) {
                if (type.getName().equalsIgnoreCase(typeName)) return type;
            }

            return Type.UNKNOWN;
        }
    }

    private Type mType;
    private long mTime;
    private int mHours;
    private int mMinutes;
    private int mSeconds;
    private int mMiliseconds;
    private boolean mIsPositive;
}
