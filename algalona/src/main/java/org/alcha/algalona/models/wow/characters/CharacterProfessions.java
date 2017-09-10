package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Profession;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 12:29.</p>
 */

public class CharacterProfessions extends CharacterField {
    private Profession[] mPrimary;
    private Profession[] mSecondary;

    public CharacterProfessions() {
        setFieldName(Name.Professions);
    }

    public static CharacterProfessions newInstanceFromJson(JsonObject jsonObject) {
        CharacterProfessions professions = new CharacterProfessions();

        if (jsonObject.has("primary"))
            professions.setPrimary(Profession.parseJsonArray(jsonObject.getAsJsonArray("primary")));
        else professions.setPrimary(new Profession[0]);

        if (jsonObject.has("secondary"))
            professions.setSecondary(Profession.parseJsonArray(jsonObject.getAsJsonArray("secondary")));
        else professions.setSecondary(new Profession[0]);

        return professions;
    }

    public Profession[] getPrimary() {
        return mPrimary;
    }

    public void setPrimary(Profession[] primary) {
        mPrimary = primary;
    }

    public Profession[] getSecondary() {
        return mSecondary;
    }

    public void setSecondary(Profession[] secondary) {
        mSecondary = secondary;
    }
}
