package org.alcha.algalona.models.wow.characters;

import android.util.Log;

import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.WoWCharacterClass;
import org.alcha.algalona.models.wow.WoWFaction;
import org.alcha.algalona.models.wow.WoWRace;
import org.alcha.algalona.models.wow.battlegroups.WoWBattlegroup;
import org.alcha.algalona.models.wow.battlegroups.WoWUSBattlegroups;
import org.alcha.algalona.models.wow.guilds.WoWGuild;
import org.alcha.algalona.models.wow.realms.WoWRealm;
import org.alcha.algalona.models.wow.realms.WoWUSRealms;

import java.util.TreeMap;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWCharacter {
    private static final String LOG_TAG = "WoWCharacter";
    private int mLastModified;
    private String mName;
    private WoWRealm mRealm;
    private WoWBattlegroup mBattlegroup;
    private WoWCharacterClass mCharacterClass;
    private WoWRace mRace;
    private int mGender;
    private int mLevel;
    private int mAchievementPoints;
    private String mThumbnail;
    private String mCalcClass;
    private WoWFaction mFaction;
    private int mTotalHonorableKills;
    private TreeMap<WoWCharacterField.Name, WoWCharacterField> mFieldMap;

    private WoWCharacter() {
        mFieldMap = new TreeMap<>();
    }

    @Override
    public String toString() {
        return "Character = " + mName + "; Realm = " + mRealm.toString() + "; Battlegroup = " + mBattlegroup.toString();
    }

    public static WoWCharacter newInstanceFromJson(JsonObject characterJson) {
        WoWCharacter character = new WoWCharacter();

        // Required parameters
        if (characterJson.has("lastModified"))
            character.setLastModified(characterJson.get("lastModified").getAsInt());

        if (characterJson.has("name"))
            character.setName(characterJson.get("name").getAsString());

        if (characterJson.has("realm"))
            character.setRealm(WoWUSRealms.fromString(characterJson.get("realm").getAsString()));

        if (characterJson.has("battlegroup"))
            character.setBattlegroup(WoWUSBattlegroups.valueOf(characterJson.get("battlegroup").getAsString()));

        if (characterJson.has("class"))
            character.setCharacterClass(WoWCharacterClass.fromId(characterJson.get("class").getAsInt()));

        if (characterJson.has("race"))
            character.setRace(WoWRace.fromId(characterJson.get("race").getAsInt()));

        if (characterJson.has("gender"))
            character.setGender(characterJson.get("gender").getAsInt());

        if (characterJson.has("level"))
            character.setLevel(characterJson.get("level").getAsInt());

        if (characterJson.has("achievementPoints"))
            character.setAchievementPoints(characterJson.get("achievementPoints").getAsInt());

        if (characterJson.has("thumbnail"))
            character.setThumbnail(characterJson.get("thumbnail").getAsString());

        if (characterJson.has("calcClass"))
            character.setCalcClass(characterJson.get("calcClass").getAsString());

        if (characterJson.has("faction"))
            character.setFaction(WoWFaction.fromId(characterJson.get("faction").getAsInt()));

        if (characterJson.has("totalHonorableKills"))
            character.setTotalHonorableKills(characterJson.get("totalHonorableKills").getAsInt());

        // Optional parameters
        character = parseOptionalCharacterFields(character, characterJson);

        return character;
    }

    /**
     * <p>Parses the given {@link JsonObject} for any possible{@link WoWCharacterField
     * WoWCharacterFields} that may be present. If one is present, it is passed to the
     * <code>newInstanceFromJson(jsonObject)</code> method in the objects representative class (e.g.
     * {@link WoWCharacterAppearance#newInstanceFromJson(JsonObject)},
     * {@link WoWGuild#newInstanceFromJson(JsonObject)}, or
     * {@link WoWCharacterAchievements#newInstanceFromJson(JsonObject)}) and added to the provided
     * {@link WoWCharacter}.</p>
     *
     * <p>After all possible options are tested for their existence, the class is returned with the
     * updated fields.</p>
     *
     * @param character     WoWCharacter object you wish fields to
     * @param characterJson JsonObject that potentially contains one or more character fields
     *
     * @return the provided class with any modifications if any are made
     */
    private static WoWCharacter parseOptionalCharacterFields(WoWCharacter character, JsonObject characterJson) {

        if (characterJson.has("achievements"))
            character.addField(WoWCharacterAchievements.newInstanceFromJson(characterJson.getAsJsonObject("achievements")));

        if (characterJson.has("appearance"))
            character.addField(WoWCharacterAppearance.newInstanceFromJson(characterJson.getAsJsonObject("appearance")));

        if (characterJson.has("feed"))
            character.addField(WoWCharacterFeed.newInstanceFromJson(characterJson.getAsJsonArray("feed")));

        if (characterJson.has("guild"))
            character.addField(WoWCharacterGuild.newInstanceFromJson(characterJson.getAsJsonObject("guild")));

        if (characterJson.has("hunterPets"))
            Log.d(LOG_TAG, "newInstanceFromJson: hunterPets != null");

        if (characterJson.has("items"))
            Log.d(LOG_TAG, "newInstanceFromJson: items != null");
        if (characterJson.has("mounts"))
            Log.d(LOG_TAG, "newInstanceFromJson: mounts != null");
        if (characterJson.has("pets"))
            Log.d(LOG_TAG, "newInstanceFromJson: pets != null");
        if (characterJson.has("petSlots"))
            Log.d(LOG_TAG, "newInstanceFromJson: petSlots != null");
        if (characterJson.has("professions"))
            Log.d(LOG_TAG, "newInstanceFromJson: professions != null");
        if (characterJson.has("progression"))
            Log.d(LOG_TAG, "newInstanceFromJson: progression != null");
        if (characterJson.has("pvp"))
            Log.d(LOG_TAG, "newInstanceFromJson: pvp != null");
        if (characterJson.has("quests"))
            Log.d(LOG_TAG, "newInstanceFromJson: quests != null");
        if (characterJson.has("reputation"))
            Log.d(LOG_TAG, "newInstanceFromJson: reputation != null");
        if (characterJson.has("statistics"))
            Log.d(LOG_TAG, "newInstanceFromJson: statistics != null");
        if (characterJson.has("stats"))
            Log.d(LOG_TAG, "newInstanceFromJson: stats != null");
        if (characterJson.has("talents"))
            Log.d(LOG_TAG, "newInstanceFromJson: talents != null");
        if (characterJson.has("titles"))
            Log.d(LOG_TAG, "newInstanceFromJson: titles != null");
        if (characterJson.has("audit"))
            Log.d(LOG_TAG, "newInstanceFromJson: audit != null");

        return character;
    }

    private void addField(WoWCharacterField characterField) {
        Log.d(LOG_TAG, "addField: characterField.getFieldName() = " + characterField.getFieldName());
        Log.d(LOG_TAG, "addField: characterField = " + characterField);

        mFieldMap.put(characterField.getFieldName(), characterField);
    }

    public WoWCharacterField getField(WoWCharacterField.Name characterField) {
        return mFieldMap.get(characterField);
    }

    public int getTotalHonorableKills() {
        return mTotalHonorableKills;
    }

    void setTotalHonorableKills(int totalHonorableKills) {
        mTotalHonorableKills = totalHonorableKills;
    }

    public String getCalcClass() {
        return mCalcClass;
    }

    void setCalcClass(String calcClass) {
        mCalcClass = calcClass;
    }

    public WoWFaction getFaction() {
        return mFaction;
    }

    void setFaction(WoWFaction faction) {
        mFaction = faction;
    }

    public int getLastModified() {
        return mLastModified;
    }

    void setLastModified(int lastModified) {
        mLastModified = lastModified;
    }

    public String getName() {
        return mName;
    }

    void setName(String name) {
        mName = name;
    }

    public WoWRealm getRealm() {
        return mRealm;
    }

    void setRealm(WoWRealm realm) {
        mRealm = realm;
    }

    public WoWBattlegroup getBattlegroup() {
        return mBattlegroup;
    }

    void setBattlegroup(WoWBattlegroup battlegroup) {
        mBattlegroup = battlegroup;
    }

    public WoWCharacterClass getCharacterClass() {
        return mCharacterClass;
    }

    void setCharacterClass(WoWCharacterClass characterClass) {
        mCharacterClass = characterClass;
    }

    public WoWRace getRace() {
        return mRace;
    }

    void setRace(WoWRace race) {
        mRace = race;
    }

    public int getGender() {
        return mGender;
    }

    void setGender(int gender) {
        mGender = gender;
    }

    public int getLevel() {
        return mLevel;
    }

    void setLevel(int level) {
        mLevel = level;
    }

    public int getAchievementPoints() {
        return mAchievementPoints;
    }

    void setAchievementPoints(int achievementPoints) {
        mAchievementPoints = achievementPoints;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }
}

