package org.alcha.algalon.models.wow.characters;

import com.google.gson.JsonObject;

import static org.alcha.algalon.models.wow.characters.CharacterField.Name.Hunter_Pets;

/**
 * <p>Created by Alcha on Aug 18, 2017 @ 22:02.</p>
 * Copyright (c) 2017 Paranoid Devs.
 */

public class CharacterHunterPets extends CharacterField {
    private String mName;
    private int mCreature;
    private int mSlot;
    private String mCalcSpec;
    private int mFamilyId;
    private String mFamilyName;

    public CharacterHunterPets() {
        setFieldName(Hunter_Pets);
    }

    public static CharacterHunterPets newInstanceFromJson(JsonObject object) {
        CharacterHunterPets hunterPets = new CharacterHunterPets();

        if (object.has("name"))
            hunterPets.setName(object.get("name").getAsString());
        else hunterPets.setName("");

        if (object.has("creature"))
            hunterPets.setCreature(object.get("creature").getAsInt());
        else hunterPets.setCreature(-1);

        if (object.has("slot"))
            hunterPets.setSlot(object.get("slot").getAsInt());
        else hunterPets.setSlot(-1);

        if (object.has("calcSpec"))
            hunterPets.setCalcSpec(object.get("calcSpec").getAsString());
        else hunterPets.setCalcSpec("");

        if (object.has("familyId"))
            hunterPets.setFamilyId(object.get("familyId").getAsInt());
        else hunterPets.setFamilyId(-1);

        if (object.has("familyName"))
            hunterPets.setFamilyName(object.get("familyName").getAsString());
        else hunterPets.setFamilyName("");

        return hunterPets;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCreature() {
        return mCreature;
    }

    public void setCreature(int creature) {
        mCreature = creature;
    }

    public int getSlot() {
        return mSlot;
    }

    public void setSlot(int slot) {
        mSlot = slot;
    }

    public String getCalcSpec() {
        return mCalcSpec;
    }

    public void setCalcSpec(String calcSpec) {
        mCalcSpec = calcSpec;
    }

    public int getFamilyId() {
        return mFamilyId;
    }

    public void setFamilyId(int familyId) {
        mFamilyId = familyId;
    }

    public String getFamilyName() {
        return mFamilyName;
    }

    public void setFamilyName(String familyName) {
        mFamilyName = familyName;
    }
}
