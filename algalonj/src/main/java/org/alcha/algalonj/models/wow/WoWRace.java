package org.alcha.algalonj.models.wow;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 * Represents the various races within WoW and stores their id as well as faction affiliation. The
 * faction is stored using the {@link WoWFaction} type and the id is an int.
 */
public enum WoWRace {
    Human(1, WoWFaction.ALLIANCE),
    Orc(2, WoWFaction.HORDE),
    Dwarf(3, WoWFaction.ALLIANCE),
    Night_Elf(4, WoWFaction.ALLIANCE),
    Undead(5, WoWFaction.HORDE),
    Tauren(6, WoWFaction.HORDE),
    Gnome(7, WoWFaction.ALLIANCE),
    Troll(8, WoWFaction.HORDE),
    Goblin(9, WoWFaction.HORDE),
    Blood_Elf(10, WoWFaction.HORDE),
    Draenei(11, WoWFaction.ALLIANCE),
    Worgen(22, WoWFaction.ALLIANCE),
    PandarenN(24, WoWFaction.NEUTRAL),
    PandarenA(25, WoWFaction.ALLIANCE),
    PandarenH(26, WoWFaction.HORDE),
    Unknown(42, WoWFaction.NEUTRAL);

    int mId;
    WoWFaction mFaction;

    /**
     * Public constructor for the {@link WoWRace} enum type. Accepts the id and {@link WoWFaction}
     * as the only two required parameters.
     *
     * @param id      int representation of the race
     * @param faction faction the race is a part of
     */
    WoWRace(int id, WoWFaction faction) {
        mId = id;
        mFaction = faction;
    }

    /**
     * At the cost of a minor performance penalty (having to parse all the {@link WoWRace} values),
     * allows you to instantiate a WoWRace using just the id.
     *
     * @param id    int representation of the race
     * @return  WoWRace the int represents
     */
    public static WoWRace fromId(int id) {
        for (WoWRace race : WoWRace.values()) {
            if (race.mId == id) return race;
        }

        return Unknown;
    }

    /**
     * I override the <code>toString()</code> method for two reasons regarding the display of the
     * race names:
     * <ol><li>
     * There are three Pandaren races, Neutral, Alliance, and Horde. Their enum name is
     * PandarenN, PandarenA, and PandarenH, respectively. If either of these are selected
     * and the toString() method is called, <code>"Pandaren"</code> is returned.
     * </li><li>
     * As with almost all of the enums in this library, the underscore present in the type
     * name is replaced with a space when output to a String.
     * </li></ol>
     *
     * @return String representation of the enum type name
     */
    @Override
    public String toString() {
        if (mId == 24 || mId == 25 || mId == 26) return "Pandaren";
        else return super.toString().replace('_', ' ');
    }
}
