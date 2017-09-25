package org.alcha.algalon.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalon.util.JsonAid;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 07:13.</p>
 */

public class GuildItemLoot extends GuildNewsEntry {
    private int mItemId;

    public GuildItemLoot() {
        setType(Type.ITEM_LOOT);
    }

    @Override
    public String toString() {
        return "Type=" + getType() + ";" +
                "Character=" + getCharacterName() + ";" +
                "ItemId=" + getItemId();
    }

    public static GuildItemLoot newInstanceFromJson(JsonObject jsonObject) {
        GuildItemLoot itemLoot = new GuildItemLoot();

        if (jsonObject.has("character"))
            itemLoot.setCharacterName(jsonObject.get("character").getAsString());
        else itemLoot.setCharacterName("");

        if (jsonObject.has("timestamp"))
            itemLoot.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else itemLoot.setTimestamp(-1L);

        if (jsonObject.has("itemId"))
            itemLoot.setItemId(jsonObject.get("itemId").getAsInt());
        else itemLoot.setItemId(-1);

        if (jsonObject.has("context"))
            itemLoot.setContext(jsonObject.get("context").getAsString());
        else itemLoot.setContext("");

        if (jsonObject.has("bonusLists"))
            itemLoot.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else itemLoot.setBonusLists(new int[0]);

        return itemLoot;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }
}
