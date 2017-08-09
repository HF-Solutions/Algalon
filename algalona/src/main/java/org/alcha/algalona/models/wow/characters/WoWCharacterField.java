package org.alcha.algalona.models.wow.characters;

import org.alcha.algalona.interfaces.FieldName;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterField {
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
            String temp = name().substring(0, 1).toLowerCase() + name().substring(1);
            return temp.replace("_", "");
        }

        @Override
        public String toString() {
            return super.toString().replace('_', ' ');
        }
    }

    private Name mFieldName;

    void setFieldName(Name fieldName) {
        mFieldName = fieldName;
    }

    Name getFieldName() {
        return mFieldName;
    }

    public static String slugifyFieldNames(WoWCharacterField.Name[] fieldNames) {
        String temp = "";

        for (WoWCharacterField.Name field : fieldNames) {
            temp += field.getSlug() + "%2C";
        }

        return temp;
    }
}
