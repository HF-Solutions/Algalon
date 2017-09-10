package org.alcha.algalona.util;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 06:21.</p>
 */

public abstract class JsonAid {
    public static int[] jsonArrayToIntArray(JsonArray jsonArray) {
        int[] array = new int[jsonArray.size()];

        for (int x = 0; x < jsonArray.size(); x++) {
            array[x] = jsonArray.get(x).getAsInt();
        }

        return array;
    }

    public static List<Integer> jsonArrayToIntList(JsonArray jsonArray) {
        List<Integer> tempList = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            tempList.add(jsonArray.get(x).getAsInt());
        }

        return tempList;
    }
}
