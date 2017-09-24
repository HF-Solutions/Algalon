package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static org.alcha.algalonj.models.wow.characters.CharacterField.Name.Feed;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * <p>Represents the feed for a particular character in WoW. The feed can contain multiple entries
 * of four types, a boss kill, achievement, loot, or criteria (for achievements).</p>
 *
 * <p>Pass the {@link #newInstanceFromJson(JsonArray)} method the JsonArray from the Character
 * Profile API and it will return a {@link CharacterFeed} object with all the feed entries
 * added.</p>
 */
public class CharacterFeed extends CharacterField {
    private List<CharacterFeedEntry> mFeedList;

    public CharacterFeed() {
        setFieldName(Feed);
        mFeedList = new ArrayList<>();
    }

    public static CharacterFeed newInstanceFromJson(JsonArray jsonArray) {
        CharacterFeed characterFeed = new CharacterFeed();

        for (int x = 0; x < jsonArray.size(); x++) {
            JsonObject jsonObject = jsonArray.get(x).getAsJsonObject();

            switch (jsonObject.get("type").getAsString()) {
                case "ACHIEVEMENT":
                    characterFeed.addFeedEntry(CharacterFeedAchievement.newInstanceFromJson(jsonObject));
                    break;

                case "CRITERIA":
                    characterFeed.addFeedEntry(CharacterFeedCriteria.newInstanceFromJson(jsonObject));
                    break;

                case "BOSSKILL":
                    characterFeed.addFeedEntry(CharacterFeedBossKill.newInstanceFromJson(jsonObject));
                    break;

                case "LOOT":
                    CharacterFeedLoot feedLoot = CharacterFeedLoot.newInstanceFromJson(jsonObject);

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

    public void addFeedEntry(CharacterFeedEntry feedEntry) {
        mFeedList.add(feedEntry);
    }

    public CharacterFeedEntry getFeedEntry(int index) {
        return mFeedList.get(index);
    }

    public List<CharacterFeedEntry> getFeedEntries() {
        return mFeedList;
    }
}
