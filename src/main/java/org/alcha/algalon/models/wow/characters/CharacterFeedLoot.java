package org.alcha.algalon.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalon.util.JsonAid;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class CharacterFeedLoot extends CharacterFeedEntry {
    private int mItemId;
    private String mContext;
    private int[] mBonusLists;

    public CharacterFeedLoot() {
        setEntryType(Type.LOOT);
    }

    public static CharacterFeedLoot newInstanceFromJson(JsonObject jsonObject) {
        CharacterFeedLoot feedLoot = new CharacterFeedLoot();

        if (jsonObject.has("timestamp"))
            feedLoot.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else feedLoot.setTimestamp(-1);

        if (jsonObject.has("itemId"))
            feedLoot.setItemId(jsonObject.get("itemId").getAsInt());
        else feedLoot.setItemId(-1);

        if (jsonObject.has("context"))
            feedLoot.setContext(jsonObject.get("context").getAsString());
        else feedLoot.setContext("");

        if (jsonObject.has("bonusLists"))
            feedLoot.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else feedLoot.setBonusLists(new int[0]);

        return feedLoot;
    }

    public int[] getBonusLists() {
        return mBonusLists;
    }

    public void setBonusLists(int[] bonusLists) {
        mBonusLists = bonusLists;
    }

    public String getContext() {
        return mContext;
    }

    public void setContext(String context) {
        mContext = context;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }
}
