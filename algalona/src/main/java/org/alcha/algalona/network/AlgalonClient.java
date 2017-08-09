package org.alcha.algalona.network;

import android.util.Log;

import org.alcha.algalona.models.wow.Locale;
import org.alcha.algalona.models.wow.Region;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class AlgalonClient {
    private static final String LOG_TAG = "AlgalonClient";
    private String mApiKey;
    private Locale mLocale = Locale.en_US;
    private Region mRegion = Region.US;
    private String mBaseUrl = "https://" + mRegion + ".api.battle.net";

    private AlgalonClient(String apiKey, Locale locale, Region region) {
        mApiKey = apiKey;
        mLocale = locale;
        mRegion = region;
    }

    public static AlgalonClient newInstance(String apiKey, Locale locale, Region region) {
        return new AlgalonClient(apiKey, locale, region);
    }

    public static AlgalonClient newUSInstance(String apiKey) {
        return new AlgalonClient(apiKey, Locale.en_US, Region.US);
    }

    public void executeRequest(GameRequest request, Callback callback) {
        get(getAbsoluteUrl(request.getRelativeUrl()), callback);
    }

    public void executeRequests(GameRequest[] requests, Callback callback) {
        for (GameRequest request : requests) {
            get(getAbsoluteUrl(request.getRelativeUrl()), callback);
        }
    }

    public static void get(String strUrl, Callback callback) {
        URL url = null;
        try {
            Log.d(LOG_TAG, "get: url = " + strUrl);
            url = new URL(strUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new ApiCall(callback).execute(url);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        if (relativeUrl.contains("?"))
            return mBaseUrl + relativeUrl + "&locale=" + mLocale + "&apikey=" + mApiKey;
        else
            return mBaseUrl + relativeUrl + "?locale=" + mLocale + "&apikey=" + mApiKey;
    }
}
