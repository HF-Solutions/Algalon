package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 07, 2017 @ 04:41.</p>
 */

public class Statistic {
    private int mId;
    private String mName;
    private int mQuantity;
    private long mLastUpdated;
    private boolean mMoney;

    private Statistic() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Statistic) {
            Statistic statistic = (Statistic) obj;
            return mId == statistic.getId();
        } else return false;
    }

    @Override
    public String toString() {
        return "id=" + mId +
                ";name=" + mName +
                ";quantity=" + mQuantity +
                ";lastUpdated=" + mLastUpdated +
                ";money=" + mMoney;
    }

    public static Statistic newInstanceFromJson(JsonObject jsonObject) {
        Statistic statistic = new Statistic();

        if (jsonObject.has("id"))
            statistic.setId(jsonObject.get("id").getAsInt());

        if (jsonObject.has("name"))
            statistic.setName(jsonObject.get("name").getAsString());

        if (jsonObject.has("quantity"))
            statistic.setQuantity(jsonObject.get("quantity").getAsInt());

        if (jsonObject.has("lastUpdated"))
            statistic.setLastUpdated(jsonObject.get("lastUpdated").getAsInt());

        if (jsonObject.has("money"))
            statistic.setMoney(jsonObject.get("money").getAsBoolean());

        return statistic;
    }

    public static List<Statistic> parseJsonArray(JsonArray jsonArray) {
        List<Statistic> statistics = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            statistics.add(newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

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

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public long getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public boolean isMoney() {
        return mMoney;
    }

    public void setMoney(boolean money) {
        mMoney = money;
    }
}
