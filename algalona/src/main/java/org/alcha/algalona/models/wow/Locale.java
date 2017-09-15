package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * Represents the various locales available for the Battle.net API. This enum is primarily used to
 * help build the base URL used for all requests and provide type safety.
 */
public enum Locale {
    en_US,
    pt_BR,
    es_MX,
    zh_TW,
    ko_KR,
    en_GB,
    de_DE,
    es_ES,
    fr_FR,
    it_IT,
    pl_PL,
    pt_PT,
    ru_RU;

    public static Locale fromString(String name) {
        for (Locale locale : Locale.values()) {
            if (locale.name().equalsIgnoreCase(name)) return locale;
        }

        return Locale.en_US;
    }
}
