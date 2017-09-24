package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 18:12.</p>
 */

public class CharacterStats extends CharacterField {
    private int mHealth;
    private String mPowerType;
    private int mPower;
    private int mStr;
    private int mAgi;
    private int mInt;
    private int mSta;
    private double mSpeedRating;
    private double mSpeedRatingBonus;
    private double mCrit;
    private double mCritRating;
    private double mHaste;
    private double mHasteRating;
    private double mHasteRatingPercent;
    private double mMastery;
    private double mMasteryRating;
    private double mLeech;
    private double mLeechRating;
    private double mLeechRatingBonus;
    private double mVersatility;
    private double mVersatilityDamageDoneBonus;
    private double mVersatilityHealingDoneBonus;
    private double mVersatilityDamageTakenBonus;
    private double mAvoidanceRating;
    private double mAvoidanceRatingBonus;
    private double mSpellPen;
    private double mSpellCrit;
    private double mSpellCritRating;
    private double mMana5;
    private double mMana5Combat;
    private double mArmor;
    private double mDodge;
    private double mDodgeRating;
    private double mParry;
    private double mParryRating;
    private double mBlock;
    private double mBlockRating;
    private double mMainHandDmgMin;
    private double mMainHandDmgMax;
    private double mMainHandSpeed;
    private double mMainHandDps;
    private double mOffHandDmgMin;
    private double mOffHandDmgMax;
    private double mOffHandSpeed;
    private double mOffHandDps;
    private double mRangedDmgMin;
    private double mRangedDmgMax;
    private double mRangedSpeed;
    private double mRangedDps;

    public CharacterStats() {
        setFieldName(Name.Stats);
    }

