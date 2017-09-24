package org.alcha.algalonj.models.wow.challenges;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:32.</p>
 *
 * <p>As far as I'm aware, the Challenge API is no longer active, but the endpoint still exists to
 * retrieve old data so I've added classes to parse it. Each challenge has a list of groups
 * associated with it, this object stores them in one class with a getter method for the {@link
 * List}.</p>
 *
 * <p>Use the {@link #newInstanceFromJson(JsonArray)} method to build a proper {@link
 * ChallengeGroups} object or manually build your own list and set it using the {@link
 * #setGroups(List)} method.</p>
 */
public class ChallengeGroups {
    /** Stores the list of ChallengeGroups */
    private List<ChallengeGroup> mGroups;

    /**
     * <p>Default empty constructor for the {@link ChallengeGroups} object. Only use this if you
     * know what you're doing or don't mind tinkering around until you get it to work.</p>
     *
     * <p>It is recommended to use the {@link #newInstanceFromJson(JsonArray)} method which takes
     * a {@link JsonArray} and takes out the relevant information to populate a
     * list and store it in the ChallengeGroups object that is returned.</p>
     */
    public ChallengeGroups() {

    }

    /**
     * <p>Parses the given {@link JsonArray} for all the available {@link ChallengeGroup} objects
     * in the array. Each one is passed to {@link ChallengeGroup#newInstanceFromJson(JsonObject)}
     * and the returned value is stored in a list. The resulting list is stored in a ChallengeGroup
     * and returned.</p>
     *
     * @param jsonArray JsonArray containing the groups you wish to parse out
     *
     * @return ChallengeGroups containing the info from the array
     */
    public static ChallengeGroups newInstanceFromJson(JsonArray jsonArray) {
        ChallengeGroups challengeGroups = new ChallengeGroups();
        List<ChallengeGroup> groups = new ArrayList<>();

        for (JsonElement element : jsonArray)
            groups.add(ChallengeGroup.newInstanceFromJson(element.getAsJsonObject()));

        challengeGroups.setGroups(groups);

        return challengeGroups;
    }

    /**
     * Get the list of {@link ChallengeGroup} objects stored in the current {@link ChallengeGroups}.
     *
     * @return List of ChallengeGroup objects
     */
    public List<ChallengeGroup> getGroups() {
        return mGroups;
    }

    /**
     * Set the list of {@link ChallengeGroup} objects for the current {@link ChallengeGroups}.
     *
     * @param groups List of groups you wish to add to the ChallengeGroups
     */
    public void setGroups(List<ChallengeGroup> groups) {
        mGroups = groups;
    }
}
