package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 16:06.</p>
 */

public class ItemSet {
    public static class SetBonus {
        private String description;
        private int threshold;

        public static SetBonus newInstanceFromJson(JsonObject jsonObject) {
            SetBonus bonus = new SetBonus();

            if (jsonObject.has("description"))
                bonus.setDescription(jsonObject.get("description").getAsString());
            else bonus.setDescription("");

            if (jsonObject.has("threshold"))
                bonus.setThreshold(jsonObject.get("threshold").getAsInt());
            else bonus.setThreshold(-1);

            return bonus;
        }

        public static List<SetBonus> parseJsonArray(JsonArray jsonArray) {
            List<SetBonus> tempList = new ArrayList<>();

            for (JsonElement element : jsonArray)
                tempList.add(newInstanceFromJson(element.getAsJsonObject()));

            return tempList;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }
    }

    private int mId;
    private String mName;
    private List<SetBonus> mSetBonuses;
    private int[] mItems;

    public static ItemSet newInstanceFromJson(JsonObject jsonObject) {
        ItemSet set = new ItemSet();

        if (jsonObject.has("id"))
            set.setId(jsonObject.get("id").getAsInt());
        else set.setId(-1);

        if (jsonObject.has("name"))
            set.setName(jsonObject.get("name").getAsString());
        else set.setName("");

        if (jsonObject.has("setBonuses"))
            set.setSetBonuses(SetBonus.parseJsonArray(jsonObject.getAsJsonArray("setBonuses")));
        else set.setSetBonuses(new ArrayList<SetBonus>());

        if (jsonObject.has("items"))
            set.setItems(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("items")));
        else set.setItems(new int[0]);

        return set;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<SetBonus> getSetBonuses() {
        return mSetBonuses;
    }

    public void setSetBonuses(List<SetBonus> setBonuses) {
        mSetBonuses = setBonuses;
    }

    public int[] getItems() {
        return mItems;
    }

    public void setItems(int[] items) {
        mItems = items;
    }
}
