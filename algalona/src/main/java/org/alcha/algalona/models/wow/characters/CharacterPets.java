package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.pets.Pet;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:47.</p>
 */

public class CharacterPets extends CharacterField {
    private int mNumCollected;
    private int mNumNotCollected;
    private List<Pet> mCollected;

    public CharacterPets() {
        setFieldName(Name.Pets);
    }

    public static CharacterPets newInstanceFromJson(JsonObject jsonObject) {
        CharacterPets pets = new CharacterPets();

        if (jsonObject.has("numCollected"))
            pets.setNumCollected(jsonObject.get("numCollected").getAsInt());
        else pets.setNumCollected(-1);

        if (jsonObject.has("numNotCollected"))
            pets.setNumNotCollected(jsonObject.get("numNotCollected").getAsInt());
        else pets.setNumNotCollected(-1);

        if (jsonObject.has("collected"))
            pets.setCollected(Pet.parseJsonArray(jsonObject.getAsJsonArray("collected")));
        else pets.setCollected(Pet.parseJsonArray(new JsonArray()));

        return pets;
    }

    public int getNumCollected() {
        return mNumCollected;
    }

    public void setNumCollected(int numCollected) {
        mNumCollected = numCollected;
    }

    public int getNumNotCollected() {
        return mNumNotCollected;
    }

    public void setNumNotCollected(int numNotCollected) {
        mNumNotCollected = numNotCollected;
    }

    public List<Pet> getCollected() {
        return mCollected;
    }

    public void setCollected(List<Pet> collected) {
        mCollected = collected;
    }
}
