package org.alcha.algalona.models.wow;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static org.alcha.algalona.models.wow.Stat.parseJsonArray;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */
public class RewardItem extends Item implements Comparable<RewardItem> {
    private static final String LOG_TAG = "RewardItem";
    private List<TooltipParam> mTooltipParams;
    private List<Stat> mStats;
    private int mArmor;
    private String mContext;
    private int[] mBonusLists;
    private int mArtifactId;
    private int mDisplayInfoId;
    private int mArtifactAppearanceId;
    private int[] mArtifactTraits;
    private int[] mRelics;
    private List<Object> mAppearance;

    @Override
    public String toString() {
        return "id = " + getId() + "; name = " + getName() + "; itemLevel = " + getItemLevel();
    }

    @Override
    public int compareTo(@NonNull RewardItem rewardItem) {
        if (rewardItem.getId() > getId()) return 1;
        else if (rewardItem.getId() < getId()) return -1;
        else return 0;
    }

    public static RewardItem newInstanceFromJson(JsonElement element) {
        RewardItem rewardItem = new RewardItem();
        JsonObject jsonObject = element.getAsJsonObject();

        if (jsonObject.has("id"))
            rewardItem.setId(jsonObject.get("id").getAsInt());
        else rewardItem.setId(-1);

        if (jsonObject.has("name"))
            rewardItem.setName(jsonObject.get("name").getAsString());
        else rewardItem.setName("");

        if (jsonObject.has("icon"))
            rewardItem.setIcon(jsonObject.get("icon").getAsString());
        else rewardItem.setIcon("");

        if (jsonObject.has("quality"))
            rewardItem.setQuality(jsonObject.get("quality").getAsInt());
        else rewardItem.setQuality(-1);

        if (jsonObject.has("itemLevel"))
            rewardItem.setItemLevel(jsonObject.get("itemLevel").getAsInt());
        else rewardItem.setItemLevel(-1);

        if (jsonObject.has("stats") && jsonObject.get("stats").getAsJsonArray().size() > 0)
            rewardItem.setStats(parseJsonArray(jsonObject.getAsJsonArray("stats")));
        else rewardItem.setStats(new ArrayList<Stat>());

        if (jsonObject.has("armor"))
            rewardItem.setArmor(jsonObject.get("armor").getAsInt());
        else rewardItem.setArmor(-1);

        if (jsonObject.has("context"))
            rewardItem.setContext(jsonObject.get("context").getAsString());
        else rewardItem.setContext("");

        if (jsonObject.has("bonusLists") && jsonObject.get("bonusLists").getAsJsonArray().size() > 0) {
            JsonArray array = jsonObject.getAsJsonArray("bonusLists");
            int[] intArray = new int[array.size()];

            for (int x = 0; x < array.size(); x++) {
                intArray[x] = array.get(x).getAsInt();
            }

            rewardItem.setBonusLists(intArray);
        } else {
            rewardItem.setBonusLists(new int[0]);
        }

        if (jsonObject.has("artifactId"))
            rewardItem.setArtifactId(jsonObject.get("artifactId").getAsInt());

        if (jsonObject.has("displayInfoId"))
            rewardItem.setDisplayInfoId(jsonObject.get("displayInfoId").getAsInt());

        if (jsonObject.has("artifactAppearanceId"))
            rewardItem.setArtifactAppearanceId(jsonObject.get("artifactAppearanceId").getAsInt());

        if (jsonObject.has("artifactTraits") && jsonObject.get("artifactTraits").getAsJsonArray().size() > 0) {
            JsonArray array = jsonObject.getAsJsonArray("artifactTraits");
            int[] intArray = new int[array.size()];

            for (int x = 0; x < array.size(); x++) {
                intArray[x] = array.get(x).getAsInt();
            }

            rewardItem.setArtifactTraits(intArray);
        }

        if (jsonObject.has("relics") && jsonObject.get("relics").getAsJsonArray().size() > 0) {
            JsonArray array = jsonObject.getAsJsonArray("relics");
            int[] intArray = new int[array.size()];

            for (int x = 0; x < array.size(); x++) {
                intArray[x] = array.get(x).getAsInt();
            }

            rewardItem.setRelics(intArray);
        }

        //if (jsonObject.has("appearance") && jsonObject.get("appearance").getAsJsonObject().size() > 0)
        //rewardItem.setAppearance(jsonObject.get("appearance").getAsString().split(","));

        return rewardItem;
    }

    public static List<RewardItem> parseRewardItems(JsonArray rewardItems) {
        List<RewardItem> tempList = new ArrayList<>();

        for (int x = 0; x < rewardItems.size(); x++) {
            tempList.add(newInstanceFromJson(rewardItems.get(x)));
        }

        return tempList;
    }

    public List<TooltipParam> getTooltipParams() {
        return mTooltipParams;
    }

    public void setTooltipParams(List<TooltipParam> tooltipParams) {
        mTooltipParams = tooltipParams;
    }

    public List<Stat> getStats() {
        return mStats;
    }

    public void setStats(List<Stat> stats) {
        mStats = stats;
    }

    public int getArmor() {
        return mArmor;
    }

    public void setArmor(int armor) {
        mArmor = armor;
    }

    public String getContext() {
        return mContext;
    }

    public void setContext(String context) {
        mContext = context;
    }

    public int[] getBonusLists() {
        return mBonusLists;
    }

    public void setBonusLists(int[] bonusLists) {
        mBonusLists = bonusLists;
    }

    public int getArtifactId() {
        return mArtifactId;
    }

    public void setArtifactId(int artifactId) {
        mArtifactId = artifactId;
    }

    public int getDisplayInfoId() {
        return mDisplayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        mDisplayInfoId = displayInfoId;
    }

    public int getArtifactAppearanceId() {
        return mArtifactAppearanceId;
    }

    public void setArtifactAppearanceId(int artifactAppearanceId) {
        mArtifactAppearanceId = artifactAppearanceId;
    }

    public int[] getArtifactTraits() {
        return mArtifactTraits;
    }

    public void setArtifactTraits(int[] artifactTraits) {
        mArtifactTraits = artifactTraits;
    }

    public int[] getRelics() {
        return mRelics;
    }

    public void setRelics(int[] relics) {
        mRelics = relics;
    }

    public List<Object> getAppearance() {
        return mAppearance;
    }

    public void setAppearance(List<Object> appearance) {
        mAppearance = appearance;
    }
}
