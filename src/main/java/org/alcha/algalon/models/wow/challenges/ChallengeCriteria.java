package org.alcha.algalon.models.wow.challenges;

import com.google.gson.JsonObject;

import org.alcha.algalon.models.wow.Time;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:17.</p>
 *
 * <p>As far as I'm aware, the Challenge API is no longer active, but the endpoint still exists to
 * retrieve old data so I've added classes to parse it. Each challenge has a bronze, silver, and
 * gold criteria with their own set of criteria required to be met.</p>
 *
 * <p>Contains two static methods for creating a {@link ChallengeCriteria} object. First is the
 * {@link #newInstanceFromJson(JsonObject)} method which only accepts a {@link JsonObject}, which
 * means it won't set the criteria {@link Type}. The other is {@link
 * #newInstanceFromJson(JsonObject, Type)} which accepts the Type as the 2nd parameter and sets the
 * returned type to the provided value.</p>
 */
public class ChallengeCriteria {
    /**
     * <p>The type of ChallengeCriteria, which isn't always known. When it is, it is either a bronze,
     * silver, or gold criteria. Using this enum, you can create a {@link Type} with {@link
     * #fromString(String)} or {@code new Type()} and then set the type manually.</p>
     */
    public enum Type {
        BRONZE_CRITERIA("bronzeCriteria"),
        SILVER_CRITERIA("silverCriteria"),
        GOLD_CRITERIA("goldCriteria"),
        UNKNOWN("unknown");

        /** Display name of the {@link Type} */
        public String name;

        /** Default {@link Type} constructor, sets display name to provided String */
        Type(String name) {
            this.name = name;
        }

        /** Get the display name of the {@link Type} instance */
        public String getName() {
            return name;
        }

        /**
         * <p>Iterates through all {@link Type} values and finds the one equal to the provided String.
         * If one can't be located, {@link Type#UNKNOWN} is returned.</p>
         */
        public static Type fromString(String typeName) {
            for (Type type : Type.values()) {
                if (type.getName().equalsIgnoreCase(typeName)) return type;
            }

            return Type.UNKNOWN;
        }
    }

    /** Stores Criteria Type */
    private Type mType;

    /** Stores Time object for Criteria */
    private Time mTime;

    /**
     * <p>Default empty constructor for the {@link ChallengeCriteria}. Only use this if you know what
     * you are doing or don't mind tinkering around until you get it right. </p>
     *
     * <p>It is recommended to use one of the static factory methods such as {@link
     * #newInstanceFromJson(JsonObject, Type)} or {@link #newInstanceFromJson(JsonObject)}. If you
     * wish to build it manually, use the various setter methods to build the object to your
     * content.</p>
     */
    public ChallengeCriteria() {

    }

    /**
     * Parses the provided {@link JsonObject} for the time necessary to be met for the {@link
     * ChallengeCriteria}.
     *
     * @param jsonObject JsonObject containing the time info
     *
     * @return ChallengeCriteria with time set
     */
    public static ChallengeCriteria newInstanceFromJson(JsonObject jsonObject) {
        ChallengeCriteria criteria = new ChallengeCriteria();

        if (jsonObject.has("time"))
            if (jsonObject.get("time") instanceof JsonObject)
                criteria.setTime(Time.newInstanceFromJson(jsonObject.getAsJsonObject("time")));
            else {
                Time time = new Time();
                time.setTime(jsonObject.get("time").getAsLong());
                criteria.setTime(time);
            }
        else criteria.setTime(new Time());

        return criteria;
    }

    /**
     * <p>Parses the provided {@link JsonObject} for the time necessary to be met for the {@link
     * ChallengeCriteria} using the {@link #newInstanceFromJson(JsonObject)} method. The provided
     * {@link Type} is then set to the retrieved object and then returned at the end of this method.
     * </p>
     *
     * @param jsonObject JsonObject containing the time info
     * @param type       Type object defining the criteria type
     *
     * @return ChallengeCriteria with values set with those provided
     */
    public static ChallengeCriteria newInstanceFromJson(JsonObject jsonObject, Type type) {
        ChallengeCriteria criteria = newInstanceFromJson(jsonObject);
        criteria.setType(type);
        return criteria;
    }

    /**
     * Get the {@link Type} object of the current {@link ChallengeCriteria}.
     *
     * @return Type
     */
    public Type getType() {
        return mType;
    }

    /**
     * Set the {@link Type} of the current {@link ChallengeCriteria} to the provided type.
     *
     * @param type Type you wish to set the value to
     */
    public void setType(Type type) {
        mType = type;
    }

    /**
     * Gets the {@link Time} object of the current {@link ChallengeCriteria}.
     *
     * @return Time
     */
    public Time getTime() {
        return mTime;
    }

    /**
     * Sets the {@link Time} of the current {@link ChallengeCriteria} to the provided time.
     *
     * @param time Time you wish to set the value to
     */
    public void setTime(Time time) {
        mTime = time;
    }
}
