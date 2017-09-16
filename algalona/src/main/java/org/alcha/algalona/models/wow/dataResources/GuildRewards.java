package org.alcha.algalona.models.wow.dataResources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Achievement;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 21:34.</p>
 */

public class GuildRewards {
    private int mMinGuildLevel;
    private int mMinGuildRepLevel;
    private Achievement mAchievement;

    public GuildRewards() {

    }

    public static GuildRewards newInstanceFromJson(JsonObject jsonObject) {
        GuildRewards rewards = new GuildRewards();

        if (jsonObject.has("minGuildLevel"))
            rewards.setMinGuildLevel(jsonObject.get("minGuildLevel").getAsInt());
        else rewards.setMinGuildLevel(-1);

        if (jsonObject.has("minGuildRepLevel"))
            rewards.setMinGuildRepLevel(jsonObject.get("minGuildRepLevel").getAsInt());
        else rewards.setMinGuildRepLevel(-1);

        if (jsonObject.has("achievement"))
            rewards.setAchievement(Achievement.newInstanceFromJson(jsonObject.getAsJsonObject("achievement")));
        else rewards.setAchievement(new Achievement());

        return rewards;
    }

    public static List<GuildRewards> parseJsonArray(JsonArray jsonArray) {
        List<GuildRewards> guildRewardses = new ArrayList<>();

        for (JsonElement element : jsonArray)
            guildRewardses.add(newInstanceFromJson(element.getAsJsonObject()));

        return guildRewardses;
    }

    public int getMinGuildLevel() {
        return mMinGuildLevel;
    }

    public void setMinGuildLevel(int minGuildLevel) {
        mMinGuildLevel = minGuildLevel;
    }

    public int getMinGuildRepLevel() {
        return mMinGuildRepLevel;
    }

    public void setMinGuildRepLevel(int minGuildRepLevel) {
        mMinGuildRepLevel = minGuildRepLevel;
    }

    public Achievement getAchievement() {
        return mAchievement;
    }

    public void setAchievement(Achievement achievement) {
        mAchievement = achievement;
    }
}
