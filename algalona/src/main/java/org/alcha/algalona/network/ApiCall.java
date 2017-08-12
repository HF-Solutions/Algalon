package org.alcha.algalona.network;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonParser;

import org.alcha.algalona.interfaces.OnTaskCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>Created by Alcha on 8/5/2017.</p>
 */
public class ApiCall extends AsyncTask<URL, Object, String> {
    private static final String LOG_TAG = "ApiCall";
    private OnTaskCompleted mListener;

    public ApiCall(OnTaskCompleted listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(URL[] params) {
        StringBuilder resultBuilder = new StringBuilder();

        for (URL url : params) {
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
                Log.e(LOG_TAG, "doInBackground: MalformedURLException - ", e);
            } catch (IOException e) {
                Log.e(LOG_TAG, "doInBackground: IOException - ", e);
            }
            // if cancel() is called, leave the loop early
            if (isCancelled()) {
                break;
            }
        }

        // return the result
        return resultBuilder.toString();
    }

    @Override
    protected void onPostExecute(String str) {
        JsonParser parser = new JsonParser();
        mListener.onTaskCompleted(parser.parse(str).getAsJsonObject());
    }
}
