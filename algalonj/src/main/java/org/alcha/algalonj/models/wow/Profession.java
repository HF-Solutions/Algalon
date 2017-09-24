package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 12:23.</p>
 */

public class Profession {
    private int mId;
    private String mName;
    private String mIcon;
    private int mRank;
    private int mMax;
    private List<Integer> mRecipes;

    public Profession() {

    }

    public static Profession newInstanceFromJson(JsonObject jsonObject) {
        Profession profession = new Profession();

        if (jsonObject.has("id"))
            profession.setId(jsonObject.get("id").getAsInt());
        else profession.setId(-1);

        if (jsonObject.has("name"))
            profession.setName(jsonObject.get("name").getAsString());
        else profession.setName("");

        if (jsonObject.has("icon"))
            profession.setIcon(jsonObject.get("icon").getAsString());
        else profession.setIcon("");

        if (jsonObject.has("rank"))
            profession.setRank(jsonObject.get("rank").getAsInt());
        else profession.setRank(-1);

        if (jsonObject.has("max"))
            profession.setMax(jsonObject.get("max").getAsInt());
        else profession.setMax(-1);

        if (jsonObject.has("recipes"))
            profession.setRecipes(JsonAid.jsonArrayToListInt(jsonObject.getAsJsonArray("recipes")));
        else profession.setRecipes(new ArrayList<Integer>());

        return profession;
    }

    public static Profession[] parseJsonArray(JsonArray jsonArray) {
        Profession[] professions = new Profession[jsonArray.size()];

        for (int x = 0; x < jsonArray.size(); x++) {
            professions[x] = newInstanceFromJson(jsonArray.get(x).getAsJsonObject());
        }

        return professions;
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

    public int getRank() {
        return mRank;
    }

    public void setRank(int rank) {
        mRank = rank;
    }

    public int getMax() {
        return mMax;
    }

    public void setMax(int max) {
        mMax = max;
    }

    public List<Integer> getRecipes() {
        return mRecipes;
    }

    public void setRecipes(List<Integer> recipes) {
        mRecipes = recipes;
    }
}
