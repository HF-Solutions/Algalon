package org.alcha.algalona.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/11/2017.</p>
 */

public class AuctionIndex {
    private String mUrl;
    private long mLastModified;

    private AuctionIndex() {}

    public static AuctionIndex newInstanceFromJson(JsonObject jsonObject) {
        AuctionIndex auctionIndex = new AuctionIndex();
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
