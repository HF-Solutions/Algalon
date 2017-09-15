package org.alcha.algalona.models.wow.challenges;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.alcha.algalona.models.wow.Faction;
import org.alcha.algalona.models.wow.Time;
import org.alcha.algalona.models.wow.characters.Character;
import org.alcha.algalona.models.wow.guilds.Guild;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 14:40.</p>
 */

public class ChallengeGroup {
    private int mRanking;
    private Time mTime;
    private String mDate;
    private Faction mFaction;
    private boolean mIsRecurring;
    private List<Character> mMembers;
    private Guild mGuild;

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
