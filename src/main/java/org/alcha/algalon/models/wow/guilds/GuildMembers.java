package org.alcha.algalon.models.wow.guilds;

import com.google.gson.JsonArray;

import org.alcha.algalon.models.wow.characters.Character;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Created by Alcha on Sep 13, 2017 @ 17:25.</p>
 */

public class GuildMembers extends GuildField {
    private Map<String, Character> mMembers;

    public GuildMembers() {
        setFieldName(Name.MEMBERS);
    }

    public static GuildMembers newInstanceFromJson(JsonArray jsonArray) {
        GuildMembers members = new GuildMembers();

        JsonArray tempArray = jsonArray.getAsJsonArray();
        Map<String, Character> tempMap = new TreeMap<>();

        for (int x = 0; x < tempArray.size(); x++) {
            Character character = Character.newInstanceFromJson(tempArray.get(x).getAsJsonObject().getAsJsonObject("character"));
            tempMap.put(character.getName(), character);
        }

        members.setMembers(tempMap);

        return members;
    }

    public Map<String, Character> getMembers() {
        return mMembers;
    }

    public void setMembers(Map<String, Character> members) {
        mMembers = members;
    }
}
