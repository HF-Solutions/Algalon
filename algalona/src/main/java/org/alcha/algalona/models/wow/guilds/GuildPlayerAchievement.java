package org.alcha.algalona.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Achievement;
import org.alcha.algalona.util.JsonAid;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 07:32.</p>
 */

public class GuildPlayerAchievement extends GuildNewsEntry {
    private Achievement mAchievement;

    public GuildPlayerAchievement() {
        setType(Type.PLAYER_ACHIEVEMENT);
    }

    @Override
    public String toString() {
        return getAchievement().toString();
    }

    public static GuildPlayerAchievement newInstanceFromJson(JsonObject jsonObject) {
        GuildPlayerAchievement playerAchievement = new GuildPlayerAchievement();

        if (jsonObject.has("character"))
            playerAchievement.setCharacterName(jsonObject.get("character").getAsString());
        else playerAchievement.setCharacterName("");

        if (jsonObject.has("timestamp"))
            playerAchievement.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else playerAchievement.setTimestamp(-1L);

        if (jsonObject.has("context"))
            playerAchievement.setContext(jsonObject.get("context").getAsString());
        else playerAchievement.setContext("");

        if (jsonObject.has("bonusLists"))
            playerAchievement.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else playerAchievement.setBonusLists(new int[0]);

        if (jsonObject.has("achievement"))
            playerAchievement.setAchievement(Achievement.newInstanceFromJson(jsonObject.getAsJsonObject("achievement")));
        else playerAchievement.setAchievement(new Achievement());

        return playerAchievement;
    }

    public Achievement getAchievement() {
        return mAchievement;
    }

    public void setAchievement(Achievement achievement) {
        mAchievement = achievement;
    }
}
