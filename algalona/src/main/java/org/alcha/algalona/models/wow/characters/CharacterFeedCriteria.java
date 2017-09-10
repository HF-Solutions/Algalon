package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Achievement;
import org.alcha.algalona.models.wow.Criteria;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class CharacterFeedCriteria extends CharacterFeedEntry {
    private Achievement mAchievement;
    private Criteria mCriteria;

    public CharacterFeedCriteria() {
        setEntryType(Type.CRITERIA);
    }

    public static CharacterFeedCriteria newInstanceFromJson(JsonObject jsonObject) {
        CharacterFeedCriteria feedCriteria = new CharacterFeedCriteria();

        if(jsonObject.has("timestamp"))
            feedCriteria.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else feedCriteria.setTimestamp(-1);

        if(jsonObject.has("featOfStrength"))
            feedCriteria.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());
        else feedCriteria.setFeatOfStrength(false);

        if(jsonObject.has("achievement"))
            feedCriteria.setAchievement(Achievement.newInstanceFromJson(jsonObject.getAsJsonObject("achievement")));
        else feedCriteria.setAchievement(Achievement.newInstanceFromJson(new JsonObject()));

        if(jsonObject.has("criteria"))
            feedCriteria.setCriteria(Criteria.newInstanceFromJson(jsonObject.getAsJsonObject("criteria")));
        else feedCriteria.setCriteria(Criteria.newInstanceFromJson(new JsonObject()));

        return feedCriteria;
    }

    public Achievement getAchievement() {
        return mAchievement;
    }

    public void setAchievement(Achievement achievement) {
        mAchievement = achievement;
    }

    public Criteria getCriteria() {
        return mCriteria;
    }

    public void setCriteria(Criteria criteria) {
        mCriteria = criteria;
    }
}
