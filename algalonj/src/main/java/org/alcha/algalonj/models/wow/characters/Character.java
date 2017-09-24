package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.Battlegroup;
import org.alcha.algalonj.models.wow.dataResources.CharacterClass;
import org.alcha.algalonj.models.wow.Faction;
import org.alcha.algalonj.models.wow.Race;
import org.alcha.algalonj.models.wow.Realm;
import org.alcha.algalonj.models.wow.guilds.Guild;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class Character {
    private static final String LOG_TAG = "Character";
    private int mLastModified;
    private String mName;
    private Realm mRealm;
    private Battlegroup mBattlegroup;
    private CharacterClass mCharacterClass;
    private Race mRace;
    private int mGender;
    private int mLevel;
    private int mAchievementPoints;
    private String mThumbnail;
    private String mCalcClass;
    private Faction mFaction;
    private int mTotalHonorableKills;
    private Map<CharacterField.Name, CharacterField> mFieldMap;

    public Character() {
        mFieldMap = new TreeMap<>();
    }

    @Override
    public String toString() {
        return "Character = " + mName + ";Realm = " + mRealm.toString() + ";Battlegroup = " + mBattlegroup.toString();
    }

    public static Character newInstanceFromJson(JsonObject characterJson) {
        Character character = new Character();

        // Required parameters
        if (characterJson.has("lastModified"))
            character.setLastModified(characterJson.get("lastModified").getAsInt());
        else character.setLastModified(-1);

        if (characterJson.has("name"))
            character.setName(characterJson.get("name").getAsString());
        else character.setName("");

        if (characterJson.has("realm"))
            character.setRealm(Realm.fromString(characterJson.get("realm").getAsString()));
        else character.setRealm(Realm.newInstanceFromJson(new JsonObject()));

        if (characterJson.has("battlegroup"))
            character.setBattlegroup(Battlegroup.fromString(characterJson.get("battlegroup").getAsString()));
        else character.setBattlegroup(Battlegroup.fromString(""));

        if (characterJson.has("class"))
            character.setCharacterClass(CharacterClass.fromId(characterJson.get("class").getAsInt()));
        else character.setCharacterClass(CharacterClass.Unknown);

        if (characterJson.has("race"))
            character.setRace(Race.fromId(characterJson.get("race").getAsInt()));
        else character.setRace(Race.fromId(-1));

        if (characterJson.has("gender"))
            character.setGender(characterJson.get("gender").getAsInt());
        else character.setGender(-1);

        if (characterJson.has("level"))
            character.setLevel(characterJson.get("level").getAsInt());
        else character.setLevel(-1);

        if (characterJson.has("achievementPoints"))
            character.setAchievementPoints(characterJson.get("achievementPoints").getAsInt());
        else character.setAchievementPoints(-1);

        if (characterJson.has("thumbnail"))
            character.setThumbnail(characterJson.get("thumbnail").getAsString());
        else character.setThumbnail("");

        if (characterJson.has("calcClass"))
            character.setCalcClass(characterJson.get("calcClass").getAsString());
        else character.setCalcClass("");

        if (characterJson.has("faction"))
            character.setFaction(Faction.fromId(characterJson.get("faction").getAsInt()));
        else character.setFaction(Faction.UNKNOWN);

        if (characterJson.has("totalHonorableKills"))
            character.setTotalHonorableKills(characterJson.get("totalHonorableKills").getAsInt());
        else character.setTotalHonorableKills(-1);

        // Optional parameters
        character = parseOptionalCharacterFields(character, characterJson);

        return character;
    }

    /**
     * <p>Parses the given {@link JsonObject} for any possible{@link CharacterField
     * WoWCharacterFields} that may be present. If one is present, it is passed to the
     * <code>newInstanceFromJson(jsonObject)</code> method in the objects representative class (e.g.
     * {@link CharacterAppearance#newInstanceFromJson(JsonObject)},
     * {@link Guild#newInstanceFromJson(JsonObject)}, or
     * {@link CharacterAchievements#newInstanceFromJson(JsonObject)}) and added to the provided
     * {@link Character}.</p>
     *
     * <p>After all possible options are tested for their existence, the class is returned with the
     * updated fields.</p>
     *
     * @param character     Character object you wish fields to
     * @param characterJson JsonObject that potentially contains one or more character fields
     *
     * @return the provided class with any modifications if any are made
     */
    private static Character parseOptionalCharacterFields(Character character, JsonObject characterJson) {

        if (characterJson.has("achievements"))
            character.addField(CharacterAchievements.newInstanceFromJson(characterJson.getAsJsonObject("achievements")));

        if (characterJson.has("appearance"))
            character.addField(CharacterAppearance.newInstanceFromJson(characterJson.getAsJsonObject("appearance")));

        if (characterJson.has("feed"))
            character.addField(CharacterFeed.newInstanceFromJson(characterJson.getAsJsonArray("feed")));

        if (characterJson.has("guild") && characterJson.get("guild") instanceof JsonObject)
            character.addField(CharacterGuild.newInstanceFromJson(characterJson.getAsJsonObject("guild")));
        else if (characterJson.has("guild") && characterJson.has("guildRealm")) {
            // Most likely a response from the /wow/guild/:realm/:guildname endpoint
            CharacterGuild guild = new CharacterGuild();
            guild.setGuildName(characterJson.get("guild").getAsString());
            guild.setGuildRealm(Realm.fromString(characterJson.get("guildRealm").getAsString()));
            character.addField(guild);
        }

        if (characterJson.has("hunterPets"))
            character.addField(CharacterHunterPets.newInstanceFromJson(characterJson.getAsJsonObject("hunterPets")));

        if (characterJson.has("items"))
            character.addField(CharacterItems.newInstanceFromJson(characterJson.getAsJsonObject("items")));

        if (characterJson.has("mounts"))
            character.addField(CharacterMounts.newInstanceFromJson(characterJson.getAsJsonObject("mounts")));

        if (characterJson.has("pets"))
            character.addField(CharacterPets.newInstanceFromJson(characterJson.getAsJsonObject("pets")));

        if (characterJson.has("petSlots"))
            character.addField(CharacterPetSlots.newInstanceFromJson(characterJson.getAsJsonObject("petSlots")));

        if (characterJson.has("professions"))
            character.addField(CharacterProfessions.newInstanceFromJson(characterJson.getAsJsonObject("professions")));

        if (characterJson.has("progression"))
            character.addField(CharacterProgression.newInstanceFromJson(characterJson.getAsJsonObject("progression")));

        if (characterJson.has("pvp"))
            character.addField(CharacterPvP.newInstanceFromJson(characterJson.getAsJsonObject("pvp")));

        if (characterJson.has("quests"))
            character.addField(CharacterQuests.newInstanceFromJson(characterJson.getAsJsonObject("quests")));

        if (characterJson.has("reputation"))
            character.addField(CharacterReputation.newInstanceFromJson(characterJson.getAsJsonObject("reputation")));

        if (characterJson.has("statistics"))
            character.addField(CharacterStatistics.newInstanceFromJson(characterJson.getAsJsonObject("statistics")));

        if (characterJson.has("stats"))
            character.addField(CharacterStats.newInstanceFromJson(characterJson.getAsJsonObject("stats")));

        if (characterJson.has("talents"))
            character.addField(CharacterTalents.newInstanceFromJson(characterJson.getAsJsonArray("talents")));

        if (characterJson.has("titles"))
            character.addField(CharacterTitles.newInstanceFromJson(characterJson.getAsJsonArray("titles")));

        if (characterJson.has("audit"))
            character.addField(CharacterAudit.newInstanceFromJson(characterJson.getAsJsonObject("audit")));

        return character;
    }

    public int getLastModified() {
        return mLastModified;
    }

    public void setLastModified(int lastModified) {
        mLastModified = lastModified;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Realm getRealm() {
        return mRealm;
    }

    public void setRealm(Realm realm) {
        mRealm = realm;
    }

    public Battlegroup getBattlegroup() {
        return mBattlegroup;
    }

    public void setBattlegroup(Battlegroup battlegroup) {
        mBattlegroup = battlegroup;
    }

    public CharacterClass getCharacterClass() {
        return mCharacterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        mCharacterClass = characterClass;
    }

    public Race getRace() {
        return mRace;
    }

    public void setRace(Race race) {
        mRace = race;
    }

    public int getGender() {
        return mGender;
    }

    public void setGender(int gender) {
        mGender = gender;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getAchievementPoints() {
        return mAchievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        mAchievementPoints = achievementPoints;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getCalcClass() {
        return mCalcClass;
    }

    public void setCalcClass(String calcClass) {
        mCalcClass = calcClass;
    }

    public Faction getFaction() {
        return mFaction;
    }

    public void setFaction(Faction faction) {
        mFaction = faction;
    }

    public int getTotalHonorableKills() {
        return mTotalHonorableKills;
    }

    public void setTotalHonorableKills(int totalHonorableKills) {
        mTotalHonorableKills = totalHonorableKills;
    }

    public void addField(CharacterField characterField) {
        mFieldMap.put(characterField.getFieldName(), characterField);
    }

    public boolean hasField(CharacterField.Name fieldName) {
        return mFieldMap.containsKey(fieldName);
    }

    @SuppressWarnings("unchecked")
    public <T extends CharacterField> T getField(CharacterField.Name fieldName) {
        return (T) mFieldMap.get(fieldName);
    }

    public void addFields(Map<CharacterField.Name, CharacterField> fieldMap) {
        mFieldMap.putAll(fieldMap);
    }

    public Map<CharacterField.Name, CharacterField> getFields() {
        return mFieldMap;
    }
}

