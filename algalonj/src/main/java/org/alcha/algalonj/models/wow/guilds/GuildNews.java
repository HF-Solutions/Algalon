package org.alcha.algalonj.models.wow.guilds;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 06:36.</p>
 */

public class GuildNews extends GuildField {
    private List<GuildNewsEntry> mNewsEntries;

    public GuildNews() {
        setFieldName(Name.NEWS);
        mNewsEntries = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Amount of news entries: " + getNewsEntries().size();
    }

    public static GuildNews newInstanceFromJson(JsonArray jsonArray) {
        GuildNews news = new GuildNews();
        List<GuildNewsEntry> tempList = new ArrayList<>();

        for (JsonElement element : jsonArray) {
            JsonObject object = element.getAsJsonObject();
            if (object.has("type")) {
                switch (object.get("type").getAsString()) {
                    case "itemCraft":
                        tempList.add(GuildItemCraft.newInstanceFromJson(object));
                        break;

                    case "itemLoot":
                        tempList.add(GuildItemLoot.newInstanceFromJson(object));
                        break;

                    case "itemPurchase":
                        tempList.add(GuildItemPurchase.newInstanceFromJson(object));
                        break;

                    case "guildAchievement":
                        tempList.add(GuildAchievement.newInstanceFromJson(object));
                        break;

                    case "playerAchievement":
                        tempList.add(GuildPlayerAchievement.newInstanceFromJson(object));
                        break;
                }
            }
        }

        news.setNewsEntries(tempList);

        return news;
    }

    public List<GuildNewsEntry> getNewsEntries() {
        return mNewsEntries;
    }

    public void setNewsEntries(List<GuildNewsEntry> newsEntries) {
        mNewsEntries = newsEntries;
    }
}
