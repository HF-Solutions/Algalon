package org.alcha.algalon.models.wow.characters;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 13:27.</p>
 */

public class CharacterPvP extends CharacterField {
    private CharacterBracket mArena2v2;
    private CharacterBracket mArena3v3;
    private CharacterBracket mArenaRBG;
    private CharacterBracket mArena2v2Skirmish;
    private CharacterBracket mUnknown;

    public CharacterPvP() {
        setFieldName(Name.PvP);
    }

    public static CharacterPvP newInstanceFromJson(JsonObject jsonObject) {
        CharacterPvP pvp = new CharacterPvP();

        if (jsonObject.has("brackets")) {
            JsonObject brackets = jsonObject.getAsJsonObject("brackets");
            if (brackets.has("ARENA_BRACKET_2v2"))
                pvp.setArena2v2(CharacterBracket.newInstanceFromJson(brackets.getAsJsonObject("ARENA_BRACKET_2v2")));

            if (brackets.has("ARENA_BRACKET_3v3"))
                pvp.setArena3v3(CharacterBracket.newInstanceFromJson(brackets.getAsJsonObject("ARENA_BRACKET_3v3")));

            if (brackets.has("ARENA_BRACKET_RBG"))
                pvp.setArenaRBG(CharacterBracket.newInstanceFromJson(brackets.getAsJsonObject("ARENA_BRACKET_RBG")));

            if (brackets.has("ARENA_BRACKET_2v2_SKIRMISH"))
                pvp.setArena2v2Skirmish(CharacterBracket.newInstanceFromJson(brackets.getAsJsonObject("ARENA_BRACKET_2v2_SKIRMISH")));

            if (brackets.has("UNKNOWN"))
                pvp.setUnknown(CharacterBracket.newInstanceFromJson(brackets.getAsJsonObject("UNKNOWN")));
        }

        return pvp;
    }

    public CharacterBracket getArena2v2() {
        return mArena2v2;
    }

    public void setArena2v2(CharacterBracket arena2v2) {
        mArena2v2 = arena2v2;
    }

    public CharacterBracket getArena3v3() {
        return mArena3v3;
    }

    public void setArena3v3(CharacterBracket arena3v3) {
        mArena3v3 = arena3v3;
    }

    public CharacterBracket getArenaRBG() {
        return mArenaRBG;
    }

    public void setArenaRBG(CharacterBracket arenaRBG) {
        mArenaRBG = arenaRBG;
    }

    public CharacterBracket getArena2v2Skirmish() {
        return mArena2v2Skirmish;
    }

    public void setArena2v2Skirmish(CharacterBracket arena2v2Skirmish) {
        mArena2v2Skirmish = arena2v2Skirmish;
    }

    public CharacterBracket getUnknown() {
        return mUnknown;
    }

    public void setUnknown(CharacterBracket unknown) {
        mUnknown = unknown;
    }
}
