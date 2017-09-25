package org.alcha.algalon.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalon.models.wow.Realm;
import org.alcha.algalon.models.wow.guilds.Guild;

import java.lang.*;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 * <p>Stores the information related to the guild that a {@link java.lang.Character WoWCharacters} is
 * in.</p>
 */
public class CharacterGuild extends CharacterField {
    private static final String LOG_TAG = "CharacterGuild";

    /** Used for the /wow/guild/:realm/:guildname members field */
    private String mGuildName;

    /** Used for the /wow/guild/:realm/:guildname members field */
    private Realm mGuildRealm;

    /** Stores the {@link org.alcha.algalon.models.wow.guilds.Guild} object for this CharacterGuild.*/
    private Guild mGuild;

    public CharacterGuild() {
        setFieldName(Name.Guild);
    }

    @Override
    public String toString() {
        return "Name = " + mGuild.getName() +
                ";Realm = " + mGuild.getRealm() +
                ";Battlegroup = " + mGuild.getBattleGroup() +
                ";AchievementPoints = " + mGuild.getAchievementPoints() + ";";
    }

    public static CharacterGuild newInstanceFromJson(JsonObject jsonObject) {
        CharacterGuild characterGuild = new CharacterGuild();
        characterGuild.setGuild(Guild.newInstanceFromJson(jsonObject));
        return characterGuild;
    }

    public Guild getGuild() {
        return mGuild;
    }

    public void setGuild(Guild guild) {
        mGuild = guild;
    }

    public String getGuildName() {
        return mGuildName;
    }

    public void setGuildName(String guildName) {
        mGuildName = guildName;
    }

    public Realm getGuildRealm() {
        return mGuildRealm;
    }

    public void setGuildRealm(Realm guildRealm) {
        mGuildRealm = guildRealm;
    }
}
