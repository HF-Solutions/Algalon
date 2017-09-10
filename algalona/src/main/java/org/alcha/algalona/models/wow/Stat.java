package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 22, 2017 @ 23:18.</p>
 * Copyright (c) 2017 Paranoid Devs.
 */

public class Stat {
    private int mStat;
    private int mAmount;

    public Stat(int stat, int amount) {
        mStat = stat;
        mAmount = amount;
    }

    public int getStat() {
        return mStat;
    }

    public int getAmount() {
        return mAmount;
    }

    public static List<Stat> parseJsonArray(JsonArray array) {
        List<Stat> stats = new ArrayList<>();

        for (int x = 0; x < array.size(); x++) {
            int statId = array.get(x).getAsJsonObject().get("stat").getAsInt();
            int statAmt = array.get(x).getAsJsonObject().get("amount").getAsInt();

            stats.add(new Stat(statId, statAmt));
        }

        return stats;
    }
}
