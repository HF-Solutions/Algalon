package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWCharacterAppearance extends WoWCharacterField {
    private int mFaceVariation,
            mSkinColor,
            mHairVariation,
            mHairColor,
            mFeatureVariation;
    private boolean mShowHelm,
            mShowCloak;
    private int[] mCustomDisplayOptions;

    private WoWCharacterAppearance() {
        setFieldName(Name.Achievements);
    }

    public static WoWCharacterAppearance newInstance() {
        return new WoWCharacterAppearance();
    }

    public static WoWCharacterAppearance newInstanceFromJSON(JsonObject object) {
        WoWCharacterAppearance appearance = new WoWCharacterAppearance();
        appearance.setFaceVariation(object.get("faceVariation").getAsInt());
        appearance.setSkinColor(object.get("skinColor").getAsInt());
        appearance.setHairVariation(object.get("hairVariation").getAsInt());
        appearance.setHairColor(object.get("hairColor").getAsInt());
        appearance.setFeatureVariation(object.get("featureVariation").getAsInt());
        appearance.setShowHelm(object.get("showHelm").getAsBoolean());
        appearance.setShowCloak(object.get("showCloak").getAsBoolean());
        appearance.setCustomDisplayOptions(parseCustomDisplayOptions(object.getAsJsonArray("customDisplayOptions")));
        return appearance;
    }

    private static int[] parseCustomDisplayOptions(JsonArray object) {
        int[] temp = new int[object.size()];

        for (int x = 0; x < temp.length; x++) {
            temp[x] = Integer.parseInt(object.get(x).toString());
        }

        return temp;
    }

    public int[] getCustomDisplayOptions() {
        return mCustomDisplayOptions;
    }

    void setCustomDisplayOptions(int[] customDisplayOptions) {
        mCustomDisplayOptions = customDisplayOptions;
    }

    public boolean isShowCloak() {
        return mShowCloak;
    }

    void setShowCloak(boolean showCloak) {
        mShowCloak = showCloak;
    }

    public boolean isShowHelm() {
        return mShowHelm;
    }

    void setShowHelm(boolean showHelm) {
        mShowHelm = showHelm;
    }

    public int getFeatureVariation() {
        return mFeatureVariation;
    }

    void setFeatureVariation(int featureVariation) {
        this.mFeatureVariation = featureVariation;
    }

    public int getHairColor() {
        return mHairColor;
    }

    void setHairColor(int hairColor) {
        mHairColor = hairColor;
    }

    public int getHairVariation() {
        return mHairVariation;
    }

    void setHairVariation(int hairVariation) {
        mHairVariation = hairVariation;
    }

    public int getSkinColor() {
        return mSkinColor;
    }

    void setSkinColor(int skinColor) {
        mSkinColor = skinColor;
    }

    public int getFaceVariation() {
        return mFaceVariation;
    }

    void setFaceVariation(int faceVariation) {
        mFaceVariation = faceVariation;
    }
}
