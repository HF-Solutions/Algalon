package org.alcha.algalona.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Achievement;
import org.alcha.algalona.util.JsonAid;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 07:23.</p>
 */

public class GuildAchievement extends GuildNewsEntry {
    private Achievement mAchievement;

    public GuildAchievement() {
        setType(Type.GUILD_ACHIEVEMENT);
    }

    @Override
    public String toString() {
        return getAchievement().toString();
    }

    public static GuildAchievement newInstanceFromJson(JsonObject jsonObject) {
        GuildAchievement achievement = new GuildAchievement();

        if (jsonObject.has("character"))
            achievement.setCharacterName(jsonObject.get("character").getAsString());
        else achievement.setCharacterName("");

        if (jsonObject.has("timestamp"))
            achievement.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else achievement.setTimestamp(-1L);

        if (jsonObject.has("context"))
            achievement.setContext(jsonObject.get("context").getAsString());
        else achievement.setContext("");

        if (jsonObject.has("bonusLists"))
            achievement.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else achievement.setBonusLists(new int[0]);

        if (jsonObject.has("achievement"))
            achievement.setAchievement(Achievement.newInstanceFromJson(jsonObject.getAsJsonObject("achievement")));

        return achievement;
    }

    public Achievement getAchievement() {
        return mAchievement;
    }

    public void setAchievement(Achievement achievement) {
        mAchievement = achievement;
    }
}
