package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Stat;
import org.alcha.algalona.models.wow.TooltipParam;

import java.util.List;

import static org.alcha.algalona.models.wow.characters.WoWCharacterField.Name.Items;

/**
 * <p>Created by Alcha on Aug 19, 2017 @ 23:00.</p>
 *
 * <p>This is used to store the various items a {@link Character} has equipped. For example,
 * their helm, neck, shoulders, chest, etc..</p>
 */

public class WoWCharacterItems extends WoWCharacterField {
    private int mAverageItemLevel;
    private int mAverageItemLevelEquipped;
    private List<TooltipParam> mTooltipParams;
    private List<Stat> mStats;

    private WoWCharacterItems() {
        setFieldName(Items);
    }

    public static WoWCharacterItems newInstanceFromJson(JsonObject jsonObject) {
        WoWCharacterItems characterItems = new WoWCharacterItems();

        if (jsonObject.has("averageItemLevel"))
            characterItems.setAverageItemLevel(jsonObject.get("averageItemLevel").getAsInt());

        if (jsonObject.has("averageItemLevelEquipped"))
            characterItems.setAverageItemLevelEquipped(jsonObject.get("averageItemLevelEquipped").getAsInt());

        return characterItems;
    }

    // Getters
    public int getAverageItemLevel() {
        return mAverageItemLevel;
    }

    public int getAverageItemLevelEquipped() {
        return mAverageItemLevelEquipped;
    }

    // Setters
    private void setAverageItemLevel(int averageItemLevel) {
        mAverageItemLevel = averageItemLevel;
    }

    private void setAverageItemLevelEquipped(int averageItemLevelEquipped) {
        mAverageItemLevelEquipped = averageItemLevelEquipped;
    }

    public List<Stat> getStats() {
        return mStats;
    }

    public void setStats(List<Stat> stats) {
        mStats = stats;
    }
}
