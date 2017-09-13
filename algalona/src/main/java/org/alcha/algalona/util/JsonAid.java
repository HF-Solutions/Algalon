package org.alcha.algalona.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String, Integer> jsonObjectToMap(JsonObject jsonObject) {
        Map<String, Integer> tempMap = new HashMap<>();

        for (String key : jsonObject.keySet()) {
            tempMap.put(key, jsonObject.get(key).getAsInt());
        }

        return tempMap;
    }
}
