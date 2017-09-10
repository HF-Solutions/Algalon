package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static org.alcha.algalona.models.wow.characters.WoWCharacterField.Name.Feed;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * <p>Represents the feed for a particular character in WoW. The feed can contain multiple entries
 * of four types, a boss kill, achievement, loot, or criteria (for achievements).</p>
 *
 * <p>Pass the {@link #newInstanceFromJson(JsonArray)} method the JsonArray from the Character
 * Profile API and it will return a {@link WoWCharacterFeed} object with all the feed entries
 * added.</p>
 */
public class WoWCharacterFeed extends WoWCharacterField {
    private List<WoWCharacterFeedEntry> mFeedList;

    private WoWCharacterFeed() {
        setFieldName(Feed);
        mFeedList = new ArrayList<>();
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

    public void addFeedEntry(WoWCharacterFeedEntry feedEntry) {
        mFeedList.add(feedEntry);
    }

    public void insertFeedEntry(int location, WoWCharacterFeedEntry feedEntry) {
        mFeedList.add(location, feedEntry);
    }

    public WoWCharacterFeedEntry getFeedEntry(int index) {
        return mFeedList.get(index);
    }

    public void addFeedEntries(List<WoWCharacterFeedEntry> feedEntries) {
        mFeedList.addAll(feedEntries);
    }

    public List<WoWCharacterFeedEntry> getFeedEntries() {
        return mFeedList;
    }
}
