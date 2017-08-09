package org.alcha.algalona.models.wow.characters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public static WoWCharacterAppearance newInstanceFromJSON(JSONObject object) throws JSONException {
        WoWCharacterAppearance appearance = new WoWCharacterAppearance();
        appearance.setFaceVariation(object.getInt("faceVariation"));
        appearance.setSkinColor(object.getInt("skinColor"));
        appearance.setHairVariation(object.getInt("hairVariation"));
        appearance.setHairColor(object.getInt("hairColor"));
        appearance.setFeatureVariation(object.getInt("featureVariation"));
        appearance.setShowHelm(object.getBoolean("showHelm"));
        appearance.setShowCloak(object.getBoolean("showCloak"));
        appearance.setCustomDisplayOptions(parseCustomDisplayOptions(object.getJSONArray("customDisplayOptions")));
        return appearance;
    }

    private static int[] parseCustomDisplayOptions(JSONArray object) throws JSONException {
        int[] temp = new int[object.length()];

        for (int x = 0; x < temp.length; x++) {
            temp[x] = Integer.parseInt(object.get(x).toString());
        }

        return temp;
    }

    public int[] getCustomDisplayOptions() {
        return mCustomDisplayOptions;
    }

    public void setCustomDisplayOptions(int[] customDisplayOptions) {
        mCustomDisplayOptions = customDisplayOptions;
    }

    public boolean isShowCloak() {
        return mShowCloak;
    }

    public void setShowCloak(boolean showCloak) {
        mShowCloak = showCloak;
    }

    public boolean isShowHelm() {
        return mShowHelm;
    }

    public void setShowHelm(boolean showHelm) {
        mShowHelm = showHelm;
    }

    public int getFeatureVariation() {
        return mFeatureVariation;
    }

    public void setFeatureVariation(int featureVariation) {
        this.mFeatureVariation = featureVariation;
    }

    public int getHairColor() {
        return mHairColor;
    }

    public void setHairColor(int hairColor) {
        mHairColor = hairColor;
    }

    public int getHairVariation() {
        return mHairVariation;
    }

    public void setHairVariation(int hairVariation) {
        mHairVariation = hairVariation;
    }

    public int getSkinColor() {
        return mSkinColor;
    }

    public void setSkinColor(int skinColor) {
        mSkinColor = skinColor;
    }

    public int getFaceVariation() {
        return mFaceVariation;
    }

    public void setFaceVariation(int faceVariation) {
        mFaceVariation = faceVariation;
    }
}
