package org.alcha.algalona.models.wow.characters;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeed extends WoWCharacterField {
    private HashMap<Integer, WoWCharacterFeedEntry> mFeedMap;

    private WoWCharacterFeed() {
        setFieldType(Type.Feed);
    }

    public static WoWCharacterFeed newInstance() {
        return new WoWCharacterFeed();
    }

    public static WoWCharacterFeed newInstanceFromJSON(JSONObject jsonObject) {
        WoWCharacterFeed characterFeed = new WoWCharacterFeed();

        return characterFeed;
    }

    public void addFeedEntry(WoWCharacterFeedEntry feedEntry) {
        int key = mFeedMap.size();
        mFeedMap.put(key, feedEntry);
    }

    public void insertFeedEntry(int location, WoWCharacterFeedEntry feedEntry) {

    }
}
