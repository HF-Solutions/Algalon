package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public enum Region {
    US,
    EU,
    KR,
    TW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
