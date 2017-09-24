package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 */

public class Spell {
    private int mId;
    private String mName;
    private String mSubtext;
    private String mIcon;
    private String mDescription;
    private String mRange;
    private String mPowerCost;
    private String mCastTime;
    private String mCooldown;

    public Spell() {
    }

    @Override
    public String toString() {
        return "Id=" + mId + "; " +
                "Name=" + mName + "; " +
                "Description=" + mDescription + ";";
    }

    public static Spell newInstanceFromJson(JsonObject jsonObject) {
        Spell spell = new Spell();

        if (jsonObject.has("id"))
            spell.setId(jsonObject.get("id").getAsInt());
        else spell.setId(-1);

        if (jsonObject.has("name"))
            spell.setName(jsonObject.get("name").getAsString());
        else spell.setName("");

        if (jsonObject.has("subtext"))
            spell.setSubtext(jsonObject.get("subtext").getAsString());
        else spell.setSubtext("");

        if (jsonObject.has("icon"))
            spell.setIcon(jsonObject.get("icon").getAsString());
        else spell.setIcon("");

        if (jsonObject.has("description"))
            spell.setDescription(jsonObject.get("description").getAsString());
        else spell.setDescription("");

        if (jsonObject.has("range"))
            spell.setRange(jsonObject.get("range").getAsString());
        else spell.setRange("");

        if (jsonObject.has("powerCost"))
            spell.setPowerCost(jsonObject.get("powerCost").getAsString());
        else spell.setPowerCost("");

        if (jsonObject.has("castTime"))
            spell.setCastTime(jsonObject.get("castTime").getAsString());
        else spell.setCastTime("");

        if (jsonObject.has("cooldown"))
            spell.setCooldown(jsonObject.get("cooldown").getAsString());
        else spell.setCooldown("");

        return spell;
    }

    public static List<Spell> parseJsonArray(JsonArray jsonArray) {
        List<Spell> tempList = new ArrayList<>();

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

    public String getSubtext() {
        return mSubtext;
    }

    public void setSubtext(String subtext) {
        mSubtext = subtext;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getRange() {
        return mRange;
    }

    public void setRange(String range) {
        mRange = range;
    }

    public String getPowerCost() {
        return mPowerCost;
    }

    public void setPowerCost(String powerCost) {
        mPowerCost = powerCost;
    }

    public String getCastTime() {
        return mCastTime;
    }

    public void setCastTime(String castTime) {
        mCastTime = castTime;
    }

    public String getCooldown() {
        return mCooldown;
    }

    public void setCooldown(String cooldown) {
        mCooldown = cooldown;
    }
}
