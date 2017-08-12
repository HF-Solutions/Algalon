package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

import java.util.HashMap;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeed extends WoWCharacterField {
    private HashMap<Integer, WoWCharacterFeedEntry> mFeedMap;

    private WoWCharacterFeed() {
        setFieldName(Name.Feed);
    }

    public static WoWCharacterFeed newInstance() {
        return new WoWCharacterFeed();
    }

    public static WoWCharacterFeed newInstanceFromJSON(JsonObject jsonObject) {
        WoWCharacterFeed characterFeed = new WoWCharacterFeed();

        return characterFeed;
    }

    void addFeedEntry(WoWCharacterFeedEntry feedEntry) {
        int key = mFeedMap.size();
        mFeedMap.put(key, feedEntry);
    }

    void insertFeedEntry(int location, WoWCharacterFeedEntry feedEntry) {

    }
}
