package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 13:47.</p>
 */

public class CharacterQuests extends CharacterField {
    private List<Integer> mQuests;

    public CharacterQuests() {
        setFieldName(Name.Quests);
    }

    public static CharacterQuests newInstanceFromJson(JsonObject jsonObject) {
        CharacterQuests quests = new CharacterQuests();

        quests.setQuests(JsonAid.jsonArrayToIntList(jsonObject.getAsJsonArray()));

        return quests;
    }

    public List<Integer> getQuests() {
        return mQuests;
    }

    public void setQuests(List<Integer> quests) {
        mQuests = quests;
    }
}
