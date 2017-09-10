package org.alcha.algalona.interfaces;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/6/2017.</p>
 */

public interface RequestCallback {
    void onTaskCompleted(JsonObject response);
}
