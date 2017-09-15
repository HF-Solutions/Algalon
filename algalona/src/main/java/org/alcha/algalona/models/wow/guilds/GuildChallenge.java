package org.alcha.algalona.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Realm;
import org.alcha.algalona.models.wow.challenges.ChallengeGroups;
import org.alcha.algalona.models.wow.challenges.ChallengeMap;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 08:37.</p>
 */

public class GuildChallenge {
    private Realm mRealm;
    private ChallengeMap mMap;
    private ChallengeGroups mGroups;

    public GuildChallenge() {
    }

    public static GuildChallenge newInstanceFromJson(JsonObject jsonObject) {
        GuildChallenge challenge = new GuildChallenge();

        if (jsonObject.has("realm"))
            challenge.setRealm(Realm.newInstanceFromJson(jsonObject.getAsJsonObject("realm")));
        else challenge.setRealm(Realm.fromString(""));

        if (jsonObject.has("map"))
            challenge.setMap(ChallengeMap.newInstanceFromJson(jsonObject.getAsJsonObject("map")));
        else challenge.setMap(new ChallengeMap());

        if (jsonObject.has("groups"))
            challenge.setGroups(ChallengeGroups.newInstanceFromJson(jsonObject.getAsJsonArray("groups")));
        else challenge.setGroups(new ChallengeGroups());

        return challenge;
    }

    public Realm getRealm() {
        return mRealm;
    }

    public void setRealm(Realm realm) {
        mRealm = realm;
    }

    public ChallengeMap getMap() {
        return mMap;
    }

    public void setMap(ChallengeMap map) {
        mMap = map;
    }

    public ChallengeGroups getGroups() {
        return mGroups;
    }

    public void setGroups(ChallengeGroups groups) {
        mGroups = groups;
    }
}
