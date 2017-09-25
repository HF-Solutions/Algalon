package org.alcha.algalon.models.wow.challenges;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:16.</p>
 *
 * <p>As far as I'm aware, the Challenge API is no longer active, but the endpoint still exists to
 * retrieve old data so I've added classes to parse it.</p>
 *
 * <p>Each challenge takes place on a given map, this object stores the information for a given
 * map. {@link ChallengeMap} contains a static method {@link #newInstanceFromJson(JsonObject)}
 * which is capable of parsing a {@link JsonObject} with the information for a map and returning
 * the object with the fields populated.</p>
 */
public class ChallengeMap {
    /** Stores the id of the given ChallengeMap */
    private int mId;

    /** Stores the name of the given ChallengeMap */
    private String mName;

    /** Stores the slug of the given ChallengeMap */
    private String mSlug;

    /** Stores the hasChallengeMode boolean of the given ChallengeMap */
    private boolean mHasChallengeMode;

    /** Stores the bronze criteria of the given ChallengeMap */
    private ChallengeCriteria mBronzeCriteria;

    /** Stores the silver criteria of the given ChallengeMap */
    private ChallengeCriteria mSilverCriteria;

    /** Stores the gold criteria of the given ChallengeMap */
    private ChallengeCriteria mGoldCriteria;

    /**
     * <p>Default empty constructor, not recommended for use unless you know what you're doing or
     * don't mind tinkering around until you get it to work.</p>
     *
     * <p>It is recommended to use the {@link #newInstanceFromJson(JsonObject)} method to generate
     * an object. Otherwise, call the setter methods and populate the fields as you desire.</p>
     */
    public ChallengeMap() {
    }

    /**
     * <p>Parses the given {@link JsonObject} for information related to a {@link ChallengeMap} and
     * populates the fields before returning the object.</p>
     *
     * @param jsonObject JsonObject containing map information
     *
     * @return ChallengeMap with populated fields
     */
    public static ChallengeMap newInstanceFromJson(JsonObject jsonObject) {
        ChallengeMap map = new ChallengeMap();

        if (jsonObject.has("id")) map.setId(jsonObject.get("id").getAsInt());
        else map.setId(-1);

        if (jsonObject.has("name")) map.setName(jsonObject.get("name").getAsString());
        else map.setName("");

        if (jsonObject.has("slug")) map.setSlug(jsonObject.get("slug").getAsString());
        else map.setSlug("");

        if (jsonObject.has("hasChallengeMode"))
            map.setHasChallengeMode(jsonObject.get("hasChallengeMode").getAsBoolean());
        else map.setHasChallengeMode(false);

        if (jsonObject.has("bronzeCriteria"))
            map.setBronzeCriteria(ChallengeCriteria.newInstanceFromJson(jsonObject.getAsJsonObject("bronzeCriteria"), ChallengeCriteria.Type.BRONZE_CRITERIA));

        if (jsonObject.has("silverCriteria"))
            map.setSilverCriteria(ChallengeCriteria.newInstanceFromJson(jsonObject.getAsJsonObject("silverCriteria"), ChallengeCriteria.Type.SILVER_CRITERIA));

        if (jsonObject.has("goldCriteria"))
            map.setGoldCriteria(ChallengeCriteria.newInstanceFromJson(jsonObject.getAsJsonObject("goldCriteria"), ChallengeCriteria.Type.GOLD_CRITERIA));

        return map;
    }

    /**
     * <p>Get the Id of the given {@link ChallengeMap}.</p>
     *
     * @return int id of the map
     */
    public int getId() {
        return mId;
    }

    /**
     * <p>Sets the id of the given {@link ChallengeMap}.</p>
     *
     * @param id int id you wish to set
     */
    public void setId(int id) {
        mId = id;
    }

    /**
     * <p>Get the name of the given {@link ChallengeMap}.</p>
     *
     * @return String name of the map
     */
    public String getName() {
        return mName;
    }

    /**
     * <p>Sets the name of the given {@link ChallengeMap}.</p>
     *
     * @param name String name you wish to set
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * <p>Gets the slug  of the given {@link ChallengeMap} that is used when building URLs for the
     * Battle.net API.</p>
     *
     * @return String URL slug
     */
    public String getSlug() {
        return mSlug;
    }

    /**
     * <p>Sets the slug of the given {@link ChallengeMap} for use when building URLs for the
     * Battle.net API.</p>
     *
     * @param slug String URL slug
     */
    public void setSlug(String slug) {
        mSlug = slug;
    }

    /**
     * <p>Gets the hasChallengeMode boolean of the given {@link ChallengeMap}.</p>
     *
     * @return boolean hasChallengeMod
     */
    public boolean isHasChallengeMode() {
        return mHasChallengeMode;
    }

    /**
     * <p>Sets the hasChallengeMode boolean of the given {@link ChallengeMap}.</p>
     *
     * @param hasChallengeMode boolean does the map have a challenge mode?
     */
    public void setHasChallengeMode(boolean hasChallengeMode) {
        mHasChallengeMode = hasChallengeMode;
    }

    /**
     * <p>Gets the bronze criteria of the given {@link ChallengeMap}.</p>
     *
     * @return Bronze Criteria
     */
    public ChallengeCriteria getBronzeCriteria() {
        return mBronzeCriteria;
    }

    /**
     * <p>Sets the bronze criteria of the given {@link ChallengeMap}.</p>
     *
     * @param bronzeCriteria Bronze Criteria to be set
     */
    public void setBronzeCriteria(ChallengeCriteria bronzeCriteria) {
        mBronzeCriteria = bronzeCriteria;
    }

    /**
     * <p>Gets the silver criteria of the given {@link ChallengeMap}.</p>
     *
     * @return Silver Criteria
     */
    public ChallengeCriteria getSilverCriteria() {
        return mSilverCriteria;
    }

    /**
     * <p>Sets the silver criteria of the given {@link ChallengeMap}.</p>
     *
     * @param silverCriteria Bronze Criteria to be set
     */
    public void setSilverCriteria(ChallengeCriteria silverCriteria) {
        mSilverCriteria = silverCriteria;
    }

    /**
     * <p>Gets the gold criteria of the given {@link ChallengeMap}.</p>
     *
     * @return Gold Criteria
     */
    public ChallengeCriteria getGoldCriteria() {
        return mGoldCriteria;
    }

    /**
     * <p>Sets the gold criteria of the given {@link ChallengeMap}.</p>
     *
     * @param goldCriteria Bronze Criteria to be set
     */
    public void setGoldCriteria(ChallengeCriteria goldCriteria) {
        mGoldCriteria = goldCriteria;
    }
}
