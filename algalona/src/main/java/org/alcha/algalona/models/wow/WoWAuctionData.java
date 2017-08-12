package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.realms.WoWEURealms;
import org.alcha.algalona.models.wow.realms.WoWRealm;
import org.alcha.algalona.models.wow.realms.WoWUSRealms;

import static org.alcha.algalona.network.AlgalonClient.getClientRegion;

/**
 * <p>Created by Alcha on 8/10/2017.</p>
 */
public class WoWAuctionData {
    private WoWRealm[] wowRealms;

    private WoWAuctionData() {
        ;
    }

    public static WoWAuctionData newInstanceFromJson(JsonObject jsonObject) {
        WoWAuctionData auctionData = new WoWAuctionData();

        auctionData.setWowRealms(parseWoWRealms(jsonObject));

        return auctionData;
    }

    private static WoWRealm[] parseWoWRealms(JsonObject jsonObject) {
        JsonArray realmArray = jsonObject.get("realms").getAsJsonArray();
        Region region = getClientRegion();

        if (region == Region.US) {
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
        }

        return new WoWRealm[0];
    }

    void setWowRealms(WoWRealm[] realms) {
        wowRealms = realms;
    }

    public WoWRealm[] getWowRealms() {
        return wowRealms;
    }
}
