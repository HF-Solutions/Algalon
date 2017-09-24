package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 09, 2017 @ 09:57.</p>
 */

public class StatisticCategory {
    private int mId;
    private String mName;
    private List<Statistic> mStatistics;
    private List<StatisticCategory> mSubCategories;

    private StatisticCategory() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StatisticCategory) {
            StatisticCategory cat1 = (StatisticCategory) obj;
            return mId == cat1.getId();
        } else return false;
    }

    @Override
    public String toString() {
        return "id = " + mId +
                ";name = " + mName +
                ";statistics.size = " + mStatistics.size() +
                ";subCategories.size = " + mSubCategories.size();
    }

    public static StatisticCategory newInstanceFromJson(JsonObject jsonObject) {
        StatisticCategory category = new StatisticCategory();

        if (jsonObject.has("id"))
            category.setId(jsonObject.get("id").getAsInt());
        else category.setId(-1);

        if (jsonObject.has("name"))
            category.setName(jsonObject.get("name").getAsString());
        else category.setName("");

        if (jsonObject.has("statistics"))
            category.setStatistics(Statistic.parseJsonArray(jsonObject.getAsJsonArray("statistics")));
        else category.setStatistics(new ArrayList<Statistic>());

        if (jsonObject.has("subCategories"))
            category.setSubCategories(parseJsonArray(jsonObject.getAsJsonArray("subCategories")));
        else category.setSubCategories(new ArrayList<StatisticCategory>());

        return category;
    }

    public static List<StatisticCategory> parseJsonArray(JsonArray jsonArray) {
        List<StatisticCategory> categories = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            categories.add(StatisticCategory.newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return categories;
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

    public List<Statistic> getStatistics() {
        return mStatistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        mStatistics = statistics;
    }

    public List<StatisticCategory> getSubCategories() {
        return mSubCategories;
    }

    public void setSubCategories(List<StatisticCategory> subCategories) {
        mSubCategories = subCategories;
    }
}
