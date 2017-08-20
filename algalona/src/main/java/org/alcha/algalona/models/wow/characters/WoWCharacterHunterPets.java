package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import static org.alcha.algalona.models.wow.characters.WoWCharacterField.Name.Hunter_Pets;

/**
 * <p>Created by Alcha on Aug 18, 2017 @ 22:02.</p>
 * Copyright (c) 2017 Paranoid Devs.
 */

public class WoWCharacterHunterPets extends WoWCharacterField {
    private static String mName;
    private static int mCreature;
    private static int mSlot;
    private static String mCalcSpec;
    private static int mFamilyId;
    private static String mFamilyName;

    private WoWCharacterHunterPets() {
        setFieldName(Hunter_Pets);
    }

    public WoWCharacterHunterPets newInstanceFromJson(JsonObject object) {
        WoWCharacterHunterPets hunterPets = new WoWCharacterHunterPets();

        if (object.has("name"))
            hunterPets.setName(object.get("name").getAsString());

        if (object.has("creature"))
            hunterPets.setCreature(object.get("creature").getAsInt());

        if (object.has("slot"))
            hunterPets.setSlot(object.get("slot").getAsInt());

        if (object.has("calcSpec"))
            hunterPets.setCalcSpec(object.get("calcSpec").getAsString());

        if (object.has("familyId"))
            hunterPets.setFamilyId(object.get("familyId").getAsInt());

        if (object.has("familyName"))
            hunterPets.setFamilyName(object.get("familyName").getAsString());

        return hunterPets;
    }

    // Setters
    private void setName(String name) {
        mName = name;
    }

    private void setCreature(int creature) {
        mCreature = creature;
    }

    private void setSlot(int slot) {
        mSlot = slot;
    }

    private void setCalcSpec(String calcSpec) {
        mCalcSpec = calcSpec;
    }

    private void setFamilyId(int familyId) {
        mFamilyId = familyId;
    }

    private void setFamilyName(String familyName) {
        mFamilyName = familyName;
    }

    // Getters
    public String getName() {
        return mName;
    }

    public int getCreature() {
        return mCreature;
    }

    public int getSlot() {
        return mSlot;
    }

    public String getCalcSpec() {
        return mCalcSpec;
    }

    public int getFamilyId() {
        return mFamilyId;
    }

    public String getFamilyName() {
        return mFamilyName;
    }
}
