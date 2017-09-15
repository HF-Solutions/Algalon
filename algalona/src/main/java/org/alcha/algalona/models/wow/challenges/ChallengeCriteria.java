package org.alcha.algalona.models.wow.challenges;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Time;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:17.</p>
 */

public class ChallengeCriteria {
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
    private Time mTime;

    public ChallengeCriteria() {

    }

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

    public static ChallengeCriteria newInstanceFromJson(JsonObject jsonObject, Type type) {
        ChallengeCriteria criteria = newInstanceFromJson(jsonObject);
        criteria.setType(type);
        return criteria;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public Time getTime() {
        return mTime;
    }

    public void setTime(Time time) {
        mTime = time;
    }
}
