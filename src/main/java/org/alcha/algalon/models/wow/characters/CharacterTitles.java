package org.alcha.algalon.models.wow.characters;

import com.google.gson.JsonArray;

import org.alcha.algalon.models.wow.Title;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 27, 2017 @ 03:37.</p>
 */

public class CharacterTitles extends CharacterField {
    private List<Title> mTitles;

    public CharacterTitles() {

    }

    public static CharacterTitles newInstanceFromJson(JsonArray jsonArray) {
        CharacterTitles characterTitles = new CharacterTitles();

        for (int x = 0; x < jsonArray.size(); x++) {
            characterTitles.addTitle(Title.newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return characterTitles;
    }

    public List<Title> getTitles() {
        return mTitles;
    }

    public void setTitles(List<Title> titles) {
        mTitles = titles;
    }

    public void addTitle(Title title) {
        mTitles.add(title);
    }

    public void addTitle(int index, Title title) {
        mTitles.add(index, title);
    }

    public void addTitles(List<Title> titles) {
        mTitles.addAll(titles);
    }

    public Title getTitle(int index) {
        return mTitles.get(index);
    }
}
