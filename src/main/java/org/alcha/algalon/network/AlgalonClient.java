package org.alcha.algalon.network;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.alcha.algalon.interfaces.APIRequest;
import org.alcha.algalon.interfaces.RequestCallback;
import org.alcha.algalon.models.wow.Locale;
import org.alcha.algalon.models.wow.Region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class AlgalonClient {
    private static final String LOG_TAG = "AlgalonClient";
    private String mApiKey;
    private Locale mLocale = Locale.en_US;
    private Region mRegion = Region.US;
    private String mBaseUrl = "https://" + mRegion + ".api.battle.net";
    private boolean mInitialized = false;
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    private AlgalonClient(String apiKey, Locale locale, Region region) {
        mApiKey = apiKey;
        mLocale = locale;
        mRegion = region;
        mInitialized = true;
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

    public void get(final String strUrl, final RequestCallback requestCallback) {
        mExecutor.submit(new Runnable() {
            @Override
            public void run() {
                URL url = getUrl(strUrl);
                StringBuilder resultBuilder = new StringBuilder();

                // TODO: Properly handle response, determine if an error occurred

                if (url != null) {
                    try {
                        // Read all the text returned by the server
                        InputStreamReader reader = new InputStreamReader(url.openStream());
                        BufferedReader in = new BufferedReader(reader);
                        String resultPiece;
                        while ((resultPiece = in.readLine()) != null) {
                            resultBuilder.append(resultPiece);
                        }
                        in.close();
                    } catch (MalformedURLException e) {
                        System.out.println("MalformedURLException...");
                        System.out.println(e.getLocalizedMessage());
                    } catch (IOException e) {
                        System.out.println("IOException...");
                        System.out.println(e.getLocalizedMessage());
                    }
                }

                requestCallback.onResult(parseStringToJson(resultBuilder.toString()));
            }
        });
    }

    private static JsonObject parseStringToJson(String text) {
        JsonParser parser = new JsonParser();

        if (parser.parse(text) instanceof JsonObject)
            return (parser.parse(text)).getAsJsonObject();
        else return new JsonObject();
    }

    private static URL getUrl(String strUrl) {
        try {
            return new URL(strUrl);
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException...");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    private String performRequest(URL url) {
        StringBuilder resultBuilder = new StringBuilder();

        try {
            // Read all the text returned by the server
            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(reader);
            String resultPiece;
            while ((resultPiece = in.readLine()) != null) {
                resultBuilder.append(resultPiece);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException...");
            System.out.println(e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("IOException...");
            System.out.println(e.getLocalizedMessage());
        }

        return resultBuilder.toString();
    }

    private String getAbsoluteUrl(String relativeUrl) {
        if (relativeUrl.contains("?"))
            return mBaseUrl + relativeUrl + "&locale=" + mLocale + "&apikey=" + mApiKey;
        else
            return mBaseUrl + relativeUrl + "?locale=" + mLocale + "&apikey=" + mApiKey;
    }

    public Region getClientRegion() {
        return mRegion;
    }

    public boolean isInitialized() {
        return mInitialized;
    }
}
