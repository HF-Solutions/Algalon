package org.alcha.algalona.models.wow.battlegroups;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 * Interface that represents a Battlegroup in WoW. Since there's a separate list for EU and US, each
 * one has overlapping names. Instead of using one giant enum and then trying to figure out which
 * belongs where, this interface is the middleman for {@link WoWUSBattlegroups} and
 * {@link WoWEUBattlegroups}.
 */
public interface WoWBattlegroup {
    /** Returns the slug to be used for URL request fields **/
    String getSlug();

    /** Returns the relative URL to be used for URL request parameters **/
    String getRelativeUrl();
}
