package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeedLoot extends WoWCharacterFeedEntry {
    private int mItemId;
    private String mContext;
    private int[] mBonusLists;

    private WoWCharacterFeedLoot() {
        setEntryType(Type.LOOT);
    }

    public WoWCharacterFeedLoot newInstance() {
        return new WoWCharacterFeedLoot();
    }

    public static WoWCharacterFeedLoot newInstanceFromJson(JsonObject jsonObject) {
        WoWCharacterFeedLoot feedLoot = new WoWCharacterFeedLoot();

        if(jsonObject.has("timestamp"))
            feedLoot.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else feedLoot.setTimestamp(-1);

        if(jsonObject.has("itemId"))
            feedLoot.setItemId(jsonObject.get("itemId").getAsInt());
        else feedLoot.setItemId(-1);

        if(jsonObject.has("context"))
            feedLoot.setContext(jsonObject.get("context").getAsString());
        else feedLoot.setContext("");

        if(jsonObject.has("bonusLists"))
            feedLoot.setBonusLists(JsonAid.jsonArrayToIntArray(jsonObject.getAsJsonArray("bonusLists")));

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
