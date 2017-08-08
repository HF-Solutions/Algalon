package org.alcha.algalona.models.wow;

import android.support.annotation.NonNull;

import java.util.Locale;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public enum WoWBattlegroup {
    AUNZ_BATTLE_GROUP,
    BLOODLUST,
    CYCLONE,
    RAMPAGE,
    RECKONING,
    RUIN,
    SHADOWBURN,
    VENGEANCE,
    VINDICATION,
    UNKNOWN;
    private static final String LOG_TAG = "WoWBattlegroup";

    /**
     * Get the slug version of the {@link WoWBattlegroup} that is used by the Battle.net API.
     *
     * @param battlegroup Battlegroup you want the slug for
     * @return  String representing the slug of the Battlegroup
     */
    public String getSlug(@NonNull WoWBattlegroup battlegroup) {
        return battlegroup.toString().toLowerCase(Locale.US).replace('_', '-');
    }
}
