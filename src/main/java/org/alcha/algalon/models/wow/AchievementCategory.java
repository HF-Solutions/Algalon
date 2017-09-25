package org.alcha.algalon.models.wow;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 21:56.</p>
 */

public class AchievementCategory {
    private int mId;
    private String mName;
    private List<Achievement> mAchievements;

    public AchievementCategory() {
    }

    public static AchievementCategory newInstanceFromJson(JsonObject jsonObject) {
        AchievementCategory category = new AchievementCategory();

        if (jsonObject.has("id"))
            category.setId(jsonObject.get("id").getAsInt());
        else category.setId(-1);

        if (jsonObject.has("name"))
            category.setName(jsonObject.get("name").getAsString());
        else category.setName("");

        if (jsonObject.has("achievements"))
            category.setAchievements(Achievement.parseJsonArray(jsonObject.getAsJsonArray("achievements")));
        else category.setAchievements(new ArrayList<Achievement>());

        return category;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Achievement> getAchievements() {
        return mAchievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        mAchievements = achievements;
    }
}
