package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWRewardItem {
    private static final String LOG_TAG = "WoWRewardItem";
    private String[] bonusLists,
            stats,
            artifactTraits,
            relics,
            appearance;
    private String name,
            icon,
            context;
    private int id,
            artifactId,
            quality,
            itemLevel,
            armor,
            displayInfoId,
            artifactAppearanceId;

    @Override
    public String toString() {
        return "id = " + id + "; name = " + name + "; itemLevel = " + itemLevel;
    }

    public String[] getBonusLists() {
        return bonusLists;
    }

    void setBonusLists(String[] bonusLists) {
        this.bonusLists = bonusLists;
    }

    public String[] getStats() {
        return stats;
    }

    void setStats(String[] stats) {
        this.stats = stats;
    }

    public String[] getArtifactTraits() {
        return artifactTraits;
    }

    void setArtifactTraits(String[] artifactTraits) {
        this.artifactTraits = artifactTraits;
    }

    public String[] getRelics() {
        return relics;
    }

    void setRelics(String[] relics) {
        this.relics = relics;
    }

    public String[] getAppearance() {
        return appearance;
    }

    void setAppearance(String[] appearance) {
        this.appearance = appearance;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContext() {
        return context;
    }

    void setContext(String context) {
        this.context = context;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public int getArtifactId() {
        return artifactId;
    }

    void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    public int getQuality() {
        return quality;
    }

    void setQuality(int quality) {
        this.quality = quality;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public int getArmor() {
        return armor;
    }

    void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public int getArtifactAppearanceId() {
        return artifactAppearanceId;
    }

    void setArtifactAppearanceId(int artifactAppearanceId) {
        this.artifactAppearanceId = artifactAppearanceId;
    }

    public static WoWRewardItem newInstanceFromJson(JsonElement element) {
        WoWRewardItem rewardItem = new WoWRewardItem();
        JsonObject jsonObject = element.getAsJsonObject();

        if (jsonObject.has("id"))
            rewardItem.setId(jsonObject.get("id").getAsInt());

        if (jsonObject.has("name"))
            rewardItem.setName(jsonObject.get("name").getAsString());

        if (jsonObject.has("icon"))
            rewardItem.setIcon(jsonObject.get("icon").getAsString());

        if (jsonObject.has("quality"))
            rewardItem.setQuality(jsonObject.get("quality").getAsInt());

        if (jsonObject.has("itemLevel"))
            rewardItem.setItemLevel(jsonObject.get("itemLevel").getAsInt());

        if (jsonObject.has("stats") && jsonObject.get("stats").getAsJsonArray().size() > 0)
            rewardItem.setStats(jsonObject.get("stats").getAsString().split(","));

        if (jsonObject.has("armor"))
            rewardItem.setArmor(jsonObject.get("armor").getAsInt());

        if (jsonObject.has("context"))
            rewardItem.setContext(jsonObject.get("context").getAsString());

        if (jsonObject.has("bonusLists") && jsonObject.get("bonusLists").getAsJsonArray().size() > 0)
            rewardItem.setBonusLists(jsonObject.get("bonusLists").getAsString().split(","));

        if (jsonObject.has("artifactId"))
            rewardItem.setArtifactId(jsonObject.get("artifactId").getAsInt());

        if (jsonObject.has("displayInfoId"))
            rewardItem.setDisplayInfoId(jsonObject.get("displayInfoId").getAsInt());

        if (jsonObject.has("artifactAppearanceId"))
            rewardItem.setArtifactAppearanceId(jsonObject.get("artifactAppearanceId").getAsInt());

        if (jsonObject.has("artifactTraits") && jsonObject.get("artifactTraits").getAsJsonArray().size() > 0)
            rewardItem.setArtifactTraits(jsonObject.get("artifactTraits").getAsString().split(","));

        if (jsonObject.has("relics") && jsonObject.get("relics").getAsJsonArray().size() > 0)
            rewardItem.setRelics(jsonObject.get("relics").getAsString().split(","));

        if (jsonObject.has("appearance") && jsonObject.get("appearance").getAsJsonObject().size() > 0)
            rewardItem.setAppearance(jsonObject.get("appearance").getAsString().split(","));

        return rewardItem;
    }

    public static WoWRewardItem[] parseRewardItems(JsonArray rewardItems) {
        WoWRewardItem[] tempArray = new WoWRewardItem[rewardItems.size()];

        for (int x = 0; x < rewardItems.size(); x++) {
            WoWRewardItem tempItem = newInstanceFromJson(rewardItems.get(x));
            tempArray[x] = tempItem;
        }

        return tempArray;
    }
}
