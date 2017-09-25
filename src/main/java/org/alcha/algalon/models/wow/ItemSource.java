package org.alcha.algalon.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 13, 2017 @ 01:16.</p>
 */

public class ItemSource {
    private int mSourceId;
    private String mSourceType;

    public ItemSource() {

    }

    public static ItemSource newInstanceFromJson(JsonObject jsonObject) {
        ItemSource source = new ItemSource();

        if(jsonObject.has("sourceId"))
            source.setSourceId(jsonObject.get("sourceId").getAsInt());
        else source.setSourceId(-1);

        if(jsonObject.has("sourceType"))
            source.setSourceType(jsonObject.get("sourceType").getAsString());
        else source.setSourceType("");

        return source;
    }

    public String getSourceType() {
        return mSourceType;
    }

    public void setSourceType(String sourceType) {
        mSourceType = sourceType;
    }

    public int getSourceId() {
        return mSourceId;
    }

    public void setSourceId(int sourceId) {
        mSourceId = sourceId;
    }
}
