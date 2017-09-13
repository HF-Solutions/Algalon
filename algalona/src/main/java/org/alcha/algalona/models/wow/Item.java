package org.alcha.algalona.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:13.</p>
 */

public class Item {
    private int mId;
    private String mDescription;
    private String mName;
    private String mIcon;
    private int mStackable;
    private int mItemBind;
    private Stat[] mBonusStats;
    private Spell[] mItemSpells;
    private int mBuyPrice;
    private int mItemClass;
    private int mItemSubClass;
    private int mContainerSlots;
    private int mInventoryType;
    private boolean mEquippable;
    private int mItemLevel;
    private int mMaxCount;
    private int mMaxDurability;
    private int mMinFactionId;
    private int mMinReputation;
    private int mQuality;
    private int mSellPrice;
    private int mRequiredSkill;
    private int mRequiredLevel;
    private int mRequiredSkillRank;
    private ItemSource mItemSource;
    private int mBaseArmor;
    private boolean mHasSockets;
    private boolean mIsAuctionable;
    private int mArmor;
    private int mDisplayInfoId;
    private String mNameDescription;
    private String mNameDescriptionColor;
    private boolean mUpgradable;
    private boolean mHeroicTooltip;
    private String mContext;

    /** I have no test data for this object so I'm unsure of the proper type */
    private Object mBonusLists;

    /** I have no test data for this object so I'm unsure of the proper type */
    private String[] mAvailableContexts;

    /** I have no test data for this object so I'm unsure of the proper type */
    private Object mBonusSummary;
    private int mArtifactId;

    public Item() {

    }

    public static Item newInstanceFromJson(JsonObject jsonObject) {
        Item item = new Item();

        if (jsonObject.has("id"))
            item.setId(jsonObject.get("id").getAsInt());
        else item.setId(-1);

        if (jsonObject.has("name"))
            item.setName(jsonObject.get("name").getAsString());
        else item.setName("");

        if (jsonObject.has("icon"))
            item.setIcon(jsonObject.get("icon").getAsString());
        else item.setIcon("");

        if (jsonObject.has("quality"))
            item.setQuality(jsonObject.get("quality").getAsInt());
        else item.setQuality(-1);

        if (jsonObject.has("itemLevel"))
            item.setItemLevel(jsonObject.get("itemLevel").getAsInt());
        else item.setItemLevel(-1);

        return item;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getQuality() {
        return mQuality;
    }

    public void setQuality(int quality) {
        mQuality = quality;
    }

    public int getItemLevel() {
        return mItemLevel;
    }

    public void setItemLevel(int itemLevel) {
        mItemLevel = itemLevel;
    }

    public int getStackable() {
        return mStackable;
    }

    public void setStackable(int stackable) {
        mStackable = stackable;
    }

    public int getItemBind() {
        return mItemBind;
    }

    public void setItemBind(int itemBind) {
        mItemBind = itemBind;
    }

    public Stat[] getBonusStats() {
        return mBonusStats;
    }

    public void setBonusStats(Stat[] bonusStats) {
        mBonusStats = bonusStats;
    }

    public Spell[] getItemSpells() {
        return mItemSpells;
    }

    public void setItemSpells(Spell[] itemSpells) {
        mItemSpells = itemSpells;
    }

    public int getBuyPrice() {
        return mBuyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        mBuyPrice = buyPrice;
    }

    public int getItemClass() {
        return mItemClass;
    }

    public void setItemClass(int itemClass) {
        mItemClass = itemClass;
    }

    public int getItemSubClass() {
        return mItemSubClass;
    }

    public void setItemSubClass(int itemSubClass) {
        mItemSubClass = itemSubClass;
    }

    public int getContainerSlots() {
        return mContainerSlots;
    }

    public void setContainerSlots(int containerSlots) {
        mContainerSlots = containerSlots;
    }

    public int getInventoryType() {
        return mInventoryType;
    }

    public void setInventoryType(int inventoryType) {
        mInventoryType = inventoryType;
    }

    public boolean isEquippable() {
        return mEquippable;
    }

    public void setEquippable(boolean equippable) {
        mEquippable = equippable;
    }

    public int getMaxCount() {
        return mMaxCount;
    }

    public void setMaxCount(int maxCount) {
        mMaxCount = maxCount;
    }

    public int getMaxDurability() {
        return mMaxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        mMaxDurability = maxDurability;
    }

    public int getMinFactionId() {
        return mMinFactionId;
    }

    public void setMinFactionId(int minFactionId) {
        mMinFactionId = minFactionId;
    }

    public int getMinReputation() {
        return mMinReputation;
    }

    public void setMinReputation(int minReputation) {
        mMinReputation = minReputation;
    }

    public int getSellPrice() {
        return mSellPrice;
    }

    public void setSellPrice(int sellPrice) {
        mSellPrice = sellPrice;
    }

    public int getRequiredSkill() {
        return mRequiredSkill;
    }

    public void setRequiredSkill(int requiredSkill) {
        mRequiredSkill = requiredSkill;
    }

    public int getRequiredLevel() {
        return mRequiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        mRequiredLevel = requiredLevel;
    }

    public int getRequiredSkillRank() {
        return mRequiredSkillRank;
    }

    public void setRequiredSkillRank(int requiredSkillRank) {
        mRequiredSkillRank = requiredSkillRank;
    }

    public ItemSource getItemSource() {
        return mItemSource;
    }

    public void setItemSource(ItemSource itemSource) {
        mItemSource = itemSource;
    }

    public int getBaseArmor() {
        return mBaseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        mBaseArmor = baseArmor;
    }

    public boolean isHasSockets() {
        return mHasSockets;
    }

    public void setHasSockets(boolean hasSockets) {
        mHasSockets = hasSockets;
    }

    public boolean isAuctionable() {
        return mIsAuctionable;
    }

    public void setAuctionable(boolean auctionable) {
        mIsAuctionable = auctionable;
    }

    public int getArmor() {
        return mArmor;
    }

    public void setArmor(int armor) {
        mArmor = armor;
    }

    public int getDisplayInfoId() {
        return mDisplayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        mDisplayInfoId = displayInfoId;
    }

    public String getNameDescription() {
        return mNameDescription;
    }

    public void setNameDescription(String nameDescription) {
        mNameDescription = nameDescription;
    }

    public String getNameDescriptionColor() {
        return mNameDescriptionColor;
    }

    public void setNameDescriptionColor(String nameDescriptionColor) {
        mNameDescriptionColor = nameDescriptionColor;
    }

    public boolean isUpgradable() {
        return mUpgradable;
    }

    public void setUpgradable(boolean upgradable) {
        mUpgradable = upgradable;
    }

    public boolean isHeroicTooltip() {
        return mHeroicTooltip;
    }

    public void setHeroicTooltip(boolean heroicTooltip) {
        mHeroicTooltip = heroicTooltip;
    }

    public String getContext() {
        return mContext;
    }

    public void setContext(String context) {
        mContext = context;
    }

    public Object getBonusLists() {
        return mBonusLists;
    }

    public void setBonusLists(Object bonusLists) {
        mBonusLists = bonusLists;
    }

    public String[] getAvailableContexts() {
        return mAvailableContexts;
    }

    public void setAvailableContexts(String[] availableContexts) {
        mAvailableContexts = availableContexts;
    }

    public Object getBonusSummary() {
        return mBonusSummary;
    }

    public void setBonusSummary(Object bonusSummary) {
        mBonusSummary = bonusSummary;
    }

    public int getArtifactId() {
        return mArtifactId;
    }

    public void setArtifactId(int artifactId) {
        mArtifactId = artifactId;
    }
}
