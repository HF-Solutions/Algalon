package org.alcha.algalona.models.wow.characters;

import android.util.Log;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterField {
    private static final String LOG_TAG = "WoWCharacterField";

    public enum Type {
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
        PVP,
        Quests,
        Reputation,
        Statistics,
        Stats,
        Talents,
        Titles,
        Audit;

        public String getSlug() {
            String temp = super.toString().substring(0, 1).toLowerCase() + super.toString().substring(1);
            return temp.replace("_", "");
        }

        @Override
        public String toString() {
            return super.toString().replace('_', ' ');
        }
    }

    private Type mFieldType;

    void setFieldType(Type fieldType) {
        mFieldType = fieldType;
    }

    Type getFieldType() {
        return mFieldType;
    }

    public static String slugifyFields(WoWCharacterField.Type[] fields) {
        StringBuilder builder = new StringBuilder();

        for (WoWCharacterField.Type field : fields) {
            builder.append(field.getSlug());
            builder.append("%2C");
        }

        return builder.toString();
    }
}
