package org.alcha.algalon.interfaces;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 *
 * <p>Generic interface object used in conjunction with an {@link
 * org.alcha.algalon.network.AlgalonClient} to make a request to the Battle.net API.</p>
 */
public interface APIRequest {
    /** Get the relative URL used for making an API request */
    String getRelativeUrl();
}
