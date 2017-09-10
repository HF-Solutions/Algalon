package org.alcha.algalona.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 * <p>Stores the values associated with a {@link Character Character's} appearance. All fields
 * are private and can only bet set from within the AlgalonA package, to prevent library users from
 * corrupting any data. A new object can be initialized by using
 * {@link #newInstanceFromJson(JsonObject)} which will parse the given {@link JsonObject} into a
 * {@link CharacterAppearance} object.</p>
 */
public class CharacterAppearance extends CharacterField {
    /** Stores the integer for the face variation of a {@link Character} **/
    private int mFaceVariation;

    /** Stores the integer for the skin color of a {@link Character} **/
    private int mSkinColor;

    /** Stores the integer for the hair variation of a {@link Character} **/
    private int mHairVariation;

    /** Stores the integer for the hair color of a {@link Character} **/
    private int mHairColor;

    /** Stores the integer for the feature variation of a {@link Character} **/
    private int mFeatureVariation;

    /** Stores the boolean that indicates if a {@link Character} has their helmet visible **/
    private boolean mShowHelm;

    /** Stores the boolean that indicates if a {@link Character} has their cloak visible **/
    private boolean mShowCloak;

    /** Stores the custom display options for a {@link Character} **/
    private int[] mCustomDisplayOptions;

    /**
     * <p>Private constructor for building a {@link CharacterAppearance}. When calling this
     * constructor, {@link #setFieldName(Name)} is called and the value is set to Achievements.</p>
     *
     * <p>Generally, this is called within the {@link #newInstanceFromJson(JsonObject)} method
     * when setting up an object to be returned.</p>
     */
    public CharacterAppearance() {
        setFieldName(Name.Achievements);
    }

    /**
     * <p>Overrides the {@link Object#toString()} method in order to provide a more useful output when
     * toString() is called instead of the object id being output. Currently, the FaceVariation,
     * SkinColor, HairVariation, HairColor, FeatureVariation, ShowHelm, ShowCloak, and
     * CustomDisplayOptions are displayed.</p>
     *
     * @return a String representation of the above mentioned fields
     */
    @Override
    public String toString() {
        String temp = "FaceVariation = " + mFaceVariation + "; SkinColor = " + mSkinColor + "; HairVariation = " + mHairVariation +
                "; HairColor = " + mHairColor + "; FeatureVariation = " + mFeatureVariation + "; ShowHelm = " + mShowHelm +
                "; ShowCloak = " + mShowCloak + "; CustomDisplayOptions = ";

        for (int option : mCustomDisplayOptions) {
            temp += option + ", ";
        }

        return temp;
    }

    /**
     * <p>Parses the provided {@link JsonObject} to determine if it has the properties available for a
     * {@link CharacterAppearance}. If any of the fields are present, they're extracted and
     * stored in the object before it is returned.</p>
     *
     * @param object JsonObject containing the CharacterAppearance
     *
     * @return a CharacterAppearance object with populated fields
     */
    public static CharacterAppearance newInstanceFromJson(JsonObject object) {
        CharacterAppearance appearance = new CharacterAppearance();

        if (object.has("faceVariation"))
            appearance.setFaceVariation(object.get("faceVariation").getAsInt());
        else appearance.setFaceVariation(-1);

        if (object.has("skinColor"))
            appearance.setSkinColor(object.get("skinColor").getAsInt());
        else appearance.setSkinColor(-1);

        if (object.has("hairVariation"))
            appearance.setHairVariation(object.get("hairVariation").getAsInt());
        else appearance.setHairVariation(-1);

        if (object.has("hairColor"))
            appearance.setHairColor(object.get("hairColor").getAsInt());
        else appearance.setHairColor(-1);

        if (object.has("featureVariation"))
            appearance.setFeatureVariation(object.get("featureVariation").getAsInt());
        else appearance.setFeatureVariation(-1);

        if (object.has("showHelm"))
            appearance.setShowHelm(object.get("showHelm").getAsBoolean());
        else appearance.setShowHelm(false);

        if (object.has("showCloak"))
            appearance.setShowCloak(object.get("showCloak").getAsBoolean());
        else appearance.setShowCloak(false);

        if (object.has("customDisplayOptions"))
            appearance.setCustomDisplayOptions(parseCustomDisplayOptions(object.getAsJsonArray("customDisplayOptions")));
        else appearance.setCustomDisplayOptions(new int[0]);

        return appearance;
    }

    /**
     * <p>Parses the given {@link JsonArray} for the custom display options and stores them in a
     * temp array. When all values have been parsed, the temp array is returned.</p>
     *
     * @param object JsonArray containing the custom display options
     *
     * @return an int array with the custom display options
     */
    public static int[] parseCustomDisplayOptions(JsonArray object) {
        int[] temp = new int[object.size()];

        for (int x = 0; x < temp.length; x++) {
            temp[x] = Integer.parseInt(object.get(x).toString());
        }

        return temp;
    }

    /**
     * <p>Gets currently stored custom display options and returns them as an int array.</p>
     *
     * @return an int array containing the WoWCharacterAppearances custom display options
     */
    public int[] getCustomDisplayOptions() {
        return mCustomDisplayOptions;
    }

    /**
     * <p>Sets the custom display options for the current {@link CharacterAppearance} to the
     * provided values.</p>
     *
     * @param customDisplayOptions an int array containing the custom display options
     */
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
