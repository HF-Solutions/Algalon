package org.alcha.algalonj.models.wow;

import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 15:58.</p>
 */

public class BonusSummary {
    private List<String> mDefaultBonusLists;
    private List<String> mChanceBonusLists;
    private List<String> mBonusChances;

    public BonusSummary() {

    }

    public static BonusSummary newInstanceFromJson(JsonObject jsonObject) {
        BonusSummary summary = new BonusSummary();

        if (jsonObject.has("defaultBonusLists"))
            summary.setDefaultBonusLists(JsonAid.jsonArrayToListStr(jsonObject.getAsJsonArray("defaultBonusLists")));
        else summary.setDefaultBonusLists(new ArrayList<String>());

        if (jsonObject.has("chanceBonusLists"))
            summary.setChanceBonusLists(JsonAid.jsonArrayToListStr(jsonObject.getAsJsonArray("chanceBonusLists")));
        else summary.setChanceBonusLists(new ArrayList<String>());

        if (jsonObject.has("bonusChances"))
            summary.setBonusChances(JsonAid.jsonArrayToListStr(jsonObject.getAsJsonArray("bonusChances")));
        else summary.setBonusChances(new ArrayList<String>());

        return summary;
    }

    public List<String> getDefaultBonusLists() {
        return mDefaultBonusLists;
    }

    public void setDefaultBonusLists(List<String> defaultBonusLists) {
        mDefaultBonusLists = defaultBonusLists;
    }

    public List<String> getChanceBonusLists() {
        return mChanceBonusLists;
    }

    public void setChanceBonusLists(List<String> chanceBonusLists) {
        mChanceBonusLists = chanceBonusLists;
    }

    public List<String> getBonusChances() {
        return mBonusChances;
    }

    public void setBonusChances(List<String> bonusChances) {
        mBonusChances = bonusChances;
    }
}
