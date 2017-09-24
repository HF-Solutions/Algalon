package org.alcha.algalonj.network;

import org.alcha.algalona.interfaces.APIRequest;
import org.alcha.algalona.interfaces.RequestCallback;
import org.alcha.algalona.models.wow.Locale;
import org.alcha.algalona.models.wow.Region;

import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;


/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class AlgalonClient {
    private static final String LOG_TAG = "AlgalonClient";
    private static String mApiKey;
    private static Locale mLocale = Locale.en_US;
    private static Region mRegion = Region.US;
    private static String mBaseUrl = "https://" + mRegion + ".api.battle.net";
    private HttpUrl.Builder mUrlBuilder;
    private OkHttpClient mClient;
    private static boolean mInitialized = false;

    private AlgalonClient(String apiKey, Locale locale, Region region) {
        mApiKey = apiKey;
        mLocale = locale;
        mRegion = region;
        mInitialized = true;
        mClient = new OkHttpClient();
    }

    public static AlgalonClient newInstance(String apiKey, Locale locale, Region region) {
        return new AlgalonClient(apiKey, locale, region);
    }

    public static AlgalonClient newUSInstance(String apiKey) {
        return new AlgalonClient(apiKey, Locale.en_US, Region.US);
    }

    public void executeRequest(APIRequest request, RequestCallback requestCallback) {
        if (request instanceof WoWCommunityRequest) {

            get(getAbsoluteUrl(request.getRelativeUrl()), requestCallback);
        }
    }

    public void executeRequests(APIRequest[] requests, RequestCallback requestCallback) {
        for (APIRequest request : requests) {
            if (request instanceof WoWCommunityRequest) {
                get(getAbsoluteUrl(request.getRelativeUrl()), requestCallback);
            }
        }
    }

    public static void get(String strUrl, RequestCallback requestCallback) {
        URL url = null;
        try {
            url = new URL(strUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new ApiCall(requestCallback).execute(url);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        if (relativeUrl.contains("?"))
            return mBaseUrl + relativeUrl + "&locale=" + mLocale + "&apikey=" + mApiKey;
        else
            return mBaseUrl + relativeUrl + "?locale=" + mLocale + "&apikey=" + mApiKey;
    }

    public static Region getClientRegion() {
        return mRegion;
    }

    public boolean isInitialized() {
        return mInitialized;
    }
}
