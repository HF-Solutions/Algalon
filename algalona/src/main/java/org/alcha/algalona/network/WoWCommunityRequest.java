package org.alcha.algalona.network;

import com.google.gson.JsonObject;
import com.squareup.okhttp.Request;

import org.alcha.algalona.interfaces.APIRequest;
import org.alcha.algalona.interfaces.FieldName;
import org.alcha.algalona.interfaces.RequestCallback;
import org.alcha.algalona.models.wow.AuctionData;
import org.alcha.algalona.models.wow.AuctionIndex;
import org.alcha.algalona.models.wow.PvPBrackets;
import org.alcha.algalona.models.wow.Realm;
import org.alcha.algalona.models.wow.characters.Character;
import org.alcha.algalona.models.wow.characters.CharacterField;
import org.alcha.algalona.models.wow.guilds.GuildField;

import static org.alcha.algalona.network.AlgalonClient.get;

/**
 * <p>Created by Alcha on 8/7/2017.</p>
 */
public class WoWCommunityRequest implements APIRequest {
    private static final String LOG_TAG = "WoWCommunityRequest";
    private String mRelativeUrl = "/wow";
    private Request mRequest;

    /**
     * <p>Empty constructor used for building a custom {@link WoWCommunityRequest}.</p>
     *
     * <p>Use with caution and ensure proper fields and parameters are used if the type unsafe
     * methods are called, such as {@link #appendParameter(String)} or
     * {@link #appendField(String)}. If an invalid parameter or field is provided, an
     * error will not be thrown until runtime since the validity of the URL isn't checked at compile
     * time.</p>
     *
     * <p>To build your own request, instantiate a {@link WoWCommunityRequest} and add the parameters and/or
     * fields you wish to add. For example, if you wish to find a character on a realm that isn't
     * currently in the {@link WoWUSRealms} or {@link WoWEURealms} enum objects, you would want to
     * do something like the so:</p>
     *
     * <code>
     * AlgalonClient algalon = AlgalonClient.newUSInstance("Secret Blizzard Key");<br/><br/>
     *
     * WoWCommunityRequest request = new WoWCommunityRequest();<br/>
     * request.appendParameter("character")<br/>
     * &#9;     .appendParameter("RealmName")<br/>
     * &#9;     .appendParameter("CharacterName");<br/><br/>
     *
     * algalon.executeRequest(request, new RequestCallback() {<br/>
     * &#9;@Override<br/>
     * &#9;public void onTaskCompleted(JSONObject response) {<br/>
     * &#9;&#9;Log.d(LOG_TAG, "response = " + response.toString());<br/>
     * &#9;}<br/>
     * });
     * </code>
     */
    private WoWCommunityRequest() {
    }

    /**
     * <p>Returns the relative URL of the {@link WoWCommunityRequest} at the point of execution. The relative
     * URL is used in conjunction with an {@link AlgalonClient} to completely assemble a URL for
     * execution.</p>
     *
     * @return String value of the relative URL
     */
    @Override
    public String getRelativeUrl() {
        return mRelativeUrl;
    }


    /**
     * <p>Appends a type safe {@link FieldName} to the current {@link WoWCommunityRequest} and returns it.</p>
     *
     * @param fieldName FieldName of the field you want to append
     *
     * @return The current WoWCommunityRequest object with the provided field appended
     */
    public WoWCommunityRequest appendField(FieldName fieldName) {
        if (mRelativeUrl.contains("?")) {
            mRelativeUrl += "%2C" + fieldName.getSlug();
        } else {
            mRelativeUrl += "?fields=" + fieldName.getSlug();
        }

        return this;
    }

    /**
     * <p>Appends a type unsafe String representation of a {@link FieldName} to the current
     * {@link WoWCommunityRequest} and returns it.</p>
     *
     * <p><i>NOTE: The provided field name is converted to lowercase.</i></p>
     *
     * @param fieldName String of the field you wish to append
     *
     * @return The current WoWCommunityRequest object with the provided field name appended
     */
    public WoWCommunityRequest appendField(String fieldName) {
        if (mRelativeUrl.contains("?")) {
            mRelativeUrl += "%2C" + fieldName.toLowerCase();
        } else {
            mRelativeUrl += "?fields=" + fieldName.toLowerCase();
        }

        return this;
    }

    public WoWCommunityRequest appendField(String fieldName, String value) {
        if (mRelativeUrl.contains("?"))
            mRelativeUrl += "&" + fieldName + "=" + value;
        else mRelativeUrl += "?" + fieldName + "=" + value;

        return this;
    }

