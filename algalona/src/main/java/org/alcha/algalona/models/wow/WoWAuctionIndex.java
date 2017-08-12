package org.alcha.algalona.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/11/2017.</p>
 */

public class WoWAuctionIndex {
    private String mUrl;
    private long mLastModified;

    private WoWAuctionIndex() {}

    public static WoWAuctionIndex newInstanceFromJson(JsonObject jsonObject) {
        WoWAuctionIndex auctionIndex = new WoWAuctionIndex();
        jsonObject = jsonObject.get("files").getAsJsonArray().get(0).getAsJsonObject();

        auctionIndex.setUrl(jsonObject.get("url").getAsString());
        auctionIndex.setLastModified(jsonObject.get("lastModified").getAsLong());

        return auctionIndex;
    }

    public String getUrl() {
        return mUrl;
    }

    void setUrl(String url) {
        mUrl = url;
    }

    public long getLastModified() {
        return mLastModified;
    }

    void setLastModified(long lastModified) {
        mLastModified = lastModified;
    }
}
