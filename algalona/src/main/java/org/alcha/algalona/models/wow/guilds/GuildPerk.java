package org.alcha.algalona.models.wow.guilds;


import org.alcha.algalona.models.wow.Spell;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class GuildPerk {
    private int mGuildLevel = 1;
    private Spell mGuildSpell;

    public GuildPerk(Spell guildSpell) {
        mGuildSpell = guildSpell;
    }

    public int getGuildLevel() {
        return mGuildLevel;
    }

    void setGuildLevel(int guildLevel) {
        mGuildLevel = guildLevel;
    }
}