    /**
     * <p>Appends the provided String to the end of the current relative URL. The parameter will
     * have any spaces replaced with %20, and commas with %2C so they're safe for use in a URL.</p>
     *
     * @param parameter String typed parameter
     *
     * @return The current WoWCommunityRequest object with the provided parameter appended
     */
    public WoWCommunityRequest appendParameter(String parameter) {
        mRelativeUrl += "/" + parameter.replace(" ", "%20").replace(",", "%2C");
        return this;
    }

    /**
     * <p>Uses the provided achievement id to retrieve the information for the achievement
     * associated with it.</p>
     *
     * @param achievementId achievement id as an int
     *
     * @return A WoWCommunityRequest to be executed for achievement data
     */
    public static WoWCommunityRequest getAchievement(int achievementId) {
        WoWCommunityRequest request = new WoWCommunityRequest();
        request.appendParameter("achievement").appendParameter(String.valueOf(achievementId));
        return request;
    }

    /**
     * <p>Gets the auction index file for the provided {@link Realm}. The index file contains the
     * url to the file that contains the latest auction data in JSON.</p>
     *
     * <p>In order to obtain the actual auction data for the realm of interest, you must execute this
     * request and pass the response to {@link #getAuctionData(AuctionIndex, RequestCallback)}. The
     * getAuctionData(JSONObject, RequestCallback) method will return the auction data as an instance of
     * {@link AuctionData}.</p>
     *
     * @param realm Realm you wish to retrieve the index file for
     *
     * @return A WoWCommunityRequest to be executed for a realms auction data index file
     */
    public static WoWCommunityRequest getAuctionIndexFile(Realm realm) {
        return new WoWCommunityRequest()
                .appendParameter("auction")
                .appendParameter("data")
                .appendParameter(realm.getRelativeUrl());
    }

    public static void getAuctionDataFile(AuctionIndex auctionIndex, RequestCallback requestCallback) {
        get(auctionIndex.getUrl(), requestCallback);
    }

    /**
     * <p>Uses the provided {@link JsonObject} to retrieve the latest auction index file which contains
     * the latest auctions available on the queried realm and connected realms.</p>
     *
     * TODO: Parse the JSON Object for the proper URL and execute it
     *
     * @param auctionIndex result of executing {@link #getAuctionIndexFile(Realm)}
     */
    public static void getAuctionData(AuctionIndex auctionIndex, RequestCallback requestCallback) {
        get(auctionIndex.getUrl(), requestCallback);
    }

    /**
     * <p>Gets a list of all supported bosses. A 'boss' in this context should be considered a boss
     * encounter, which may include more than one NPC.</p>
     *
     * @return A WoWCommunityRequest to be executed for retrieving a list of all supported bosses
     */
    public static WoWCommunityRequest getBossMasterList() {
        return new WoWCommunityRequest().appendParameter("boss/");
    }

    /**
     * <p>Gets the data for the boss with the provided id. A 'boss' in this context should be
     * considered a boss encounter, which may include more than one NPC.</p>
     *
     * @param id int id of the boss you wish to query
     *
     * @return A WoWCommunityRequest to be executed for retrieving data about a given boss
     */
    public static WoWCommunityRequest getBoss(int id) {
        return new WoWCommunityRequest()
                .appendParameter("boss")
                .appendParameter(String.valueOf(id));
    }

    /**
     * <p>Gets a basic dataset for a {@link Character} on the provided {@link Realm}.</p>
     *
     * <p>To access further information about a character, utilize the
     * {@link #getCharacterProfileFields(Realm, String, CharacterField.Name[])
     * getCharacterProfileFields()} method and provide the an array of
     * {@link CharacterField.Name} for the fields you want to retrieve.</p>
     *
     * @param realm         WoWRealm where the character is located
     * @param characterName name of the character you wish to retrieve
     *
     * @return A WoWCommunityRequest to be executed for a characters profile
     */
    public static WoWCommunityRequest getCharacterProfile(Realm realm, String characterName) {
        return new WoWCommunityRequest()
                .appendParameter("character")
                .appendParameter(realm.getRelativeUrl())
                .appendParameter(characterName);
    }

    public static WoWCommunityRequest getCharacterProfileFields(Realm realm, String characterName, CharacterField.Name[] fieldNames) {
        WoWCommunityRequest request = WoWCommunityRequest.getCharacterProfile(realm, characterName);

        System.out.println("RelativeUrl A = " + request.getRelativeUrl());

        for (CharacterField.Name fieldName : fieldNames) {
            request.appendField(fieldName);
        }

        System.out.println("RelativeUrl B = " + request.getRelativeUrl());

        return request;
    }

