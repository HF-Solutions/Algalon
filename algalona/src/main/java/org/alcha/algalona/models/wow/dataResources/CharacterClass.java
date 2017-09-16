package org.alcha.algalona.models.wow.dataResources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public enum CharacterClass {
    Warrior(1, "rage"),
    Paladin(2, "mana"),
    Hunter(3, "focus"),
    Rogue(4, "energy"),
    Priest(5, "mana"),
    Death_Knight(6, "runic-power"),
    Shaman(7, "mana"),
    Mage(8, "mana"),
    Warlock(9, "mana"),
    Monk(10, "energy"),
    Druid(11, "mana"),
    Demon_Hunter(12, "fury"),
    Unknown(13, "n/a");

    private static final String LOG_TAG = "CharacterClass";
    private int mId;
    private String mPowerType;

    CharacterClass(int id, String powerType) {
        mId = id;
        mPowerType = powerType;
    }

    public String getName() {
        return name().replace('_', ' ');
    }

    public static CharacterClass fromId(int id) {
        for (CharacterClass characterClass : CharacterClass.values()) {
            if (characterClass.getId() == id) {
                return characterClass;
            }
        }

        return CharacterClass.Unknown;
    }

    @Override
    public String toString() {
        return name().replace('_', ' ');
    }

    public int getId() {
        return mId;
    }

    public String getPowerType() {
        return mPowerType;
    }

    public static CharacterClass newInstanceFromJson(JsonObject jsonObject) {
        if (jsonObject.has("id"))
            return CharacterClass.fromId(jsonObject.get("id").getAsInt());

        return CharacterClass.Unknown;
    }

    public static List<CharacterClass> parseJsonArray(JsonArray jsonArray) {
        List<CharacterClass> classes = new ArrayList<>();

        for (JsonElement element : jsonArray)
            classes.add(newInstanceFromJson(element.getAsJsonObject()));

        return classes;
    }
}
