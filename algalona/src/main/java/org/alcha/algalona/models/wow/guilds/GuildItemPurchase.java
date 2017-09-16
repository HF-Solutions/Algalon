package org.alcha.algalona.models.wow.guilds;

import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 07:20.</p>
 */

public class GuildItemPurchase extends GuildNewsEntry {
    private int mItemId;

    public GuildItemPurchase() {
        setType(Type.ITEM_PURCHASE);
    }

    @Override
    public String toString() {
        return "Type=" + getType() + ";" +
                "Character=" + getCharacterName() + ";" +
                "ItemId=" + getItemId();
    }

    public static GuildItemPurchase newInstanceFromJson(JsonObject jsonObject) {
        GuildItemPurchase itemPurchase = new GuildItemPurchase();

        if (jsonObject.has("character"))
            itemPurchase.setCharacterName(jsonObject.get("character").getAsString());
        else itemPurchase.setCharacterName("");

        if (jsonObject.has("timestamp"))
            itemPurchase.setTimestamp(jsonObject.get("timestamp").getAsLong());
        else itemPurchase.setTimestamp(-1L);

        if (jsonObject.has("itemId"))
            itemPurchase.setItemId(jsonObject.get("itemId").getAsInt());
        else itemPurchase.setItemId(-1);

        if (jsonObject.has("context"))
            itemPurchase.setContext(jsonObject.get("context").getAsString());
        else itemPurchase.setContext("");

        if (jsonObject.has("bonusLists"))
            itemPurchase.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else itemPurchase.setBonusLists(new int[0]);

        return itemPurchase;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }
}
