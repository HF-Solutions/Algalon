package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonArray;

import org.alcha.algalonj.models.wow.TalentTree;

import java.util.List;

/**
 * <p>Created by Alcha on Sep 09, 2017 @ 13:21.</p>
 */

public class CharacterTalents extends CharacterField {
    private List<TalentTree> mTalents;

    private CharacterTalents() {
        setFieldName(Name.Talents);
    }

    public static CharacterTalents newInstanceFromJson(JsonArray jsonArray) {
        CharacterTalents talents = new CharacterTalents();

        talents.setTalentTrees(TalentTree.parseJsonArray(jsonArray));

        return talents;
    }

    public List<TalentTree> getTalentTrees() {
        return mTalents;
    }

    public void setTalentTrees(List<TalentTree> talents) {
        mTalents = talents;
    }
}
