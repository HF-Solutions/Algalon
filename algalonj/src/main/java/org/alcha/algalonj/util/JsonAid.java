package org.alcha.algalonj.util;

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
    public static int[] jsonArrayToArrayInt(JsonArray jsonArray) {
        int[] array = new int[jsonArray.size()];

        for (int x = 0; x < jsonArray.size(); x++) {
            array[x] = jsonArray.get(x).getAsInt();
        }

        return array;
    }

    public static String[] jsonArrayToArrayStr(JsonArray jsonArray) {
        String[] strings = new String[jsonArray.size()];

        for (int x = 0; x < jsonArray.size(); x++)
            strings[x] = jsonArray.get(x).getAsString();

        return strings;
    }

    public static List<Integer> jsonArrayToListInt(JsonArray jsonArray) {
        List<Integer> tempList = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            tempList.add(jsonArray.get(x).getAsInt());
        }

        return tempList;
    }

    public static List<String> jsonArrayToListStr(JsonArray jsonArray) {
        List<String> tempList = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            tempList.add(jsonArray.get(x).getAsString());
        }

        return tempList;
    }

    public static List<Long> jsonArrayToListLong(JsonArray jsonArray) {
        List<Long> tempList = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            tempList.add(jsonArray.get(x).getAsLong());
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
