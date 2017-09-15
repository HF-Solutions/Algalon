package org.alcha.algalona.models.wow.challenges;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:16.</p>
 */

public class ChallengeMap {
    private int mId;
    private String mName;
    private String mSlug;
    private boolean mHasChallengeMode;
    private ChallengeCriteria mBronzeCriteria;
    private ChallengeCriteria mSilverCriteria;
    private ChallengeCriteria mGoldCriteria;

    public ChallengeMap() {
    }

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


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public boolean isHasChallengeMode() {
        return mHasChallengeMode;
    }

    public void setHasChallengeMode(boolean hasChallengeMode) {
        mHasChallengeMode = hasChallengeMode;
    }

    public ChallengeCriteria getBronzeCriteria() {
        return mBronzeCriteria;
    }

    public void setBronzeCriteria(ChallengeCriteria bronzeCriteria) {
        mBronzeCriteria = bronzeCriteria;
    }

    public ChallengeCriteria getSilverCriteria() {
        return mSilverCriteria;
    }

    public void setSilverCriteria(ChallengeCriteria silverCriteria) {
        mSilverCriteria = silverCriteria;
    }

    public ChallengeCriteria getGoldCriteria() {
        return mGoldCriteria;
    }

    public void setGoldCriteria(ChallengeCriteria goldCriteria) {
        mGoldCriteria = goldCriteria;
    }
}
