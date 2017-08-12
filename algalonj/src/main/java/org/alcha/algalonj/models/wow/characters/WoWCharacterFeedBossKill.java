package org.alcha.algalonj.models.wow.characters;

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
