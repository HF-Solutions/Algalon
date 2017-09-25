package org.alcha.algalon.models.wow.dataResources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalon.models.wow.Spec;
import org.alcha.algalon.models.wow.Talent;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 22:32.</p>
 */

public class TalentsData {
    private List<Spec> mSpecs;
    private List<Talent> mTalents;
    private String mClass;

    public TalentsData() {
    }

    public static TalentsData newInstanceFromJson(JsonObject jsonObject) {
        TalentsData data = new TalentsData();

        if (jsonObject.has("specs"))
            data.setSpecs(Spec.parseJsonArray(jsonObject.getAsJsonArray("specs")));
        else data.setSpecs(new ArrayList<Spec>());

        if (jsonObject.has("talents")) {
            JsonArray array = jsonObject.getAsJsonArray("talents");
            List<Talent> talents = new ArrayList<>();
            for (JsonElement element1 : array) {
                for (JsonElement element2 : element1.getAsJsonArray()) {
                    for (JsonElement element3 : element2.getAsJsonArray()) {
                        talents.add(Talent.newInstanceFromJson(element3.getAsJsonObject()));
                    }
                }
            }

            data.setTalents(talents);
        } else data.setTalents(new ArrayList<Talent>());

        if (jsonObject.has("class"))
            data.setClassStr(jsonObject.get("class").getAsString());
        else data.setClassStr("");


        return data;
    }

    public static List<TalentsData> parseJsonObject(JsonObject jsonObject) {
        List<TalentsData> talents = new ArrayList<>();

        for (String key : jsonObject.keySet())
            talents.add(newInstanceFromJson(jsonObject.getAsJsonObject(key)));

        return talents;
    }

    public List<Spec> getSpecs() {
        return mSpecs;
    }

    public void setSpecs(List<Spec> specs) {
        mSpecs = specs;
    }

    public List<Talent> getTalents() {
        return mTalents;
    }

    public void setTalents(List<Talent> talents) {
        mTalents = talents;
    }

    public String getClassStr() {
        return mClass;
    }

    public void setClassStr(String aClass) {
        mClass = aClass;
    }
}
