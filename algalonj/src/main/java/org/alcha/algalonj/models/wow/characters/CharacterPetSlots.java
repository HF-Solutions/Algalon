package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.pets.PetSlot;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 12:07.</p>
 */

public class CharacterPetSlots extends CharacterField {
    private List<PetSlot> mPetSlots;

    public CharacterPetSlots() {
        setFieldName(Name.Pet_Slots);
    }

    public static CharacterPetSlots newInstanceFromJson(JsonObject jsonObject) {
        CharacterPetSlots petSlots = new CharacterPetSlots();
        petSlots.setPetSlots(PetSlot.parseJsonArray(jsonObject.getAsJsonArray()));

        return petSlots;
    }

    public List<PetSlot> getPetSlots() {
        return mPetSlots;
    }

    public void setPetSlots(List<PetSlot> petSlots) {
        mPetSlots = petSlots;
    }
}
