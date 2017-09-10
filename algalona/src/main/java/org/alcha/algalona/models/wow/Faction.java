package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 *
 * <p>Represents the factions present in WoW.<br/>
 * The {@link Faction#NEUTRAL} faction is only used by {@link Race#PandarenN} when they are
 * first created and haven't gotten to the quest for choosing between {@link Faction#HORDE} or
 * {@link Faction#ALLIANCE}.</p>
 *
 * <p>If at any point the status of the faction is unknown or an invalid id is provided to
 * {@link Faction#fromId(int)}, then the {@link Faction#UNKNOWN} faction is used.</p>
 */
public enum Faction {
    ALLIANCE(0),
    HORDE(1),
    NEUTRAL(2),
    UNKNOWN(42);
    int id;

    Faction(int id) {
        this.id = id;
    }

    /**
     * <p>
     * Iterates through the possible values for {@link Faction} and if a match is found, it is
     * returned. For example, <code>Faction.fromId(1);</code> would return
     * {@link Faction#HORDE}.</p>
     *
     * <p>
     * If no match is found, such as if <code>Faction.fromId(256);</code> was called, then
     * {@link Faction#UNKNOWN} is returned.
     * </p>
     *
     * @param id int value of the faction id
     *
     * @return Faction with matching id or {@link Faction#UNKNOWN}
     */
    public static Faction fromId(int id) {
        for (Faction faction : Faction.values()) {
            if (faction.id == id) return faction;
        }

        return Faction.UNKNOWN;
    }
}
