package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:47.</p>
 */

public class Pet {
    private String mName;
    private int mSpellId;
    private int mCreatureId;
    private int mItemId;
    private int mQualityId;
    private String mIcon;
    private List<PetStat> mStats;
    private String mBattlePetGuid;
    private boolean mIsFavorite;
    private boolean isFirstAbilitySlotSelected;
    private boolean isSecondAbilitySlotSelected;
    private boolean isThirdAbilitySlotSelected;
    private String mCreatureName;
    private boolean mCanBattle;

    public Pet() {

    }

    public static Pet newInstanceFromJson(JsonObject jsonObject) {
        Pet pet = new Pet();

        if(jsonObject.has("name"))
            pet.setName(jsonObject.get("name").getAsString());
        else pet.setName("");

        if(jsonObject.has("spellId"))
            pet.setSpellId(jsonObject.get("spellId").getAsInt());
        else pet.setSpellId(-1);

        if(jsonObject.has("creatureId"))
            pet.setCreatureId(jsonObject.get("creatureId").getAsInt());
        else pet.setCreatureId(-1);

        if(jsonObject.has("itemId"))
            pet.setItemId(jsonObject.get("itemId").getAsInt());
        else pet.setItemId(-1);

        if(jsonObject.has("qualityId"))
            pet.setQualityId(jsonObject.get("qualityId").getAsInt());
        else pet.setQualityId(-1);

        if(jsonObject.has("icon"))
            pet.setIcon(jsonObject.get("icon").getAsString());
        else pet.setIcon("");

        if(jsonObject.has("stats"))
            pet.setStats(PetStat.parseJsonObject(jsonObject.getAsJsonObject("stats")));
        else pet.setStats(new ArrayList<PetStat>());

        if(jsonObject.has("battlePetGuid"))
            pet.setBattlePetGuid(jsonObject.get("battlePetGuid").getAsString());
        else pet.setBattlePetGuid("");

        if(jsonObject.has("isFavorite"))
            pet.setFavorite(jsonObject.get("isFavorite").getAsBoolean());
        else pet.setFavorite(false);

        if(jsonObject.has("isFirstAbilitySlotSelected"))
            pet.setFirstAbilitySlotSelected(jsonObject.get("isFirstAbilitySlotSelected").getAsBoolean());
        else pet.setFirstAbilitySlotSelected(false);

        if(jsonObject.has("isSecondAbilitySlotSelected"))
            pet.setSecondAbilitySlotSelected(jsonObject.get("isSecondAbilitySlotSelected").getAsBoolean());
        else pet.setSecondAbilitySlotSelected(false);

        if(jsonObject.has("isThirdAbilitySlotSelected"))
            pet.setThirdAbilitySlotSelected(jsonObject.get("isThirdAbilitySlotSelected").getAsBoolean());
        else pet.setThirdAbilitySlotSelected(false);

        if(jsonObject.has("creatureName"))
            pet.setCreatureName(jsonObject.get("creatureName").getAsString());
        else pet.setCreatureName("");

        if(jsonObject.has("canBattle"))
            pet.setCanBattle(jsonObject.get("canBattle").getAsBoolean());
        else pet.setCanBattle(false);

        return pet;
    }

    public static List<Pet> parseJsonArray(JsonArray jsonArray) {
        List<Pet> tempList = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            tempList.add(newInstanceFromJson(jsonArray.get(x).getAsJsonObject()));
        }

        return tempList;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getSpellId() {
        return mSpellId;
    }

    public void setSpellId(int spellId) {
        mSpellId = spellId;
    }

    public int getCreatureId() {
        return mCreatureId;
    }

    public void setCreatureId(int creatureId) {
        mCreatureId = creatureId;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }

    public int getQualityId() {
        return mQualityId;
    }

    public void setQualityId(int qualityId) {
        mQualityId = qualityId;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public List<PetStat> getStats() {
        return mStats;
    }

    public void setStats(List<PetStat> stats) {
        mStats = stats;
    }

    public String getBattlePetGuid() {
        return mBattlePetGuid;
    }

    public void setBattlePetGuid(String battlePetGuid) {
        mBattlePetGuid = battlePetGuid;
    }

    public boolean isFavorite() {
        return mIsFavorite;
    }

    public void setFavorite(boolean favorite) {
        mIsFavorite = favorite;
    }

    public boolean isFirstAbilitySlotSelected() {
        return isFirstAbilitySlotSelected;
    }

    public void setFirstAbilitySlotSelected(boolean firstAbilitySlotSelected) {
        isFirstAbilitySlotSelected = firstAbilitySlotSelected;
    }

    public boolean isSecondAbilitySlotSelected() {
        return isSecondAbilitySlotSelected;
    }

    public void setSecondAbilitySlotSelected(boolean secondAbilitySlotSelected) {
        isSecondAbilitySlotSelected = secondAbilitySlotSelected;
    }

    public boolean isThirdAbilitySlotSelected() {
        return isThirdAbilitySlotSelected;
    }

    public void setThirdAbilitySlotSelected(boolean thirdAbilitySlotSelected) {
        isThirdAbilitySlotSelected = thirdAbilitySlotSelected;
    }

    public String getCreatureName() {
        return mCreatureName;
    }

    public void setCreatureName(String creatureName) {
        mCreatureName = creatureName;
    }

    public boolean isCanBattle() {
        return mCanBattle;
    }

    public void setCanBattle(boolean canBattle) {
        mCanBattle = canBattle;
    }
}
