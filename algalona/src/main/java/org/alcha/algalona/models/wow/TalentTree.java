package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 09, 2017 @ 13:23.</p>
 */

public class TalentTree {
    private boolean mSelected;
    private List<Talent> mTalents;
    private Spec mSpec;
    private String mCalcTalent;
    private String mCalcSpec;

    private TalentTree() {
    }

    public static TalentTree newInstanceFromJson(JsonObject jsonObject) {
        TalentTree tree = new TalentTree();

        if (jsonObject.has("selected"))
            tree.setSelected(jsonObject.get("selected").getAsBoolean());
        else tree.setSelected(false);

        if (jsonObject.has("talents"))
            tree.setTalents(Talent.parseJsonArray(jsonObject.getAsJsonArray("talents")));
        else tree.setTalents(Talent.parseJsonArray(new JsonArray()));

        if (jsonObject.has("spec"))
            tree.setSpec(Spec.newInstanceFromJson(jsonObject.getAsJsonObject("spec")));
        else tree.setSpec(Spec.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("calcTalent"))
            tree.setCalcTalent(jsonObject.get("calcTalent").getAsString());
        else tree.setCalcTalent("");

        if (jsonObject.has("calcSpec"))
            tree.setCalcSpec(jsonObject.get("calcSpec").getAsString());
        else tree.setCalcSpec("");

        return tree;
    }

    public static List<TalentTree> parseJsonArray(JsonArray jsonArray) {
        List<TalentTree> talentTrees = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            talentTrees.add(TalentTree.newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return talentTrees;
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        mSelected = selected;
    }

    public List<Talent> getTalents() {
        return mTalents;
    }

    public void addTalent(Talent talent) {
        mTalents.add(talent);
    }

    public void setTalents(List<Talent> talents) {
        mTalents = talents;
    }

    public Spec getSpec() {
        return mSpec;
    }

    public void setSpec(Spec spec) {
        mSpec = spec;
    }

    public String getCalcTalent() {
        return mCalcTalent;
    }

    public void setCalcTalent(String calcTalent) {
        mCalcTalent = calcTalent;
    }

    public String getCalcSpec() {
        return mCalcSpec;
    }

    public void setCalcSpec(String calcSpec) {
        mCalcSpec = calcSpec;
    }
}
