package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalona.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 12:13.</p>
 */

public class PetSlot {
    private int mSlot;
    private String mBattlePetGuid;
    private boolean mIsEmpty;
    private boolean mIsLocked;
    private int[] mAbilities;

    public PetSlot() {

    }

    public static PetSlot newInstanceFromJson(JsonObject jsonObject) {
        PetSlot petSlot = new PetSlot();

        if (jsonObject.has("slot"))
            petSlot.setSlot(jsonObject.get("slot").getAsInt());
        else petSlot.setSlot(-1);

        if (jsonObject.has("battlePetGuid"))
            petSlot.setBattlePetGuid(jsonObject.get("battlePetGuid").getAsString());
        else petSlot.setBattlePetGuid("");

        if (jsonObject.has("isEmpty"))
            petSlot.setEmpty(jsonObject.get("isEmpty").getAsBoolean());
        else petSlot.setEmpty(false);

        if (jsonObject.has("isLocked"))
            petSlot.setLocked(jsonObject.get("isLocked").getAsBoolean());
        else petSlot.setLocked(false);

        if (jsonObject.has("abilities"))
            petSlot.setAbilities(JsonAid.jsonArrayToIntArray(jsonObject.getAsJsonArray("abilities")));
        else petSlot.setAbilities(new int[0]);

        return petSlot;
    }

    public static List<PetSlot> parseJsonArray(JsonArray jsonArray) {
        List<PetSlot> tempList = new ArrayList<>();

        for(int x = 0; x < jsonArray.size(); x++) {
            tempList.add(newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return tempList;
    }

    public int getSlot() {
        return mSlot;
    }

    public void setSlot(int slot) {
        mSlot = slot;
    }

    public String getBattlePetGuid() {
        return mBattlePetGuid;
    }

    public void setBattlePetGuid(String battlePetGuid) {
        mBattlePetGuid = battlePetGuid;
    }

    public boolean isEmpty() {
        return mIsEmpty;
    }

    public void setEmpty(boolean empty) {
        mIsEmpty = empty;
    }

    public boolean isLocked() {
        return mIsLocked;
    }

    public void setLocked(boolean locked) {
        mIsLocked = locked;
    }

    public int[] getAbilities() {
        return mAbilities;
    }

    public void setAbilities(int[] abilities) {
        mAbilities = abilities;
    }
}
