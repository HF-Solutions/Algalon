package org.alcha.algalona.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:13.</p>
 */

public class Item {
    private int mId;
    private String mName;
    private String mIcon;
    private int mQuality;
    private int mItemLevel;

    public Item() {

    }

    public static Item newInstanceFromJson(JsonObject jsonObject) {
        Item item = new Item();

        if (jsonObject.has("id"))
            item.setId(jsonObject.get("id").getAsInt());
        else item.setId(-1);

        if (jsonObject.has("name"))
            item.setName(jsonObject.get("name").getAsString());
        else item.setName("");

        if (jsonObject.has("icon"))
            item.setIcon(jsonObject.get("icon").getAsString());
        else item.setIcon("");

        if (jsonObject.has("quality"))
            item.setQuality(jsonObject.get("quality").getAsInt());
        else item.setQuality(-1);

        if (jsonObject.has("itemLevel"))
            item.setItemLevel(jsonObject.get("itemLevel").getAsInt());
        else item.setItemLevel(-1);

        return item;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getQuality() {
        return mQuality;
    }

    public void setQuality(int quality) {
        mQuality = quality;
    }

    public int getItemLevel() {
        return mItemLevel;
    }

    public void setItemLevel(int itemLevel) {
        mItemLevel = itemLevel;
    }
}
