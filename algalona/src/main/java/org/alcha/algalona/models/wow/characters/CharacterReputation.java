package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 14:09.</p>
 */

public class CharacterReputation extends CharacterField {
    private List<GroupStanding> mGroupStandings;

    public CharacterReputation() {
        setFieldName(Name.Reputation);
    }

    public static CharacterReputation newInstanceFromJson(JsonObject jsonObject) {
        CharacterReputation reputation = new CharacterReputation();
        JsonArray array = jsonObject.getAsJsonArray();

        for (int x = 0; x < array.size(); x++) {
            JsonObject groupStanding = array.get(x).getAsJsonObject();
            reputation.addGroupStanding(GroupStanding.newInstanceFromJson(groupStanding));
        }

        return reputation;
    }

    public void setGroupStandings(List<GroupStanding> groupStandings) {
        mGroupStandings = groupStandings;
    }

    public List<GroupStanding> getGroupStandings() {
        return mGroupStandings;
    }

    public void addGroupStanding(GroupStanding standing) {
        mGroupStandings.add(standing);
    }

    public static class GroupStanding {
        public int id;
        public String name;
        public int standing;
        public int value;
        public int max;

        public GroupStanding() {
        }

        public static GroupStanding newInstanceFromJson(JsonObject jsonObject) {
            GroupStanding standing = new GroupStanding();

            if (jsonObject.has("id"))
                standing.id = jsonObject.get("id").getAsInt();
            else standing.id = -1;

            if (jsonObject.has("name"))
                standing.name = jsonObject.get("name").getAsString();
            else standing.name = "";

            if (jsonObject.has("value"))
                standing.value = jsonObject.get("value").getAsInt();
            else standing.value = -1;

            if (jsonObject.has("max"))
                standing.max = jsonObject.get("max").getAsInt();
            else standing.max = -1;

            return standing;
        }
    }
}
