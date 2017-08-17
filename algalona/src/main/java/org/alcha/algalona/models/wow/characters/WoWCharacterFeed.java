package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.TreeMap;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterFeed extends WoWCharacterField {
    private TreeMap<Integer, WoWCharacterFeedEntry> mFeedMap;

    private WoWCharacterFeed() {
        setFieldName(Name.Feed);
        mFeedMap = new TreeMap<>();
    }

    public static WoWCharacterFeed newInstance() {
        return new WoWCharacterFeed();
    }

    public static WoWCharacterFeed newInstanceFromJson(JsonArray jsonArray) {
        WoWCharacterFeed characterFeed = new WoWCharacterFeed();

        for (int x = 0; x < jsonArray.size(); x++) {
            JsonObject jsonObject = jsonArray.get(x).getAsJsonObject();

            switch (jsonObject.get("type").getAsString()) {
                case "ACHIEVEMENT":
                    WoWCharacterFeedAchievement feedAchievement = WoWCharacterFeedAchievement.newInstanceFromJson(jsonObject);

                    if (jsonObject.has("timestamp"))
                        feedAchievement.setTimestamp(jsonObject.get("timestamp").getAsLong());
                    if (jsonObject.has("featOfStrength"))
                        feedAchievement.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());
                    characterFeed.addFeedEntry(feedAchievement);
                    break;

                case "CRITERIA":
                    WoWCharacterFeedCriteria feedCriteria = WoWCharacterFeedCriteria.newInstanceFromJson(jsonObject);

                    if (jsonObject.has("timestamp"))
                        feedCriteria.setTimestamp(jsonObject.get("timestamp").getAsLong());
                    if (jsonObject.has("featOfStrength"))
                        feedCriteria.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());

                    characterFeed.addFeedEntry(feedCriteria);
                    break;

                case "BOSSKILL":
                    WoWCharacterFeedBossKill bossKill = WoWCharacterFeedBossKill.newInstanceFromJson(jsonObject);

                    if (jsonObject.has("timestamp"))
                        bossKill.setTimestamp(jsonObject.get("timestamp").getAsLong());
                    if (jsonObject.has("featOfStrength"))
                        bossKill.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());

                    characterFeed.addFeedEntry(bossKill);
                    break;

                case "LOOT":
                    WoWCharacterFeedLoot feedLoot = WoWCharacterFeedLoot.newInstanceFromJson(jsonObject);

                    if (jsonObject.has("timestamp"))
                        feedLoot.setTimestamp(jsonObject.get("timestamp").getAsLong());
                    if (jsonObject.has("featOfStrength"))
                        feedLoot.setFeatOfStrength(jsonObject.get("featOfStrength").getAsBoolean());

                    characterFeed.addFeedEntry(feedLoot);
                    break;
            }
        }

        return characterFeed;
    }

    void addFeedEntry(WoWCharacterFeedEntry feedEntry) {
        int key = mFeedMap.size();
        mFeedMap.put(key, feedEntry);
    }

    void insertFeedEntry(int location, WoWCharacterFeedEntry feedEntry) {
        mFeedMap.put(location, feedEntry);
    }
}
