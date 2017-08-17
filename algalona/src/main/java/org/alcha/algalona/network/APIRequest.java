package org.alcha.algalona.network;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

interface APIRequest {
    enum Game {
        WoW,
        D3,
        SC2;

        @Override
        public String toString() {
            return name().toLowerCase();
        }

        public String getSlug() {
            return name().toLowerCase();
        }
    }

    String getRelativeUrl();
}
