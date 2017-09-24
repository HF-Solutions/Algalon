package org.alcha.algalonj.models.wow;

/**
 * <p>Created by Alcha on 8/9/2017.</p>
 */

public enum PvPBrackets {
    Two_on_Two("2v2"),
    Three_on_Three("3v3"),
    Five_on_Five("5v5"),
    Rated_Battlegroup("rbg");

    private String name;

    PvPBrackets(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.name().toLowerCase();
    }

    @Override
    public String toString() {
        return name().replace('_', ' ');
    }
}
