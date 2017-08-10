package org.alcha.algalonj.models.wow.guilds;


import org.alcha.algalonj.models.wow.WoWSpell;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWGuildPerk {
    private int mGuildLevel = 1;
    private WoWSpell mGuildSpell;

    public WoWGuildPerk (WoWSpell guildSpell) {
        mGuildSpell = guildSpell;
    }

    public int getGuildLevel() {
        return mGuildLevel;
    }

    public void setGuildLevel(int guildLevel) {
        mGuildLevel = guildLevel;
    }
}
