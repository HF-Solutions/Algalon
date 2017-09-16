package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 09, 2017 @ 13:24.</p>
 */

public class Talent {
    private int mTier;
    private int mColumn;
    private Spell mSpell;
    private Spec mSpec;

    private Talent() {
    }

    @Override
    public String toString() {
        return "Tier=" + mTier + "; " +
                "Column=" + mColumn + "; " +
                "Spell=" + mSpell;
    }

    public static Talent newInstanceFromJson(JsonObject jsonObject) {
        Talent talent = new Talent();

        if (jsonObject.has("tier"))
            talent.setTier(jsonObject.get("tier").getAsInt());
        else talent.setTier(-1);

        if (jsonObject.has("column"))
            talent.setColumn(jsonObject.get("column").getAsInt());
        else talent.setColumn(-1);

        if (jsonObject.has("spell"))
            talent.setSpell(Spell.newInstanceFromJson(jsonObject.getAsJsonObject("spell")));
        else talent.setSpell(Spell.newInstanceFromJson(new JsonObject()));

        if (jsonObject.has("spec"))
            talent.setSpec(Spec.newInstanceFromJson(jsonObject.getAsJsonObject("spec")));
        else talent.setSpec(Spec.newInstanceFromJson(new JsonObject()));

        return talent;
    }

    public static List<Talent> parseJsonArray(JsonArray jsonArray) {
        List<Talent> talents = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            talents.add(Talent.newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return talents;
    }

    public int getTier() {
        return mTier;
    }

    public void setTier(int tier) {
        mTier = tier;
    }

    public int getColumn() {
        return mColumn;
    }

    public void setColumn(int column) {
        mColumn = column;
    }

    public Spell getSpell() {
        return mSpell;
    }

    public void setSpell(Spell spell) {
        mSpell = spell;
    }

    public Spec getSpec() {
        return mSpec;
    }

    public void setSpec(Spec spec) {
        mSpec = spec;
    }
}
