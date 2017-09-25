package org.alcha.algalon.models.wow;

import com.google.gson.JsonObject;

import org.alcha.algalon.util.JsonAid;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 07:13.</p>
 */

public class Item {
    private int mId;
    private int mDisenchantingSkillRank;
    private String mDescription;
    private String mName;
    private String mIcon;
    private int mStackable;
    private int mItemBind;
    private List<Stat> mBonusStats;
    private List<Spell> mItemSpells;
    private int mBuyPrice;
    private int mItemClass;
    private int mItemSubClass;
    private int mContainerSlots;
    private WeaponInfo mWeaponInfo;
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

    private BonusSummary mBonusSummary;
    private int mArtifactId;

    public Item() {

    }

    public static Item newInstanceFromJson(JsonObject jsonObject) {
        Item item = new Item();

        if (jsonObject.has("id"))
            item.setId(jsonObject.get("id").getAsInt());
        else item.setId(-1);

        if (jsonObject.has("disenchantingSkillRank"))
            item.setDisenchantingSkillRank(jsonObject.get("disenchantingSkillRank").getAsInt());
        else item.setDisenchantingSkillRank(-1);

        if (jsonObject.has("description"))
            item.setDescription(jsonObject.get("description").getAsString());
        else item.setDescription("");

        if (jsonObject.has("name"))
            item.setName(jsonObject.get("name").getAsString());
        else item.setName("");

        if (jsonObject.has("icon"))
            item.setIcon(jsonObject.get("icon").getAsString());
        else item.setIcon("");

        if (jsonObject.has("stackable"))
            item.setStackable(jsonObject.get("stackable").getAsInt());
        else item.setStackable(-1);

        if (jsonObject.has("itemBind"))
            item.setItemBind(jsonObject.get("itemBind").getAsInt());
        else item.setItemBind(-1);

        if (jsonObject.has("bonusStats"))
            item.setBonusStats(Stat.parseJsonArray(jsonObject.getAsJsonArray("bonusStats")));
        else item.setBonusStats(new ArrayList<Stat>());

        if (jsonObject.has("itemSpells"))
            item.setItemSpells(Spell.parseJsonArray(jsonObject.getAsJsonArray("itemSpells")));
        else item.setItemSpells(new ArrayList<Spell>());

        if (jsonObject.has("buyPrice"))
            item.setBuyPrice(jsonObject.get("buyPrice").getAsInt());
        else item.setBuyPrice(-1);

        if (jsonObject.has("itemClass"))
            item.setItemClass(jsonObject.get("itemClass").getAsInt());
        else item.setItemClass(-1);

        if (jsonObject.has("itemSubClass"))
            item.setItemSubClass(jsonObject.get("itemSubClass").getAsInt());
        else item.setItemSubClass(-1);

        if (jsonObject.has("containerSlots"))
            item.setContainerSlots(jsonObject.get("containerSlots").getAsInt());
        else item.setContainerSlots(-1);

        if (jsonObject.has("weaponInfo"))
            item.setWeaponInfo(WeaponInfo.newInstanceFromJson(jsonObject.getAsJsonObject("weaponInfo")));
        else item.setWeaponInfo(new WeaponInfo());

        if (jsonObject.has("inventoryType"))
            item.setInventoryType(jsonObject.get("inventoryType").getAsInt());
        else item.setInventoryType(-1);

        if (jsonObject.has("equippable"))
            item.setEquippable(jsonObject.get("equippable").getAsBoolean());
        else item.setEquippable(false);

        if (jsonObject.has("maxCount"))
            item.setMaxCount(jsonObject.get("maxCount").getAsInt());
        else item.setMaxCount(-1);

        if (jsonObject.has("maxDurability"))
            item.setMaxDurability(jsonObject.get("maxDurability").getAsInt());
        else item.setMaxDurability(-1);

        if (jsonObject.has("minFactionId"))
            item.setMinFactionId(jsonObject.get("minFactionId").getAsInt());
        else item.setMinFactionId(-1);

        if (jsonObject.has("minReputation"))
            item.setMinReputation(jsonObject.get("minReputation").getAsInt());
        else item.setMinReputation(-1);

        if (jsonObject.has("sellPrice"))
            item.setSellPrice(jsonObject.get("sellPrice").getAsInt());
        else item.setSellPrice(-1);

        if (jsonObject.has("requiredSkill"))
            item.setRequiredSkill(jsonObject.get("requiredSkill").getAsInt());
        else item.setRequiredSkill(-1);

        if (jsonObject.has("requiredLevel"))
            item.setRequiredLevel(jsonObject.get("requiredLevel").getAsInt());
        else item.setRequiredLevel(-1);

        if (jsonObject.has("requiredSkillRank"))
            item.setRequiredSkillRank(jsonObject.get("requiredSkillRank").getAsInt());
        else item.setRequiredSkillRank(-1);

        if (jsonObject.has("itemSource"))
            item.setItemSource(ItemSource.newInstanceFromJson(jsonObject.getAsJsonObject("itemSource")));
        else item.setItemSource(new ItemSource());

        if (jsonObject.has("baseArmor"))
            item.setBaseArmor(jsonObject.get("baseArmor").getAsInt());
        else item.setBaseArmor(-1);

        if (jsonObject.has("hasSockets"))
            item.setHasSockets(jsonObject.get("hasSockets").getAsBoolean());
        else item.setHasSockets(false);

        if (jsonObject.has("isAuctionable"))
            item.setAuctionable(jsonObject.get("isAuctionable").getAsBoolean());
        else item.setAuctionable(false);

        if (jsonObject.has("armor"))
            item.setArmor(jsonObject.get("armor").getAsInt());
        else item.setArmor(-1);

        if (jsonObject.has("displayInfoId"))
            item.setDisplayInfoId(jsonObject.get("displayInfoId").getAsInt());
        else item.setDisplayInfoId(-1);

        if (jsonObject.has("nameDescription"))
            item.setNameDescription(jsonObject.get("nameDescription").getAsString());
        else item.setNameDescription("");

        if (jsonObject.has("nameDescriptionColor"))
            item.setNameDescriptionColor(jsonObject.get("nameDescriptionColor").getAsString());
        else item.setNameDescriptionColor("");

        if (jsonObject.has("upgradable"))
            item.setUpgradable(jsonObject.get("upgradable").getAsBoolean());
        else item.setUpgradable(false);

        if (jsonObject.has("heroicTooltip"))
            item.setHeroicTooltip(jsonObject.get("heroicTooltip").getAsBoolean());
        else item.setHeroicTooltip(false);

        if (jsonObject.has("context"))
            item.setContext(jsonObject.get("context").getAsString());
        else item.setContext("");

        if (jsonObject.has("bonusLists"))
            item.setBonusLists(JsonAid.jsonArrayToArrayInt(jsonObject.getAsJsonArray("bonusLists")));
        else item.setBonusLists(new int[0]);

        if (jsonObject.has("availableContexts"))
            item.setAvailableContexts(JsonAid.jsonArrayToArrayStr(jsonObject.getAsJsonArray("availableContexts")));
        else item.setAvailableContexts(new String[0]);

        if (jsonObject.has("bonusSummary"))
            item.setBonusSummary(BonusSummary.newInstanceFromJson(jsonObject.getAsJsonObject("bonusSummary")));
        else item.setBonusSummary(new BonusSummary());

        if (jsonObject.has("artifactId"))
            item.setArtifactId(jsonObject.get("artifactId").getAsInt());
        else item.setArtifactId(-1);

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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
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

    public List<Stat> getBonusStats() {
        return mBonusStats;
    }

    public void setBonusStats(List<Stat> bonusStats) {
        mBonusStats = bonusStats;
    }

    public List<Spell> getItemSpells() {
        return mItemSpells;
    }

    public void setItemSpells(List<Spell> itemSpells) {
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

    public BonusSummary getBonusSummary() {
        return mBonusSummary;
    }

    public void setBonusSummary(BonusSummary bonusSummary) {
        mBonusSummary = bonusSummary;
    }

    public int getArtifactId() {
        return mArtifactId;
    }

    public void setArtifactId(int artifactId) {
        mArtifactId = artifactId;
    }

    public int getDisenchantingSkillRank() {
        return mDisenchantingSkillRank;
    }

    public void setDisenchantingSkillRank(int disenchantingSkillRank) {
        mDisenchantingSkillRank = disenchantingSkillRank;
    }

    public WeaponInfo getWeaponInfo() {
        return mWeaponInfo;
    }

    public void setWeaponInfo(WeaponInfo weaponInfo) {
        mWeaponInfo = weaponInfo;
    }
}
