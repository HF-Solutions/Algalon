package org.alcha.algalona.network;

import java.util.Locale;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

public interface GameRequest {
     enum Game {
        WoW,
        D3,
        SC2;

        @Override
        public String toString() {
            return name().toLowerCase(Locale.US);
        }

        public String getSlug() { return "/" + name(); }
    }

    String getRelativeUrl();
}
