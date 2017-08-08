package org.alcha.algalona.models.wow;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.TimeZone;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWServerRealm {
    private static final String LOG_TAG = WoWServerRealm.class.getSimpleName();
    private String[] mConnectedRealms;
    private String mBattlegroup;

    private enum Population {
        High,
        Medium,
        Low,
        Full,
        Undefined
    }

    private Population mPopulation;
    private TimeZone mTimezone;
    private boolean mStatus;
    private boolean mQueue;
    private String mLocale;
    private String mServerName;
    private String mType;

    public WoWServerRealm() {
    }

    public WoWServerRealm(String serverName) {
        mServerName = serverName;
    }

    public WoWServerRealm(JSONObject realmData) {
        try {
            JSONArray connectedRealms = realmData.getJSONArray("connected_realms");
            for (int x = 0; x < connectedRealms.length(); x++) {
                System.out.println(connectedRealms);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        if (mServerName.length() > 0 && mBattlegroup.length() > 0)
            return mServerName + " - " + mBattlegroup + " - " + mPopulation;
        else
            return "";
    }

    public static WoWServerRealm[] convertJSONArray(JSONArray array) {
        WoWServerRealm[] tempRealms = new WoWServerRealm[array.length()];

        try {
            for (int x = 0; x < array.length(); x++) {
                JSONObject realmObj = array.getJSONObject(x);
                WoWServerRealm realm = new WoWServerRealm(realmObj.getString("name"));

                realm.setBattlegroup(realmObj.getString("battlegroup"));
                realm.setType(realmObj.getString("type"));
                realm.setQueue(Boolean.getBoolean(realmObj.getString("queue")));
                realm.setStatus(Boolean.getBoolean(realmObj.getString("status")));
                realm.setLocale(realmObj.getString("locale"));
                realm.setConnectedRealms(realmObj.getJSONArray("connected_realms"));
                realm.setPopulation(realmObj.getString("population"));
                realm.setTimezone(TimeZone.getTimeZone(realmObj.getString("timezone")));

                tempRealms[x] = realm;
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return tempRealms;
    }

    public String formatConnectedRealms() {
        String tempString = "";

        for (int x = 0; x < mConnectedRealms.length; x++) {
            tempString += "- " + mConnectedRealms[x] + " ";
        }

        return tempString;
    }

    public String[] getConnectedRealms() {
        return mConnectedRealms;
    }

    public void setConnectedRealms(JSONArray array) {
        mConnectedRealms = new String[array.length()];

        for (int x = 0; x < array.length(); x++) {
            try {
                String input = array.getString(x);
                String serverName = cleanServerName(input);

                mConnectedRealms[x] = serverName;
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setConnectedRealms(String[] connectedRealms) {
        if (connectedRealms != null) {
            mConnectedRealms = connectedRealms;
        }
    }

    private String cleanServerName(String input) {
        String temp = input.substring(0, 1).toUpperCase() + input.substring(1);
        int hyphenLoc = temp.indexOf('-');

        while (hyphenLoc > -1) {
            temp = temp.substring(0, hyphenLoc + 1) + temp.substring(hyphenLoc + 1, hyphenLoc + 2).toUpperCase() + temp.substring(hyphenLoc + 2);
            hyphenLoc = temp.indexOf('-', hyphenLoc + 1);
        }

        if (temp.contains("-")) {
            temp = temp.replace("-", " ");
        }

        return temp;
    }

    public String getBattlegroup() {
        return mBattlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        mBattlegroup = battlegroup;
    }

    public Population getPopulation() {
        return mPopulation;
    }

    public void setPopulation(String population) {
        switch (population.toLowerCase()) {
            case "low": {
                mPopulation = Population.Low;
                break;
            }
            case "medium": {
                mPopulation = Population.Medium;
                break;
            }
            case "high": {
                mPopulation = Population.High;
                break;
            }
            case "full": {
                mPopulation = Population.Full;
                break;
            }
            case "n/a": {
                mPopulation = Population.Undefined;
                break;
            }
            default: {
                System.out.println("Do wut? " + population);
                break;
            }
        }
    }

    public TimeZone getTimezone() {
        return mTimezone;
    }

    public void setTimezone(TimeZone timezone) {
        mTimezone = timezone;
    }

    public boolean isStatus() {
        return mStatus;
    }

    public void setStatus(boolean status) {
        mStatus = status;
    }

    public boolean ismQueue() {
        return mQueue;
    }

    public void setQueue(boolean queue) {
        mQueue = queue;
    }

    public String getLocale() {
        return mLocale;
    }

    public void setLocale(String locale) {
        mLocale = locale;
    }

    public String getServerName() {
        return mServerName;
    }

    public void setServerName(String serverName) {
        mServerName = serverName;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