    public static WoWCommunityRequest getGuildProfile(Realm realm, String guildName) {
        return new WoWCommunityRequest()
                .appendParameter("guild")
                .appendParameter(realm.getRelativeUrl())
                .appendParameter(guildName);
    }

    public static WoWCommunityRequest getGuildProfileFields(Realm realm, String guildName, GuildField.Name[] fieldNames) {
        WoWCommunityRequest request = getGuildProfile(realm, guildName);

        for (FieldName fieldName : fieldNames) {
            request.appendField(fieldName);
        }

        return request;
    }

    public static WoWCommunityRequest getItem(int itemId) {
        return new WoWCommunityRequest()
                .appendParameter("item")
                .appendParameter(String.valueOf(itemId));
    }

    public static WoWCommunityRequest getItemSet(int setId) {
        return new WoWCommunityRequest()
                .appendParameter("item")
                .appendParameter("set")
                .appendParameter(String.valueOf(setId));
    }

    public static WoWCommunityRequest getMountList() {
        return new WoWCommunityRequest().appendParameter("mount/");
    }

    public static WoWCommunityRequest getPetList() {
        return new WoWCommunityRequest().appendParameter("pet/");
    }

    public static WoWCommunityRequest getPetAbility(int abilityId) {
        return new WoWCommunityRequest()
                .appendParameter("pet")
                .appendParameter("ability")
                .appendParameter(String.valueOf(abilityId));
    }

    public static WoWCommunityRequest getPetSpecies(int speciesId) {
        return new WoWCommunityRequest()
                .appendParameter("pet")
                .appendParameter("species")
                .appendParameter(String.valueOf(speciesId));
    }

    public static WoWCommunityRequest getPetStats(int speciesId) {
        return new WoWCommunityRequest()
                .appendParameter("pet")
                .appendParameter("stats")
                .appendParameter(String.valueOf(speciesId));
    }

    public static WoWCommunityRequest getPvPLeaderboards(PvPBrackets bracket) {
        return new WoWCommunityRequest()
                .appendParameter("leaderboard")
                .appendParameter(bracket.getName());
    }

    public static WoWCommunityRequest getQuest(int questId) {
        return new WoWCommunityRequest()
                .appendParameter("quest")
                .appendParameter(String.valueOf(questId));
    }

    public static WoWCommunityRequest getRealmStatus() {
        return new WoWCommunityRequest()
                .appendParameter("realm")
                .appendParameter("status");
    }

    public static WoWCommunityRequest getRecipe(int recipeId) {
        return new WoWCommunityRequest()
                .appendParameter("recipe")
                .appendParameter(String.valueOf(recipeId));
    }

    public static WoWCommunityRequest getSpell(int spellId) {
        return new WoWCommunityRequest()
                .appendParameter("spell")
                .appendParameter(String.valueOf(spellId));
    }

    public static WoWCommunityRequest getZoneList() {
        return new WoWCommunityRequest().appendParameter("zone/");
    }

    public static WoWCommunityRequest getZone(int zoneId) {
        return new WoWCommunityRequest()
                .appendParameter("zone")
                .appendParameter(String.valueOf(zoneId));
    }

    public static WoWCommunityRequest getBattlegroupsData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("battlegroups/");
    }

    public static WoWCommunityRequest getCharacterRacesData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("character")
                .appendParameter("races");
    }

    public static WoWCommunityRequest getCharacterClassesData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("character")
                .appendParameter("classes");
    }

    public static WoWCommunityRequest getCharacterAchievementsData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("character")
                .appendParameter("achievements");
    }

    public static WoWCommunityRequest getGuildRewardsData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("guild")
                .appendParameter("rewards");
    }

    public static WoWCommunityRequest getGuildPerksData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("guild")
                .appendParameter("perks");
    }

    public static WoWCommunityRequest getGuildAchievementsData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("guild")
                .appendParameter("achievements");
    }

    public static WoWCommunityRequest getItemClassesData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("item")
                .appendParameter("classes");
    }

    public static WoWCommunityRequest getTalentsData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("talents");
    }

    public static WoWCommunityRequest getPetTypesData() {
        return new WoWCommunityRequest()
                .appendParameter("data")
                .appendParameter("pet")
                .appendParameter("types");
    }
}
