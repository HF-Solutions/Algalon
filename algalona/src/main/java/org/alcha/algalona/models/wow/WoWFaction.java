package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 *
 * <p>
 * Represents the factions present in WoW and while there are technically 3, only 2 are ever used.
 * <br/>
 * The {@link WoWFaction#NEUTRAL} faction is only used by {@link WoWRace#PandarenN} when they are
 * first created and haven't gotten to the quest for choosing between {@link WoWFaction#HORDE} or
 * {@link WoWFaction#ALLIANCE}.
 * </p>
 *
 * <p>
 * If at any point the status of the faction is unknown or an invalid id is provided to
 * {@link WoWFaction#fromId(int)}, then the {@link WoWFaction#UNKNOWN} faction is used.
 * </p>
 */
public enum WoWFaction {
    ALLIANCE(0),
    HORDE(1),
    NEUTRAL(2),
    UNKNOWN(42);
    int id;

    WoWFaction(int id) {
        this.id = id;
    }

    /**
     * <p>
     * Iterates through the possible values for {@link WoWFaction} and if a match is found, it is
     * returned. For example, <code>WoWFaction.fromId(1);</code> would return
     * {@link WoWFaction#HORDE}.</p>
     *
     * <p>
     * If no match is found, such as if <code>WoWFaction.fromId(256);</code> was called, then
     * {@link WoWFaction#UNKNOWN} is returned.
     * </p>
     *
     * @param id int value of the faction id
     *
     * @return WoWFaction with matching id or {@link WoWFaction#UNKNOWN}
     */
    public static WoWFaction fromId(int id) {
        for (WoWFaction faction : WoWFaction.values()) {
            if (faction.id == id) return faction;
        }

        return WoWFaction.UNKNOWN;
    }
}
