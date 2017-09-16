package org.alcha.algalona.models.wow.challenges;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:32.</p>
 */

public class ChallengeGroups {
    private List<ChallengeGroup> mGroups;

    public ChallengeGroups() {

    }

    public static ChallengeGroups newInstanceFromJson(JsonArray jsonArray) {
        ChallengeGroups challengeGroups = new ChallengeGroups();
        List<ChallengeGroup> groups = new ArrayList<>();

        for (JsonElement element : jsonArray)
            groups.add(ChallengeGroup.newInstanceFromJson(element.getAsJsonObject()));

        challengeGroups.setGroups(groups);

        return challengeGroups;
    }

    public List<ChallengeGroup> getGroups() {
        return mGroups;
    }

    public void setGroups(List<ChallengeGroup> groups) {
        mGroups = groups;
    }
}
