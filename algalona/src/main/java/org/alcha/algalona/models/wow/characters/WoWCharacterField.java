package org.alcha.algalona.models.wow.characters;

import org.alcha.algalona.interfaces.FieldName;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * Represents a WoWCharacterField within a {@link WoWCharacter}
 */
public abstract class WoWCharacterField {
    private static final String LOG_TAG = "WoWCharacterField";

    public enum Name implements FieldName {
        Achievements,
        Appearance,
        Feed,
        Guild,
        Hunter_Pets,
        Items,
        Mounts,
        Pets,
        Pet_Slots,
        Professions,
        Progression,
        PvP,
        Quests,
        Reputation,
        Statistics,
        Stats,
        Talents,
        Titles,
        Audit;

        @Override
        public String getSlug() {
            return name().substring(0, 1).toLowerCase() + name().substring(1).replace("_", "");
        }

        @Override
        public String toString() {
            return name().replace('_', ' ');
        }
    }

    private Name mFieldName;

    void setFieldName(Name fieldName) {
        mFieldName = fieldName;
    }

    public Name getFieldName() {
        return mFieldName;
    }
}
