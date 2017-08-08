package org.alcha.algalona.network;

import org.alcha.algalona.interfaces.OnTaskCompleted;
import org.json.JSONObject;

/**
 * <p>Created by Alcha on 8/6/2017.</p>
 */

public abstract class Callback implements OnTaskCompleted {
    @Override
    public void onTaskCompleted(JSONObject result) {

    }
}
