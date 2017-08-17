package org.alcha.algalona.network;

import org.alcha.algalona.models.wow.Locale;
import org.alcha.algalona.models.wow.Region;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class AlgalonClient {
    private static final String LOG_TAG = "AlgalonClient";
    private static String mApiKey;
    private static String mClientSecret;
    private static OAuthToken mAuthToken;
    private static Locale mLocale = Locale.en_US;
    private static Region mRegion = Region.US;
    private static String mBaseUrl = "https://" + mRegion + ".api.battle.net";

    private AlgalonClient(String apiKey, String clientSecret, Locale locale, Region region) {
        mApiKey = apiKey;
        mLocale = locale;
        mRegion = region;
    }

    public static AlgalonClient newInstance(String apiKey, String clientSecret, Locale locale, Region region) {
        return new AlgalonClient(apiKey, clientSecret, locale, region);
    }

    public static AlgalonClient newUSInstance(String apiKey, String clientSecret) {
        return new AlgalonClient(apiKey, clientSecret, Locale.en_US, Region.US);
    }

    public static AlgalonClient newUSInstance(String apiKey) {
        return new AlgalonClient(apiKey, null, Locale.en_US, Region.US);
    }

    private static String generateOAuthUrl(String apiKey, String clientSecret) {
        String url = "https://" + mRegion.toString() + ".battle.net/oauth/token";
        url += "?grant_type=client_credentials&client_id=" + apiKey;
        url += "&client_secret=" + clientSecret;
        return url;
    }

    public void executeRequest(APIRequest request, Callback callback) {
        if (request instanceof WoWCommunityRequest) {
            get(getAbsoluteUrl(request.getRelativeUrl()), callback);
        }
    }

    public void executeRequests(APIRequest[] requests, Callback callback) {
        for (APIRequest request : requests) {
            if (request instanceof WoWCommunityRequest) {
                get(getAbsoluteUrl(request.getRelativeUrl()), callback);
            }
        }
    }

    public static void get(String strUrl, Callback callback) {
        URL url = null;
        try {
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

    public static Region getClientRegion() {
        return mRegion;
    }
}
