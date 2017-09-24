package org.alcha.algalonj.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalonj.util.JsonAid;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 06:57.</p>
 */

public class GuildItemCraft extends GuildNewsEntry {
    private int mItemId;

    public GuildItemCraft() {
        setType(Type.ITEM_CRAFT);
    }

    @Override
    public String toString() {
        return "Type=" + getType() + ";" +
                "Character=" + getCharacterName() + ";" +
                "ItemId=" + getItemId();
    }

    public static GuildItemCraft newInstanceFromJson(JsonObject jsonObject) {
        GuildItemCraft itemCraft = new GuildItemCraft();

        if (jsonObject.has("character"))
            itemCraft.setCharacterName(jsonObject.get("character").getAsString());
        else itemCraft.setCharacterName("");

        if (jsonObject.has("timestamp"))
            itemCraft.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else itemCraft.setTimestamp(-1L);

        if (jsonObject.has("itemId"))
            itemCraft.setItemId(jsonObject.get("itemId").getAsInt());
        else itemCraft.setItemId(-1);

        if (jsonObject.has("context"))
            itemCraft.setContext(jsonObject.get("context").getAsString());
        else itemCraft.setContext("");

        if (jsonObject.has("bonusLists"))
            itemCraft.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else itemCraft.setBonusLists(new int[0]);

        return itemCraft;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }
}
