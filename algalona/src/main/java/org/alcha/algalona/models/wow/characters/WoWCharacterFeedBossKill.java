package org.alcha.algalona.models.wow.characters;

import org.json.JSONObject;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeedBossKill extends WoWCharacterFeedEntry {
    private WoWCharacterFeedBossKill() {
        setEntryType(Type.BOSSKILL);
    }

    public WoWCharacterFeedBossKill newInstance() { return new WoWCharacterFeedBossKill();}

    public WoWCharacterFeedBossKill newInstanceFromJSON(JSONObject jsonObject) {
        WoWCharacterFeedBossKill bossKill = new WoWCharacterFeedBossKill();

        return bossKill;
    }
}