    public static CharacterStats newInstanceFromJson(JsonObject jsonObject) {
        CharacterStats stats = new CharacterStats();

        if (jsonObject.has("health"))
            stats.setHealth(jsonObject.get("health").getAsInt());
        else stats.setHealth(-1);

        if (jsonObject.has("powerType"))
            stats.setPowerType(jsonObject.get("powerType").getAsString());
        else stats.setPowerType("");

        if (jsonObject.has("power"))
            stats.setPower(jsonObject.get("power").getAsInt());
        else stats.setPower(-1);

        if (jsonObject.has("str"))
            stats.setStr(jsonObject.get("str").getAsInt());
        else stats.setStr(-1);

        if (jsonObject.has("agi"))
            stats.setAgi(jsonObject.get("agi").getAsInt());
        else stats.setAgi(-1);

        if (jsonObject.has("int"))
            stats.setInt(jsonObject.get("int").getAsInt());
        else stats.setInt(-1);

        if (jsonObject.has("sta"))
            stats.setSta(jsonObject.get("sta").getAsInt());
        else stats.setSta(-1);

        if (jsonObject.has("speedRating"))
            stats.setSpeedRating(jsonObject.get("speedRating").getAsDouble());
        else stats.setSpeedRating(-1);

        if (jsonObject.has("speedRatingBonus"))
            stats.setSpeedRatingBonus(jsonObject.get("speedRatingBonus").getAsDouble());
        else stats.setSpeedRatingBonus(-1);

        if (jsonObject.has("crit"))
            stats.setCrit(jsonObject.get("crit").getAsDouble());
        else stats.setCrit(-1);

        if (jsonObject.has("critRating"))
            stats.setCritRating(jsonObject.get("critRating").getAsDouble());
        else stats.setCritRating(-1);

        if (jsonObject.has("haste"))
            stats.setHaste(jsonObject.get("haste").getAsDouble());
        else stats.setHaste(-1);

        if (jsonObject.has("hasteRating"))
            stats.setHasteRating(jsonObject.get("hasteRating").getAsDouble());
        else stats.setHasteRating(-1);

        if (jsonObject.has("hasteRatingPercent"))
            stats.setHasteRatingPercent(jsonObject.get("hasteRatingPercent").getAsDouble());
        else stats.setHasteRatingPercent(-1);

        if (jsonObject.has("mastery"))
            stats.setMastery(jsonObject.get("mastery").getAsDouble());
        else stats.setMastery(-1);

        if (jsonObject.has("masteryRating"))
            stats.setMasteryRating(jsonObject.get("masteryRating").getAsDouble());
        else stats.setMasteryRating(-1);

        if (jsonObject.has("leech"))
            stats.setLeech(jsonObject.get("leech").getAsDouble());
        else stats.setLeech(-1);

        if (jsonObject.has("leechRating"))
            stats.setLeechRating(jsonObject.get("leechRating").getAsDouble());
        else stats.setLeechRating(-1);

        if (jsonObject.has("leechRatingBonus"))
            stats.setLeechRatingBonus(jsonObject.get("leechRatingBonus").getAsDouble());
        else stats.setLeechRating(-1);

        if (jsonObject.has("versatility"))
            stats.setVersatility(jsonObject.get("versatility").getAsDouble());
        else stats.setVersatility(-1);

        if (jsonObject.has("versatilityDamageDoneBonus"))
            stats.setVersatilityDamageDoneBonus(jsonObject.get("versatilityDamageDoneBonus").getAsDouble());
        else stats.setVersatilityDamageDoneBonus(-1);

        if (jsonObject.has("versatilityHealingDoneBonus"))
            stats.setVersatilityHealingDoneBonus(jsonObject.get("versatilityHealingDoneBonus").getAsDouble());
        else stats.setVersatilityHealingDoneBonus(-1);

        if (jsonObject.has("versatilityDamageTakenBonus"))
            stats.setVersatilityDamageTakenBonus(jsonObject.get("versatilityDamageTakenBonus").getAsDouble());
        else stats.setVersatilityDamageTakenBonus(-1);

        if (jsonObject.has("avoidanceRating"))
            stats.setAvoidanceRating(jsonObject.get("avoidanceRating").getAsDouble());
        else stats.setAvoidanceRating(-1);

        if (jsonObject.has("avoidanceRatingBonus"))
            stats.setAvoidanceRatingBonus(jsonObject.get("avoidanceRatingBonus").getAsDouble());
        else stats.setAvoidanceRatingBonus(-1);

        if (jsonObject.has("spellPen"))
            stats.setSpellPen(jsonObject.get("spellPen").getAsDouble());
        else stats.setSpellPen(-1);

        if (jsonObject.has("spellCrit"))
            stats.setSpellCrit(jsonObject.get("spellCrit").getAsDouble());
        else stats.setSpellCrit(-1);

        if (jsonObject.has("spellCritRating"))
            stats.setSpellCritRating(jsonObject.get("spellCritRating").getAsDouble());
        else stats.setSpellCritRating(-1);

        if (jsonObject.has("mana5"))
            stats.setMana5(jsonObject.get("mana5").getAsDouble());
        else stats.setMana5(-1);

        if (jsonObject.has("mana5Combat"))
            stats.setMana5Combat(jsonObject.get("mana5Combat").getAsDouble());
        else stats.setMana5Combat(-1);

        if (jsonObject.has("armor"))
            stats.setArmor(jsonObject.get("armor").getAsDouble());
        else stats.setArmor(-1);

        if (jsonObject.has("dodge"))
            stats.setDodge(jsonObject.get("dodge").getAsDouble());
        else stats.setDodge(-1);

        if (jsonObject.has("dodgeRating"))
            stats.setDodgeRating(jsonObject.get("dodgeRating").getAsDouble());
        else stats.setDodgeRating(-1);

        if (jsonObject.has("parry"))
            stats.setParry(jsonObject.get("parry").getAsDouble());
        else stats.setParry(-1);

        if (jsonObject.has("parryRating"))
            stats.setParryRating(jsonObject.get("parryRating").getAsDouble());
        else stats.setParryRating(-1);

        if (jsonObject.has("block"))
            stats.setBlock(jsonObject.get("block").getAsDouble());
        else stats.setBlock(-1);

        if (jsonObject.has("blockRating"))
            stats.setBlockRating(jsonObject.get("blockRating").getAsDouble());
        else stats.setBlockRating(-1);

        if (jsonObject.has("mainHandDmgMin"))
            stats.setMainHandDmgMin(jsonObject.get("mainHandDmgMin").getAsDouble());
        else stats.setMainHandDmgMin(-1);

        if (jsonObject.has("mainHandDmgMax"))
            stats.setMainHandDmgMax(jsonObject.get("mainHandDmgMax").getAsDouble());
        else stats.setMainHandDmgMax(-1);

        if (jsonObject.has("mainHandSpeed"))
            stats.setMainHandSpeed(jsonObject.get("mainHandSpeed").getAsDouble());
        else stats.setMainHandSpeed(-1);

        if (jsonObject.has("mainHandDps"))
            stats.setMainHandDps(jsonObject.get("mainHandDps").getAsDouble());
        else stats.setMainHandDps(-1);

        if (jsonObject.has("offHandDmgMin"))
            stats.setOffHandDmgMin(jsonObject.get("offHandDmgMin").getAsDouble());
        else stats.setOffHandDmgMin(-1);

        if (jsonObject.has("offHandDmgMax"))
            stats.setOffHandDmgMax(jsonObject.get("offHandDmgMax").getAsDouble());
        else stats.setOffHandDmgMax(-1);

        if (jsonObject.has("offHandSpeed"))
            stats.setOffHandSpeed(jsonObject.get("offHandSpeed").getAsDouble());
        else stats.setOffHandSpeed(-1);

        if (jsonObject.has("offHandDps"))
            stats.setOffHandDps(jsonObject.get("offHandDps").getAsDouble());
        else stats.setOffHandDps(-1);

        if (jsonObject.has("rangedDmgMin"))
            stats.setRangedDmgMin(jsonObject.get("rangedDmgMin").getAsDouble());
        else stats.setRangedDmgMin(-1);

        if (jsonObject.has("rangedDmgMax"))
            stats.setRangedDmgMax(jsonObject.get("rangedDmgMax").getAsDouble());
        else stats.setRangedDmgMax(-1);

        if (jsonObject.has("rangedSpeed"))
            stats.setRangedSpeed(jsonObject.get("rangedSpeed").getAsDouble());
        else stats.setRangedSpeed(-1);

        if (jsonObject.has("rangedDps"))
            stats.setRangedDps(jsonObject.get("rangedDps").getAsDouble());
        else stats.setRangedDps(-1);

        return stats;
    }

