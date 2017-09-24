package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Mount;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:30.</p>
 */

public class CharacterMounts extends CharacterField {
    private int mNumCollected;
    private int mNumNotCollected;
    private List<Mount> mCollected;

    public CharacterMounts() {
        setFieldName(Name.Mounts);
    }

    public static CharacterMounts newInstanceFromJson(JsonObject jsonObject) {
        CharacterMounts mounts = new CharacterMounts();

        if (jsonObject.has("numCollected"))
            mounts.setNumCollected(jsonObject.get("numCollected").getAsInt());
        else mounts.setNumCollected(-1);

        if (jsonObject.has("numNotCollected"))
            mounts.setNumNotCollected(jsonObject.get("numNotCollected").getAsInt());
        else mounts.setNumNotCollected(-1);

        if (jsonObject.has("collected"))
            mounts.setCollected(Mount.parseJsonArray(jsonObject.getAsJsonArray("collected")));
        else mounts.setCollected(Mount.parseJsonArray(new JsonArray()));

        return mounts;
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

    public List<Mount> getCollected() {
        return mCollected;
    }

    public void setCollected(List<Mount> collected) {
        mCollected = collected;
    }
}
