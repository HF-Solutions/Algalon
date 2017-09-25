package org.alcha.algalon.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 09, 2017 @ 13:55.</p>
 */

public class Spec {
    private String mName;
    private String mRole;
    private String mBackgroundImage;
    private String mIcon;
    private String mDescription;
    private int mOrder;

    private Spec() {
    }

    public static Spec newInstanceFromJson(JsonObject jsonObject) {
        Spec spec = new Spec();

        if (jsonObject.has("name"))
            spec.setName(jsonObject.get("name").getAsString());
        else spec.setName("");

        if (jsonObject.has("role"))
            spec.setRole(jsonObject.get("role").getAsString());
        else spec.setRole("");

        if (jsonObject.has("backgroundImage"))
            spec.setBackgroundImage(jsonObject.get("backgroundImage").getAsString());
        else spec.setBackgroundImage("");

        if (jsonObject.has("icon"))
            spec.setIcon(jsonObject.get("icon").getAsString());
        else spec.setIcon("");

        if (jsonObject.has("description"))
            spec.setDescription(jsonObject.get("description").getAsString());
        else spec.setDescription("");

        if (jsonObject.has("order"))
            spec.setOrder(jsonObject.get("order").getAsInt());
        else spec.setOrder(-1);

        return spec;
    }

    public static List<Spec> parseJsonArray(JsonArray jsonArray) {
        List<Spec> specs = new ArrayList<>();

        for (JsonElement element : jsonArray)
            specs.add(newInstanceFromJson(element.getAsJsonObject()));

        return specs;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public String getBackgroundImage() {
        return mBackgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        mBackgroundImage = backgroundImage;
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

    public int getOrder() {
        return mOrder;
    }

    public void setOrder(int order) {
        mOrder = order;
    }
}