    public int getHealth() {
        return mHealth;
    }

    public void setHealth(int health) {
        mHealth = health;
    }

    public String getPowerType() {
        return mPowerType;
    }

    public void setPowerType(String powerType) {
        mPowerType = powerType;
    }

    public int getPower() {
        return mPower;
    }

    public void setPower(int power) {
        mPower = power;
    }

    public int getStr() {
        return mStr;
    }

    public void setStr(int str) {
        mStr = str;
    }

    public int getAgi() {
        return mAgi;
    }

    public void setAgi(int agi) {
        mAgi = agi;
    }

    public int getInt() {
        return mInt;
    }

    public void setInt(int anInt) {
        mInt = anInt;
    }

    public int getSta() {
        return mSta;
    }

    public void setSta(int sta) {
        mSta = sta;
    }

    public double getSpeedRating() {
        return mSpeedRating;
    }

    public void setSpeedRating(double speedRating) {
        mSpeedRating = speedRating;
    }

    public double getSpeedRatingBonus() {
        return mSpeedRatingBonus;
    }

    public void setSpeedRatingBonus(double speedRatingBonus) {
        mSpeedRatingBonus = speedRatingBonus;
    }

    public double getCrit() {
        return mCrit;
    }

    public void setCrit(double crit) {
        mCrit = crit;
    }

    public double getCritRating() {
        return mCritRating;
    }

    public void setCritRating(double critRating) {
        mCritRating = critRating;
    }

    public double getHaste() {
        return mHaste;
    }

    public void setHaste(double haste) {
        mHaste = haste;
    }

    public double getHasteRating() {
        return mHasteRating;
    }

    public void setHasteRating(double hasteRating) {
        mHasteRating = hasteRating;
    }

    public double getHasteRatingPercent() {
        return mHasteRatingPercent;
    }

    public void setHasteRatingPercent(double hasteRatingPercent) {
        mHasteRatingPercent = hasteRatingPercent;
    }

    public double getMastery() {
        return mMastery;
    }

    public void setMastery(double mastery) {
        mMastery = mastery;
    }

    public double getMasteryRating() {
        return mMasteryRating;
    }

    public void setMasteryRating(double masteryRating) {
        mMasteryRating = masteryRating;
    }

    public double getLeech() {
        return mLeech;
    }

    public void setLeech(double leech) {
        mLeech = leech;
    }

    public double getLeechRating() {
        return mLeechRating;
    }

    public void setLeechRating(double leechRating) {
        mLeechRating = leechRating;
    }

    public double getLeechRatingBonus() {
        return mLeechRatingBonus;
    }

    public void setLeechRatingBonus(double leechRatingBonus) {
        mLeechRatingBonus = leechRatingBonus;
    }

    public double getVersatility() {
        return mVersatility;
    }

    public void setVersatility(double versatility) {
        mVersatility = versatility;
    }

    public double getVersatilityDamageDoneBonus() {
        return mVersatilityDamageDoneBonus;
    }

    public void setVersatilityDamageDoneBonus(double versatilityDamageDoneBonus) {
        mVersatilityDamageDoneBonus = versatilityDamageDoneBonus;
    }

    public double getVersatilityHealingDoneBonus() {
        return mVersatilityHealingDoneBonus;
    }

    public void setVersatilityHealingDoneBonus(double versatilityHealingDoneBonus) {
        mVersatilityHealingDoneBonus = versatilityHealingDoneBonus;
    }

    public double getVersatilityDamageTakenBonus() {
        return mVersatilityDamageTakenBonus;
    }

