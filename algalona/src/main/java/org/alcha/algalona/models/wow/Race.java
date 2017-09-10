package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 * Represents the various races within WoW and stores their id as well as faction affiliation. The
 * faction is stored using the {@link Faction} type and the id is an int.
 */
public enum Race {
    Human(1, Faction.ALLIANCE),
    Orc(2, Faction.HORDE),
    Dwarf(3, Faction.ALLIANCE),
    Night_Elf(4, Faction.ALLIANCE),
    Undead(5, Faction.HORDE),
    Tauren(6, Faction.HORDE),
    Gnome(7, Faction.ALLIANCE),
    Troll(8, Faction.HORDE),
    Goblin(9, Faction.HORDE),
    Blood_Elf(10, Faction.HORDE),
    Draenei(11, Faction.ALLIANCE),
    Worgen(22, Faction.ALLIANCE),
    PandarenN(24, Faction.NEUTRAL),
    PandarenA(25, Faction.ALLIANCE),
    PandarenH(26, Faction.HORDE),
    Unknown(42, Faction.NEUTRAL);

    int mId;
    Faction mFaction;

    /**
     * Public constructor for the {@link Race} enum type. Accepts the id and {@link Faction}
     * as the only two required parameters.
     *
     * @param id      int representation of the race
     * @param faction faction the race is a part of
     */
    Race(int id, Faction faction) {
        mId = id;
        mFaction = faction;
    }

    /**
     * At the cost of a minor performance penalty (having to parse all the {@link Race} values),
     * allows you to instantiate a Race using just the id.
     *
     * @param id    int representation of the race
     * @return  Race the int represents
     */
    public static Race fromId(int id) {
        for (Race race : Race.values()) {
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
