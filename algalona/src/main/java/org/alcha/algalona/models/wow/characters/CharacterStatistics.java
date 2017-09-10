package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.StatisticCategory;

import java.util.List;

/**
 * <p>Created by Alcha on Sep 03, 2017 @ 06:03.</p>
 */

public class CharacterStatistics extends CharacterField {
    private int mId;
    private String mName;
    private List<StatisticCategory> mStatisticCategories;

    private CharacterStatistics() {
        setFieldName(Name.Statistics);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CharacterStatistics) {
            CharacterStatistics statistics = (CharacterStatistics) obj;
            return statistics.getId() == mId;
        } else return false;
    }

    @Override
    public String toString() {
        return "id = " + mId +
                ";name = " + mName +
                ";statisticCategories.size() = " + mStatisticCategories.size();
    }

    public static CharacterStatistics newInstanceFromJson(JsonObject jsonObject) {
        CharacterStatistics statistics = new CharacterStatistics();

        if (jsonObject.has("id"))
            statistics.setId(jsonObject.get("id").getAsInt());
        else statistics.setId(-1);

        if (jsonObject.has("name"))
            statistics.setName(jsonObject.get("name").getAsString());
        else statistics.setName("");

        if (jsonObject.has("subCategories"))
            statistics.setStatistics(StatisticCategory.parseJsonArray(jsonObject.getAsJsonArray("subCategories")));
        else statistics.setStatistics(StatisticCategory.parseJsonArray(new JsonArray()));

        return statistics;
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

    public List<StatisticCategory> getStatistics() {
        return mStatisticCategories;
    }

    public void setStatistics(List<StatisticCategory> statistics) {
        mStatisticCategories = statistics;
    }
}
