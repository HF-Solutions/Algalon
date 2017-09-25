package org.alcha.algalon.models.wow.pets;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 16:18.</p>
 */

public class PetAbility {
    private int mId;
    private String mName;
    private int mSlot;
    private int mOrder;
    private int mRequiredLevel;
    private int mRounds;
    private String mIcon;
    private int mCooldown;
    private int mPetTypeId;
    private boolean mIsPassive;
    private boolean mHideHints;

    public static PetAbility newInstanceFromJson(JsonObject jsonObject) {
        PetAbility ability = new PetAbility();

        if (jsonObject.has("id"))
            ability.setId(jsonObject.get("id").getAsInt());
        else ability.setId(-1);

        if (jsonObject.has("name"))
            ability.setName(jsonObject.get("name").getAsString());
        else ability.setName("");

        if (jsonObject.has("icon"))
            ability.setIcon(jsonObject.get("icon").getAsString());
        else ability.setIcon("");

        if (jsonObject.has("cooldown"))
            ability.setCooldown(jsonObject.get("cooldown").getAsInt());
        else ability.setCooldown(-1);

        if (jsonObject.has("petTypeId"))
            ability.setPetTypeId(jsonObject.get("petTypeId").getAsInt());
        else ability.setPetTypeId(-1);

        if (jsonObject.has("isPassive"))
            ability.setPassive(jsonObject.get("isPassive").getAsBoolean());
        else ability.setPassive(false);

        if (jsonObject.has("hideHints"))
            ability.setHideHints(jsonObject.get("hideHints").getAsBoolean());
        else ability.setHideHints(false);

        if (jsonObject.has("slot"))
            ability.setSlot(jsonObject.get("slot").getAsInt());
        else ability.setSlot(-1);

        if (jsonObject.has("order"))
            ability.setOrder(jsonObject.get("order").getAsInt());
        else ability.setOrder(-1);

        if (jsonObject.has("requiredLevel"))
            ability.setRequiredLevel(jsonObject.get("requiredLevel").getAsInt());
        else ability.setRequiredLevel(-1);

        if (jsonObject.has("rounds"))
            ability.setRounds(jsonObject.get("rounds").getAsInt());
        else ability.setRounds(-1);

        return ability;
    }

    public static List<PetAbility> parseJsonArray(JsonArray jsonArray) {
        List<PetAbility> tempList = new ArrayList<>();

        for (JsonElement element : jsonArray)
            tempList.add(newInstanceFromJson(element.getAsJsonObject()));

        return tempList;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getCooldown() {
        return mCooldown;
    }

    public void setCooldown(int cooldown) {
        mCooldown = cooldown;
    }

    public int getPetTypeId() {
        return mPetTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        mPetTypeId = petTypeId;
    }

    public boolean isPassive() {
        return mIsPassive;
    }

    public void setPassive(boolean passive) {
        mIsPassive = passive;
    }

    public boolean isHideHints() {
        return mHideHints;
    }

    public void setHideHints(boolean hideHints) {
        mHideHints = hideHints;
    }

    public int getSlot() {
        return mSlot;
    }

    public void setSlot(int slot) {
        mSlot = slot;
    }

    public int getOrder() {
        return mOrder;
    }

    public void setOrder(int order) {
        mOrder = order;
    }

    public int getRequiredLevel() {
        return mRequiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        mRequiredLevel = requiredLevel;
    }

    public int getRounds() {
        return mRounds;
    }

    public void setRounds(int rounds) {
        mRounds = rounds;
    }
}
