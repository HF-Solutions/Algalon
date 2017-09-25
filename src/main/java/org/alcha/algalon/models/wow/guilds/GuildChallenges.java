package org.alcha.algalon.models.wow.guilds;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 08:38.</p>
 */

public class GuildChallenges extends GuildField {
    private List<GuildChallenge> mChallenges;

    public GuildChallenges() {
        setFieldName(Name.CHALLENGE);
    }

    public static GuildChallenges newInstanceFromJson(JsonArray jsonArray) {
        GuildChallenges challenges = new GuildChallenges();
        List<GuildChallenge> challengeList = new ArrayList<>();

        for (JsonElement element : jsonArray)
            challengeList.add(GuildChallenge.newInstanceFromJson(element.getAsJsonObject()));

        challenges.setChallenges(challengeList);

        return challenges;
    }

    public List<GuildChallenge> getChallenges() {
        return mChallenges;
    }

    public void setChallenges(List<GuildChallenge> challenges) {
        mChallenges = challenges;
    }
}
