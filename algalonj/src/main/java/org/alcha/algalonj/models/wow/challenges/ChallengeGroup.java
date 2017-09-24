package org.alcha.algalonj.models.wow.challenges;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.Faction;
import org.alcha.algalonj.models.wow.Time;
import org.alcha.algalonj.models.wow.characters.Character;
import org.alcha.algalonj.models.wow.guilds.Guild;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 14:40.</p>
 *
 * <p>As far as I'm aware, the Challenge API is no longer active, but the endpoint still exists to
 * retrieve old data so I've added classes to parse it. Each attempted challenge has a group
 * associated with it. This object stores the information related to those groups.</p>
 *
 * <p>Contains a static method {@link #newInstanceFromJson(JsonObject)} for creating a new object
 * using a {@link JsonObject}. This is usually obtained from the Battle.net API using a {@link
 * org.alcha.algalonj.network.WoWCommunityRequest}.</p>
 */
public class ChallengeGroup {
    /** Ranking of the group (1, 2, 3) */
    private int mRanking;

    /** Stores the completed time of the run */
    private Time mTime;

    /** Stores the date in String format */
    private String mDate;

    /** Stores the faction of the group */
    private Faction mFaction;

    /** Not entirely sure what this is for */
    private boolean mIsRecurring;

    /** List of members in the group */
    private List<Character> mMembers;

    /** Guild object of the guild that ran the group */
    private Guild mGuild;

    /**
     * <p>Default empty constructor for a {@link ChallengeGroup}. This stores no information upon
     * creation, so only use this if you know what you're doing or don't mind tinkering until you
     * figure it out.</p>
     *
     * <p>It is recommended to use the {@link #newInstanceFromJson(JsonObject)} method which will
     * parse a {@link JsonObject} and populate the group fields using the data within the object.
     * If you wish to build it manually, use the various setter methods to build the object to your
     * content.</p>
     */
    public ChallengeGroup() {

    }

    public static ChallengeGroup newInstanceFromJson(JsonObject jsonObject) {
        ChallengeGroup group = new ChallengeGroup();

        if (jsonObject.has("ranking"))
            group.setRanking(jsonObject.get("ranking").getAsInt());
        else group.setRanking(-1);

        if (jsonObject.has("time"))
            group.setTime(Time.newInstanceFromJson(jsonObject.getAsJsonObject("time")));
        else group.setTime(new Time());

        if (jsonObject.has("date"))
            group.setDate(jsonObject.get("date").getAsString());
        else group.setDate("");

        if (jsonObject.has("faction"))
            group.setFaction(Faction.fromString(jsonObject.get("faction").getAsString()));
        else group.setFaction(Faction.UNKNOWN);

        if (jsonObject.has("isRecurring"))
            group.setRecurring(jsonObject.get("isRecurring").getAsBoolean());
        else group.setRecurring(false);

        if (jsonObject.has("members")) {
            List<Character> members = new ArrayList<>();
            for (JsonElement element : jsonObject.getAsJsonArray("members"))
                members.add(Character.newInstanceFromJson(element.getAsJsonObject()));

            group.setMembers(members);
        }

        if (jsonObject.has("guild"))
            group.setGuild(Guild.newInstanceFromJson(jsonObject.getAsJsonObject("guild")));
        else group.setGuild(new Guild());

        return group;
    }

    public int getRanking() {
        return mRanking;
    }

    public void setRanking(int ranking) {
        mRanking = ranking;
    }

    public Time getTime() {
        return mTime;
    }

    public void setTime(Time time) {
        mTime = time;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public Faction getFaction() {
        return mFaction;
    }

    public void setFaction(Faction faction) {
        mFaction = faction;
    }

    public boolean isRecurring() {
        return mIsRecurring;
    }

    public void setRecurring(boolean recurring) {
        mIsRecurring = recurring;
    }

    public List<Character> getMembers() {
        return mMembers;
    }

    public void setMembers(List<Character> members) {
        mMembers = members;
    }

    public Guild getGuild() {
        return mGuild;
    }

    public void setGuild(Guild guild) {
        mGuild = guild;
    }
}