    public void setVersatilityDamageTakenBonus(double versatilityDamageTakenBonus) {
        mVersatilityDamageTakenBonus = versatilityDamageTakenBonus;
    }

    public double getAvoidanceRating() {
        return mAvoidanceRating;
    }

    public void setAvoidanceRating(double avoidanceRating) {
        mAvoidanceRating = avoidanceRating;
    }

    public double getAvoidanceRatingBonus() {
        return mAvoidanceRatingBonus;
    }

    public void setAvoidanceRatingBonus(double avoidanceRatingBonus) {
        mAvoidanceRatingBonus = avoidanceRatingBonus;
    }

    public double getSpellPen() {
        return mSpellPen;
    }

    public void setSpellPen(double spellPen) {
        mSpellPen = spellPen;
    }

    public double getSpellCrit() {
        return mSpellCrit;
    }

    public void setSpellCrit(double spellCrit) {
        mSpellCrit = spellCrit;
    }

    public double getSpellCritRating() {
        return mSpellCritRating;
    }

    public void setSpellCritRating(double spellCritRating) {
        mSpellCritRating = spellCritRating;
    }

    public double getMana5() {
        return mMana5;
    }

    public void setMana5(double mana5) {
        mMana5 = mana5;
    }

    public double getMana5Combat() {
        return mMana5Combat;
    }

    public void setMana5Combat(double mana5Combat) {
        mMana5Combat = mana5Combat;
    }

    public double getArmor() {
        return mArmor;
    }

    public void setArmor(double armor) {
        mArmor = armor;
    }

    public double getDodge() {
        return mDodge;
    }

    public void setDodge(double dodge) {
        mDodge = dodge;
    }

    public double getDodgeRating() {
        return mDodgeRating;
    }

    public void setDodgeRating(double dodgeRating) {
        mDodgeRating = dodgeRating;
    }

    public double getParry() {
        return mParry;
    }

    public void setParry(double parry) {
        mParry = parry;
    }

    public double getParryRating() {
        return mParryRating;
    }

    public void setParryRating(double parryRating) {
        mParryRating = parryRating;
    }

    public double getBlock() {
        return mBlock;
    }

    public void setBlock(double block) {
        mBlock = block;
    }

    public double getBlockRating() {
        return mBlockRating;
    }

    public void setBlockRating(double blockRating) {
        mBlockRating = blockRating;
    }

    public double getMainHandDmgMin() {
        return mMainHandDmgMin;
    }

    public void setMainHandDmgMin(double mainHandDmgMin) {
        mMainHandDmgMin = mainHandDmgMin;
    }

    public double getMainHandDmgMax() {
        return mMainHandDmgMax;
    }

    public void setMainHandDmgMax(double mainHandDmgMax) {
        mMainHandDmgMax = mainHandDmgMax;
    }

    public double getMainHandSpeed() {
        return mMainHandSpeed;
    }

    public void setMainHandSpeed(double mainHandSpeed) {
        mMainHandSpeed = mainHandSpeed;
    }

    public double getMainHandDps() {
        return mMainHandDps;
    }

    public void setMainHandDps(double mainHandDps) {
        mMainHandDps = mainHandDps;
    }

    public double getOffHandDmgMin() {
        return mOffHandDmgMin;
    }

    public void setOffHandDmgMin(double offHandDmgMin) {
        mOffHandDmgMin = offHandDmgMin;
    }

    public double getOffHandDmgMax() {
        return mOffHandDmgMax;
    }

    public void setOffHandDmgMax(double offHandDmgMax) {
        mOffHandDmgMax = offHandDmgMax;
    }

    public double getOffHandSpeed() {
        return mOffHandSpeed;
    }

    public void setOffHandSpeed(double offHandSpeed) {
        mOffHandSpeed = offHandSpeed;
    }

    public double getOffHandDps() {
        return mOffHandDps;
    }

    public void setOffHandDps(double offHandDps) {
        mOffHandDps = offHandDps;
    }

    public double getRangedDmgMin() {
        return mRangedDmgMin;
    }

    public void setRangedDmgMin(double rangedDmgMin) {
        mRangedDmgMin = rangedDmgMin;
    }

    public double getRangedDmgMax() {
        return mRangedDmgMax;
    }

    public void setRangedDmgMax(double rangedDmgMax) {
        mRangedDmgMax = rangedDmgMax;
    }

    public double getRangedSpeed() {
        return mRangedSpeed;
    }

    public void setRangedSpeed(double rangedSpeed) {
        mRangedSpeed = rangedSpeed;
    }

    public double getRangedDps() {
        return mRangedDps;
    }

    public void setRangedDps(double rangedDps) {
        mRangedDps = rangedDps;
    }
}
