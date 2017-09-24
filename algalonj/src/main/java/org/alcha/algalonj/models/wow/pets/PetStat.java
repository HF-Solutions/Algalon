package org.alcha.algalonj.models.wow.pets;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 10:51.</p>
 */

public class PetStat {
    private int mSpeciesId;
    private int mBreedId;
    private int mPetQualityId;
    private int mLevel;
    private int mHealth;
    private int mPower;
    private int mSpeed;

    public PetStat() {

    }

    @Override
    public String toString() {
        return "SpeciesId=" + mSpeciesId + ";" +
                "BreedId=" + mBreedId + ";" +
                "PetQualityId=" + mPetQualityId + ";" +
                "Level=" + mLevel + ";" +
                "Health=" + mHealth + ";" +
                "Power=" + mPower + ";" +
                "Speed=" + mSpeed + ";";
    }

    public static PetStat newInstanceFromJson(JsonObject jsonObject) {
        PetStat stat = new PetStat();

        if (jsonObject.has("speciesId"))
            stat.setSpeciesId(jsonObject.get("speciesId").getAsInt());
        else stat.setSpeciesId(-1);

        if (jsonObject.has("breedId"))
            stat.setBreedId(jsonObject.get("breedId").getAsInt());
        else stat.setBreedId(-1);

        if (jsonObject.has("petQualityId"))
            stat.setPetQualityId(jsonObject.get("petQualityId").getAsInt());
        else stat.setPetQualityId(-1);

        if (jsonObject.has("level"))
            stat.setLevel(jsonObject.get("level").getAsInt());
        else stat.setLevel(-1);

        if (jsonObject.has("health"))
            stat.setHealth(jsonObject.get("health").getAsInt());
        else stat.setHealth(-1);

        if (jsonObject.has("power"))
            stat.setPower(jsonObject.get("power").getAsInt());
        else stat.setPower(-1);

        if (jsonObject.has("speed"))
            stat.setSpeed(jsonObject.get("speed").getAsInt());
        else stat.setSpeciesId(-1);

        return stat;
    }

    public static List<PetStat> parseJsonArray(JsonArray jsonArray) {
        List<PetStat> tempList = new ArrayList<>();

        for (JsonElement element : jsonArray)
            tempList.add(newInstanceFromJson(element.getAsJsonObject()));

        return tempList;
    }

    public int getSpeciesId() {
        return mSpeciesId;
    }

    public void setSpeciesId(int speciesId) {
        mSpeciesId = speciesId;
    }

    public int getBreedId() {
        return mBreedId;
    }

    public void setBreedId(int breedId) {
        mBreedId = breedId;
    }

    public int getPetQualityId() {
        return mPetQualityId;
    }

    public void setPetQualityId(int petQualityId) {
        mPetQualityId = petQualityId;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getHealth() {
        return mHealth;
    }

    public void setHealth(int health) {
        mHealth = health;
    }

    public int getPower() {
        return mPower;
    }

    public void setPower(int power) {
        mPower = power;
    }

    public int getSpeed() {
        return mSpeed;
    }

    public void setSpeed(int speed) {
        mSpeed = speed;
    }
}
