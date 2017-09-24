package org.alcha.algalonj.network;


import org.alcha.algalonj.interfaces.RequestCallback;

import java.util.concurrent.Callable;

/**
 * <p>Created by Alcha on 8/5/2017.</p>
 */
public class ApiCall implements Callable<RequestCallback> {
    private static final String LOG_TAG = "ApiCall";
    private RequestCallback mListener;

    @Override
    public RequestCallback call() throws Exception {
        return null;
    }
}
