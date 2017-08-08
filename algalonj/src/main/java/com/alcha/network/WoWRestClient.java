package com.alcha.network;
import org.asynchttpclient.*;

/**
 * Created by Alcha on 8/1/2017.
 */

public class WoWRestClient {
    private String mApiKey;
    private String mLocale = "en-US";
    private String mRegion = "us";
    private String mBaseUrl = "https://" + mRegion + ".api.battle.net/";

    private AsyncHttpClient mClient = new DefaultAsyncHttpClient();

    public WoWRestClient(String apiKey) {
        mApiKey = apiKey;
    }

    public void get(String url, AsyncCompletionHandler<Response> responseHandler) {
        mClient.prepareGet(url).execute(responseHandler);
    }

    public void getAchievement(int achievementId, AsyncCompletionHandler<Response> responseHandler) {
        try {
            String newUrl = mBaseUrl + "wow/achievement/" + achievementId + "?locale=" + mLocale + "&apikey=" + mApiKey;
            System.out.println("newUrl = " + newUrl);
            mClient.prepareGet(newUrl).execute(responseHandler);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public WoWRestClient(String apiKey, String locale, String region) {
        mApiKey = apiKey;
    }

    public void getRealmList() {
        String url = getAbsoluteUrl("wow/realm/status?locale=" + mLocale + "&apikey=" + mApiKey);
        System.out.println(url);
    }

    public void getCharacter() {
    }

    private String getAbsoluteUrl(String relativeUrl) {
        return mBaseUrl + relativeUrl;
    }
}
