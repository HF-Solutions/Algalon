package org.alcha.algalonj.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 19:31.</p>
 */

public class Recipe {
    private int mId;
    private String mName;
    private String mProfession;
    private String mIcon;

    public Recipe() {
    }

    public Recipe newInstanceFromJson(JsonObject jsonObject) {
        Recipe recipe = new Recipe();

        if (jsonObject.has("id"))
            recipe.setId(jsonObject.get("id").getAsInt());
        else recipe.setId(-1);

        if (jsonObject.has("name"))
            recipe.setName(jsonObject.get("name").getAsString());
        else recipe.setName("");

        if (jsonObject.has("profession"))
            recipe.setProfession(jsonObject.get("profession").getAsString());
        else recipe.setProfession("");

        if (jsonObject.has("icon"))
            recipe.setIcon(jsonObject.get("icon").getAsString());
        else recipe.setIcon("");

        return recipe;
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

    public String getProfession() {
        return mProfession;
    }

    public void setProfession(String profession) {
        mProfession = profession;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }
}
