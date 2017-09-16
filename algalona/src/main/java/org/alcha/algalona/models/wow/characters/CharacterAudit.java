package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Item;
import org.alcha.algalona.util.JsonAid;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Created by Alcha on Sep 12, 2017 @ 23:45.</p>
 */

public class CharacterAudit extends CharacterField {
    private int mNumberOfIssues;
    private Map<String, Integer> mSlots;
    private int mEmptyGlyphSlots;
    private int mUnspentTalentPoints;
    private boolean mNoSpec;
    private Map<String, Integer> mUnenchantedItems;
    private int mEmptySockets;
    private Map<String, Integer> mItemsWithEmptySockets;
    private int mAppropriateArmorType;

    /**
     * Contains the inappropriate armor type values. I'm not certain this is *actual* a map,
     * however, similar types used a Map and I'm unable to find any real data for this.
     */
    private Map<String, Integer> mInappropriateArmorType;

    /**
     * Contains teh low level items for a given character. I'm not certain this is *actual* a map,
     * however, similar types used a Map and I'm unable to find any real data for this.
     */
    private Map<String, Integer> mLowLevelItems;
    private int mLowLevelThreshold;

    /** Contains the map of missing extra sockets for a given character. */
    private Map<String, Integer> mMissingExtraSockets;

    private Item mRecommendedBeltBuckle;
    private Map<String, Integer> mMissingBlacksmithSockets;
    private Map<String, Integer> mMissingEnchanterEnchants;
    private Map<String, Integer> mMissingEngineerEnchants;
    private Map<String, Integer> mMissingScribeEnchants;
    private int mNMissingJewelcrafterGems;
    private Item mRecommendedJewelcrafterGem;
    private Map<String, Integer> mMissingLeatherworkerEnchants;

    public CharacterAudit() {
        setFieldName(Name.Audit);
    }

    public static CharacterAudit newInstanceFromJson(JsonObject jsonObject) {
        CharacterAudit audit = new CharacterAudit();

        if (jsonObject.has("numberOfIssues"))
            audit.setNumberOfIssues(jsonObject.get("numberOfIssues").getAsInt());
        else audit.setNumberOfIssues(-1);

        if (jsonObject.has("slots"))
            audit.setSlots(JsonAid.jsonObjectToMap(jsonObject.getAsJsonObject("slots")));
        else audit.setSlots(new HashMap());

        return audit;
    }

    public int getNumberOfIssues() {
        return mNumberOfIssues;
    }

    public void setNumberOfIssues(int numberOfIssues) {
        mNumberOfIssues = numberOfIssues;
    }

    public Map getSlots() {
        return mSlots;
    }

    public void setSlots(Map slots) {
        mSlots = slots;
    }

    public int getEmptyGlyphSlots() {
        return mEmptyGlyphSlots;
    }

    public void setEmptyGlyphSlots(int emptyGlyphSlots) {
        mEmptyGlyphSlots = emptyGlyphSlots;
    }

    public int getUnspentTalentPoints() {
        return mUnspentTalentPoints;
    }

    public void setUnspentTalentPoints(int unspentTalentPoints) {
        mUnspentTalentPoints = unspentTalentPoints;
    }

    public boolean isNoSpec() {
        return mNoSpec;
    }

    public void setNoSpec(boolean noSpec) {
        mNoSpec = noSpec;
    }

    public Map<String, Integer> getUnenchantedItems() {
        return mUnenchantedItems;
    }

    public void setUnenchantedItems(Map<String, Integer> unenchantedItems) {
        mUnenchantedItems = unenchantedItems;
    }

    public int getEmptySockets() {
        return mEmptySockets;
    }

    public void setEmptySockets(int emptySockets) {
        mEmptySockets = emptySockets;
    }

    public Map<String, Integer> getItemsWithEmptySockets() {
        return mItemsWithEmptySockets;
    }

    public void setItemsWithEmptySockets(Map<String, Integer> itemsWithEmptySockets) {
        mItemsWithEmptySockets = itemsWithEmptySockets;
    }

    public int getAppropriateArmorType() {
        return mAppropriateArmorType;
    }

    public void setAppropriateArmorType(int appropriateArmorType) {
        mAppropriateArmorType = appropriateArmorType;
    }

    public Map<String, Integer> getInappropriateArmorType() {
        return mInappropriateArmorType;
    }

    public void setInappropriateArmorType(Map<String, Integer> inappropriateArmorType) {
        mInappropriateArmorType = inappropriateArmorType;
    }

    public Map<String, Integer> getLowLevelItems() {
        return mLowLevelItems;
    }

    public void setLowLevelItems(Map<String, Integer> lowLevelItems) {
        mLowLevelItems = lowLevelItems;
    }

    public int getLowLevelThreshold() {
        return mLowLevelThreshold;
    }

    public void setLowLevelThreshold(int lowLevelThreshold) {
        mLowLevelThreshold = lowLevelThreshold;
    }

    public Map<String, Integer> getMissingExtraSockets() {
        return mMissingExtraSockets;
    }

    public void setMissingExtraSockets(Map<String, Integer> missingExtraSockets) {
        mMissingExtraSockets = missingExtraSockets;
    }

    public Item getRecommendedBeltBuckle() {
        return mRecommendedBeltBuckle;
    }

    public void setRecommendedBeltBuckle(Item recommendedBeltBuckle) {
        mRecommendedBeltBuckle = recommendedBeltBuckle;
    }

    public Map<String, Integer> getMissingBlacksmithSockets() {
        return mMissingBlacksmithSockets;
    }

    public void setMissingBlacksmithSockets(Map<String, Integer> missingBlacksmithSockets) {
        mMissingBlacksmithSockets = missingBlacksmithSockets;
    }

    public Map<String, Integer> getMissingEnchanterEnchants() {
        return mMissingEnchanterEnchants;
    }

    public void setMissingEnchanterEnchants(Map<String, Integer> missingEnchanterEnchants) {
        mMissingEnchanterEnchants = missingEnchanterEnchants;
    }

    public Map<String, Integer> getMissingEngineerEnchants() {
        return mMissingEngineerEnchants;
    }

    public void setMissingEngineerEnchants(Map<String, Integer> missingEngineerEnchants) {
        mMissingEngineerEnchants = missingEngineerEnchants;
    }

    public Map<String, Integer> getMissingScribeEnchants() {
        return mMissingScribeEnchants;
    }

    public void setMissingScribeEnchants(Map<String, Integer> missingScribeEnchants) {
        mMissingScribeEnchants = missingScribeEnchants;
    }

    public int getNMissingJewelcrafterGems() {
        return mNMissingJewelcrafterGems;
    }

    public void setNMissingJewelcrafterGems(int NMissingJewelcrafterGems) {
        mNMissingJewelcrafterGems = NMissingJewelcrafterGems;
    }

    public Item getRecommendedJewelcrafterGem() {
        return mRecommendedJewelcrafterGem;
    }

    public void setRecommendedJewelcrafterGem(Item recommendedJewelcrafterGem) {
        mRecommendedJewelcrafterGem = recommendedJewelcrafterGem;
    }

    public Map<String, Integer> getMissingLeatherworkerEnchants() {
        return mMissingLeatherworkerEnchants;
    }

    public void setMissingLeatherworkerEnchants(Map<String, Integer> missingLeatherworkerEnchants) {
        mMissingLeatherworkerEnchants = missingLeatherworkerEnchants;
    }
}
