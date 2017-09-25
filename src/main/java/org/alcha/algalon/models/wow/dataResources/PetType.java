package org.alcha.algalon.models.wow.dataResources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 16, 2017 @ 00:23.</p>
 */

public class PetType {
    private int mId;
    private String mKey;
    private String mName;
    private int mTypeAbilityId;
    private int mStrongAgainstId;
    private int mWeakAgainstId;

    public PetType() {

    }

    @Override
    public String toString() {
        return "Id=" + mId + "; " +
                "Key=" + mKey + "; " +
                "Name=" + mName + "; " +
                "TypeAbilityId=" + mTypeAbilityId + "; " +
                "StrongAgainstId=" + mStrongAgainstId + "; " +
                "WeakAgainstId=" + mWeakAgainstId;
    }

    public static PetType newInstanceFromJson(JsonObject jsonObject) {
        PetType type = new PetType();

        if (jsonObject.has("id"))
            type.setId(jsonObject.get("id").getAsInt());
        else type.setId(-1);

        if (jsonObject.has("key"))
            type.setKey(jsonObject.get("key").getAsString());
        else type.setKey("");

        if (jsonObject.has("name"))
            type.setName(jsonObject.get("name").getAsString());
        else type.setName("");

        if (jsonObject.has("typeAbilityId"))
            type.setTypeAbilityId(jsonObject.get("typeAbilityId").getAsInt());
        else type.setTypeAbilityId(-1);

        if (jsonObject.has("strongAgainstId"))
            type.setStrongAgainstId(jsonObject.get("strongAgainstId").getAsInt());
        else type.setStrongAgainstId(-1);

        if (jsonObject.has("weakAgainstId"))
            type.setWeakAgainstId(jsonObject.get("weakAgainstId").getAsInt());
        else type.setWeakAgainstId(-1);

        return type;
    }

    public static List<PetType> parseJsonArray(JsonArray jsonArray) {
        List<PetType> petTypes = new ArrayList<>();

        for (JsonElement element : jsonArray)
            petTypes.add(PetType.newInstanceFromJson(element.getAsJsonObject()));

        return petTypes;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getTypeAbilityId() {
        return mTypeAbilityId;
    }

    public void setTypeAbilityId(int typeAbilityId) {
        mTypeAbilityId = typeAbilityId;
    }

    public int getStrongAgainstId() {
        return mStrongAgainstId;
    }

    public void setStrongAgainstId(int strongAgainstId) {
        mStrongAgainstId = strongAgainstId;
    }

    public int getWeakAgainstId() {
        return mWeakAgainstId;
    }

    public void setWeakAgainstId(int weakAgainstId) {
        mWeakAgainstId = weakAgainstId;
    }
}
