package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Achievement;
import org.alcha.algalona.models.wow.Criteria;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class CharacterFeedBossKill extends CharacterFeedEntry {
    private Achievement mAchievement;
    private Criteria mCriteria;
    private int mQuantity;

    public CharacterFeedBossKill() {
        setEntryType(Type.BOSSKILL);
    }

    public static CharacterFeedBossKill newInstanceFromJson(JsonObject jsonObject) {
        CharacterFeedBossKill bossKill = new CharacterFeedBossKill();

        if (jsonObject.has("timestamp"))
            bossKill.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else bossKill.setTimestamp(-1);

        if (jsonObject.has("featOfStrength"))
            bossKill.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());
        else bossKill.setFeatOfStrength(false);

        if (jsonObject.has("achievement"))
            bossKill.setAchievement(Achievement.newInstanceFromJson(jsonObject.getAsJsonObject("achievement")));
        else bossKill.setAchievement(Achievement.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("criteria"))
            bossKill.setCriteria(Criteria.newInstanceFromJson(jsonObject.getAsJsonObject("criteria")));
        else bossKill.setCriteria(Criteria.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("quantity"))
            bossKill.setQuantity(jsonObject.get("quantity").getAsInt());
        else bossKill.setQuantity(-1);

        return bossKill;
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

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }
}
