package org.alcha.algalon.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/10/2017.</p>
 */
public class AuctionData {
    private Realm[] mWowRealms;

    private AuctionData() {

    }

    public static AuctionData newInstanceFromJson(JsonObject jsonObject) {
        AuctionData auctionData = new AuctionData();

        auctionData.setWowRealms(parseWoWRealms(jsonObject));

        return auctionData;
    }

    private static Realm[] parseWoWRealms(JsonObject jsonObject) {
        JsonArray realmArray = jsonObject.get("realms").getAsJsonArray();

        /*if (region == Region.US) {
            WoWUSRealms[] tempArray = new WoWUSRealms[realmArray.size()];
            for (int x = 0; x < realmArray.size(); x++) {
                tempArray[x] = WoWUSRealms.fromString(realmArray.get(x).getAsJsonObject().get("name").getAsString());
            }

            return tempArray;
        } else if (region == Region.EU) {
            WoWEURealms[] tempArray = new WoWEURealms[realmArray.size()];
            for (int x = 0; x < realmArray.size(); x++) {
                tempArray[x] = WoWEURealms.fromString(realmArray.get(x).getAsJsonObject().get("name").getAsString());
            }

            return tempArray;
        }*/

        return new Realm[0];
    }

    void setWowRealms(Realm[] realms) {
        mWowRealms = realms;
    }

    public Realm[] getWowRealms() {
        return mWowRealms;
    }
}
