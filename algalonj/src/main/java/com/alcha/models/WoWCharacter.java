package com.alcha.models;

/**
 * Created by Alcha on 8/1/2017.
 */

public class WoWCharacter {
    private long mLastModified;
    private String mName;
    private String mRealm;
    private String mBattlegroup;
    private int mClass;
    private int mRace;
    private int mGender;
    private int mLevel;
    private int mAchievementPoints;
    private String mThumbnail;
    private String mCalcClass;
    private int mFaction;
    private int mTotalHonorableKills;

    public WoWCharacter() {
    }

    public int getTotalHonorableKills() {
        return mTotalHonorableKills;
    }

    public void setTotalHonorableKills(int totalHonorableKills) {
        mTotalHonorableKills = totalHonorableKills;
    }

    public String getCalcClass() {
        return mCalcClass;
    }

    public int getFaction() {
        return mFaction;
    }

    public void setFaction(int faction) {
        mFaction = faction;
    }
}

