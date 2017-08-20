package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import static org.alcha.algalona.models.wow.characters.WoWCharacterField.Name.Items;

/**
 * <p>Created by Alcha on Aug 19, 2017 @ 23:00.</p>
 * Copyright (c) 2017 Paranoid Devs.
 */

public class WoWCharacterItems extends WoWCharacterField {
    private static int mAverageItemLevel;
    private static int mAverageItemLevelEquipped;

    private WoWCharacterItems() {
        setFieldName(Items);
    }

    public WoWCharacterItems newInstanceFromJson(JsonObject jsonObject) {
        WoWCharacterItems characterItems = new WoWCharacterItems();

        if (jsonObject.has("averageItemLevel"))
            characterItems.setAverageItemLevel(jsonObject.get("averageItemLevel").getAsInt());

        if (jsonObject.has("averageItemLevelEquipped"))
            characterItems.setAverageItemLevelEquipped(jsonObject.get("averageItemLevelEquipped").getAsInt());

        return characterItems;
    }

    // Setters
    private void setAverageItemLevel(int averageItemLevel) {
        mAverageItemLevel = averageItemLevel;
    }

    private void setAverageItemLevelEquipped(int averageItemLevelEquipped) {
        mAverageItemLevelEquipped = averageItemLevelEquipped;
    }

    // Getters
    public int getAverageItemLevel() {
        return mAverageItemLevel;
    }

    public int getAverageItemLevelEquipped() {
        return mAverageItemLevelEquipped;
    }
}
