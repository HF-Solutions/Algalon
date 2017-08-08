package org.alcha.algalona.network;

import org.alcha.algalona.models.wow.WoWLocale;
import org.alcha.algalona.models.wow.WoWRegion;
import org.alcha.algalona.models.wow.characters.WoWCharacterField;
import org.alcha.algalona.models.wow.realms.WoWRealms;

import java.net.MalformedURLException;
import java.net.URL;

import static org.alcha.algalona.models.wow.characters.WoWCharacterField.slugifyFields;


/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class AlgalonClient {
    private static final String LOG_TAG = AlgalonClient.class.getSimpleName();
    private String mApiKey;
    private WoWLocale mLocale = WoWLocale.en_US;
    private WoWRegion mRegion = WoWRegion.US;
    private String mBaseUrl = "https://" + mRegion + ".api.battle.net";

    private AlgalonClient(String apiKey, WoWLocale locale, WoWRegion region) {
        mApiKey = apiKey;
        mLocale = locale;
        mRegion = region;
    }

    public static AlgalonClient newInstance(String apiKey, WoWLocale locale, WoWRegion region) {
        return new AlgalonClient(apiKey, locale, region);
    }

    public static AlgalonClient newUSInstance(String apiKey) {
        return new AlgalonClient(apiKey, WoWLocale.en_US, WoWRegion.US);
    }

    public void get(String strUrl, Callback callback) {
        URL url = null;
        try {
            url = new URL(strUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new ApiCall(callback).execute(url);
    }

    public void getCharacterProfileJSON(WoWRealms realmName, String characterName, Callback callback) {
        get(getAbsoluteUrl("/wow/character/" + realmName.getSlug() + "/" + characterName), callback);
    }

    public void getAchievementJSON(int achievementId, Callback callback) {
        get(getAbsoluteUrl("/wow/achievement/" + achievementId), callback);
    }

    public void getAuctionDataStatus(WoWRealms realmName, Callback callback) {
        get(getAbsoluteUrl("/wow/auction/data/" + realmName.getSlug()), callback);
    }

    public void getBossMasterListJSON(Callback callback) {
        get(getAbsoluteUrl("/wow/boss/"), callback);
    }

    public void getBossJSON(int bossId, Callback callback) {
        get(getAbsoluteUrl("/wow/boss/" + bossId), callback);
    }

    public void getRealmChallengeLeaderboardJSON(WoWRealms realmName, Callback callback) {
        get(getAbsoluteUrl("/wow/challenge/" + realmName.getSlug()), callback);
    }

    public void getRegionChallengeLeaderboardJSON(Callback callback) {
        get(getAbsoluteUrl("/wow/challenge/" + mRegion), callback);
    }

    public void getCharacterAchievementsJSON(WoWRealms realmName, String characterName, Callback callback) {
        get(getAbsoluteUrl("/wow/character/" + realmName.getSlug() + "/" + characterName + "?fields=achievements"), callback);
    }

    public void getCharacterFieldsJSON(WoWRealms realmName, String characterName, WoWCharacterField.Type[] fields, Callback callback) {
        get(getAbsoluteUrl("/wow/character/" + realmName.getSlug() + "/" + characterName + "?fields=" + slugifyFields(fields)), callback);
    }

    private static String slugifyString(String str) {
        return str.toLowerCase().replace(" ", "%20");
    }

    private String getAbsoluteUrl(String relativeUrl) {
        if (relativeUrl.contains("?"))
            return mBaseUrl + relativeUrl + "&locale=" + mLocale + "&apikey=" + mApiKey;
        else
            return mBaseUrl + relativeUrl + "?locale=" + mLocale + "&apikey=" + mApiKey;
    }

    /*private AsyncHttpClient mClient = new AsyncHttpClient();

    public AlgalonClient(String apiKey) {
        mApiKey = apiKey;
    }

    public AlgalonClient(String apiKey, WoWLocale locale, WoWRegion region) {
        mRegion = region;
        mLocale = locale;
        mApiKey = apiKey;
    }

    public void get(String url, AsyncHttpResponseHandler responseHandler) {
        mClient.get(url, responseHandler);
    }

    public void getAchievementJSON(int achievementId, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/achievement/" + achievementId), responseHandler);
    }

    public void getAuctionDataStatus(WoWRealms realmName, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/auction/data/" + realmName.getSlug()), responseHandler);
    }

    public void getBossMasterListJSON(AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/boss/"), responseHandler);
    }

    public void getBossJSON(int bossId, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/boss/" + bossId), responseHandler);
    }

    public void getRealmChallengeLeaderboardJSON(WoWRealms realmName, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/challenge/" + realmName.getSlug()), responseHandler);
    }

    public void getRegionChallengeLeaderboardJSON(AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/challenge/" + mRegion), responseHandler);
    }

    public void getCharacterProfileJSON(WoWRealms realmName, String characterName, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/character/" + realmName.getSlug() + "/" + characterName), responseHandler);
    }

    public void getCharacterAchievementsJSON(WoWRealms realmName, String characterName, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/character/" + realmName.getSlug() + "/" + characterName + "?fields=achievements"), responseHandler);
    }

    public void getCharacterFieldsJSON(WoWRealms realmName, String characterName, WoWCharacterField.Type[] fields, AsyncHttpResponseHandler responseHandler) {
        mClient.get(getAbsoluteUrl("/wow/character/" + realmName.getSlug() + "/" + characterName + "?fields=" + slugifyFields(fields)), responseHandler);
    }

    private static String slugifyString(String str) {
        return str.toLowerCase().replace(" ", "%20");
    }

    public void getRealmList() {
        String url = getAbsoluteUrl("/wow/realm/status");
        System.out.println(url);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        if (relativeUrl.contains("?"))
            return mBaseUrl + relativeUrl + "&locale=" + mLocale + "&apikey=" + mApiKey;
        else
            return mBaseUrl + relativeUrl + "?locale=" + mLocale + "&apikey=" + mApiKey;
    }*/
}
