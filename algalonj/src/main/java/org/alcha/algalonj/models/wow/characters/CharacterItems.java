package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.Item;
import org.alcha.algalonj.models.wow.Stat;
import org.alcha.algalonj.models.wow.TooltipParam;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 19, 2017 @ 23:00.</p>
 *
 * <p>This is used to store the various items a {@link java.lang.Character} has equipped. For example,
 * their helm, neck, shoulders, chest, etc..</p>
 */

public class CharacterItems extends CharacterField {
    private int mAverageItemLevel;
    private int mAverageItemLevelEquipped;
    private List<TooltipParam> mTooltipParams;
    private List<Stat> mStats;
    private List<Item> mItems;

    public CharacterItems() {
        setFieldName(Name.Items);
    }

    public static CharacterItems newInstanceFromJson(JsonObject jsonObject) {
        CharacterItems characterItems = new CharacterItems();
        List<Item> items = new ArrayList<>();

        if (jsonObject.has("averageItemLevel"))
            characterItems.setAverageItemLevel(jsonObject.get("averageItemLevel").getAsInt());
        else characterItems.setAverageItemLevel(-1);

        if (jsonObject.has("averageItemLevelEquipped"))
            characterItems.setAverageItemLevelEquipped(jsonObject.get("averageItemLevelEquipped").getAsInt());
        else characterItems.setAverageItemLevelEquipped(-1);

        if (jsonObject.has("head"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("head")));

        if (jsonObject.has("neck"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("neck")));

        if (jsonObject.has("shoulder"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("shoulder")));

        if (jsonObject.has("back"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("back")));

        if (jsonObject.has("chest"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("chest")));

        if (jsonObject.has("shirt"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("shirt")));

        if (jsonObject.has("tabard"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("tabard")));

        if (jsonObject.has("wrist"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("wrist")));

        if (jsonObject.has("hands"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("hands")));

        if (jsonObject.has("waist"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("waist")));

        if (jsonObject.has("legs"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("legs")));

        if (jsonObject.has("feet"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("feet")));

        if (jsonObject.has("finger1"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("finger1")));

        if (jsonObject.has("finger2"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("finger2")));

        if (jsonObject.has("trinket1"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("trinket1")));

        if (jsonObject.has("trinket2"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("trinket2")));

        if (jsonObject.has("mainHand"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("mainHand")));

        if (jsonObject.has("offHand"))
            items.add(Item.newInstanceFromJson(jsonObject.getAsJsonObject("offHand")));

        characterItems.setItems(items);

        return characterItems;
    }

    public int getAverageItemLevel() {
        return mAverageItemLevel;
    }

    public int getAverageItemLevelEquipped() {
        return mAverageItemLevelEquipped;
    }

    public void setAverageItemLevel(int averageItemLevel) {
        mAverageItemLevel = averageItemLevel;
    }

    public void setAverageItemLevelEquipped(int averageItemLevelEquipped) {
        mAverageItemLevelEquipped = averageItemLevelEquipped;
    }

    public List<Stat> getStats() {
        return mStats;
    }

    public void setStats(List<Stat> stats) {
        mStats = stats;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }
}
