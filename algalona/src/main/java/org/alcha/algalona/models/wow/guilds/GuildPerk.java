package org.alcha.algalona.models.wow.guilds;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Spell;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class GuildPerk {
    private int mGuildLevel;
    private Spell mGuildSpell;

    public GuildPerk() {
    }

    public static GuildPerk newInstanceFromJson(JsonObject jsonObject) {
        GuildPerk perk = new GuildPerk();

        if (jsonObject.has("guildLevel"))
            perk.setGuildLevel(jsonObject.get("guildLevel").getAsInt());
        else perk.setGuildLevel(-1);

        if (jsonObject.has("spell"))
            perk.setGuildSpell(Spell.newInstanceFromJson(jsonObject.getAsJsonObject("spell")));
        else perk.setGuildSpell(new Spell());

        return perk;
    }

    public static List<GuildPerk> parseJsonArray(JsonArray jsonArray) {
        List<GuildPerk> guildPerks = new ArrayList<>();

        for (JsonElement element : jsonArray)
            guildPerks.add(newInstanceFromJson(element.getAsJsonObject()));

        return guildPerks;
    }

    public int getGuildLevel() {
        return mGuildLevel;
    }

    public void setGuildLevel(int guildLevel) {
        mGuildLevel = guildLevel;
    }

    public Spell getGuildSpell() {
        return mGuildSpell;
    }

    public void setGuildSpell(Spell guildSpell) {
        mGuildSpell = guildSpell;
    }
}
