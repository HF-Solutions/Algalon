package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public enum  WoWCharacterClass {
    Warrior(1, "rage"),
    Paladin(2, "mana"),
    Hunter(3, "focus"),
    Rogue(4, "energy"),
    Priest(5, "mana"),
    Death_Knight(6, "runic-power"),
    Shaman(7, "mana"),
    Mage(8, "mana"),
    Warlock(9, "mana"),
    Monk(10, "energy"),
    Druid(11, "mana"),
    Demon_Hunter(12, "fury"),
    Unknown(13, "n/a");

    private static final String LOG_TAG = "WoWCharacterClass";
    private int mId;
    private String mPowerType;

    WoWCharacterClass(int id, String powerType) {
        mId = id;
        mPowerType = powerType;
    }

    public static WoWCharacterClass fromId(int id) {
        for (WoWCharacterClass characterClass : WoWCharacterClass.values()) {
            if(characterClass.getId() == id) {
                return characterClass;
            }
        }

        return WoWCharacterClass.Unknown;
    }

    @Override
    public String toString() {
        return name().replace('_', ' ');
    }

    public int getId() {
        return mId;
    }

    public String getPowerType() {
        return mPowerType;
    }
}
