package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:30.</p>
 */

public class Mount {
    private String mName;
    private int mSpellId;
    private int mCreatureId;
    private int mItemId;
    private int mQualityId;
    private String mIcon;
    private boolean mIsGround;
    private boolean mIsFlying;
    private boolean mIsAquatic;
    private boolean mIsJumping;

    public Mount() {

    }

    public static Mount newInstanceFromJson(JsonObject jsonObject) {
        Mount mount = new Mount();

        if (jsonObject.has("name"))
            mount.setName(jsonObject.get("name").getAsString());
        else mount.setName("");

        if (jsonObject.has("spellId"))
            mount.setSpellId(jsonObject.get("spellId").getAsInt());
        else mount.setSpellId(-1);

        if (jsonObject.has("creatureId"))
            mount.setCreatureId(jsonObject.get("creatureId").getAsInt());
        else mount.setCreatureId(-1);

        if (jsonObject.has("itemId"))
            mount.setItemId(jsonObject.get("itemId").getAsInt());
        else mount.setItemId(-1);

        if (jsonObject.has("qualityId"))
            mount.setQualityId(jsonObject.get("qualityId").getAsInt());
        else mount.setQualityId(-1);

        if (jsonObject.has("icon"))
            mount.setIcon(jsonObject.get("icon").getAsString());
        else mount.setIcon("");

        if (jsonObject.has("isGround"))
            mount.setGround(jsonObject.get("isGround").getAsBoolean());
        else mount.setGround(false);

        if (jsonObject.has("isFlying"))
            mount.setFlying(jsonObject.get("isFlying").getAsBoolean());
        else mount.setFlying(false);

        if (jsonObject.has("isAquatic"))
            mount.setAquatic(jsonObject.get("isAquatic").getAsBoolean());
        else mount.setAquatic(false);

        if (jsonObject.has("isJumping"))
            mount.setJumping(jsonObject.get("isJumping").getAsBoolean());
        else mount.setJumping(false);

        return mount;
    }

    public static List<Mount> parseJsonArray(JsonArray jsonArray) {
        List<Mount> tempList = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            tempList.add(Mount.newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return tempList;
    }

    public boolean isJumping() {
        return mIsJumping;
    }

    public void setJumping(boolean jumping) {
        mIsJumping = jumping;
    }

    public boolean isAquatic() {
        return mIsAquatic;
    }

    public void setAquatic(boolean aquatic) {
        mIsAquatic = aquatic;
    }

    public boolean isFlying() {
        return mIsFlying;
    }

    public void setFlying(boolean flying) {
        mIsFlying = flying;
    }

    public boolean isGround() {
        return mIsGround;
    }

    public void setGround(boolean ground) {
        mIsGround = ground;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getQualityId() {
        return mQualityId;
    }

    public void setQualityId(int qualityId) {
        mQualityId = qualityId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getSpellId() {
        return mSpellId;
    }

    public void setSpellId(int spellId) {
        mSpellId = spellId;
    }

    public int getCreatureId() {
        return mCreatureId;
    }

    public void setCreatureId(int creatureId) {
        mCreatureId = creatureId;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }
}
