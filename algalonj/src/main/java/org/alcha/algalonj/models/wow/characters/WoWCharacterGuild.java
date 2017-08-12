package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.guilds.WoWGuild;

/**
 * <p>Created by Alcha on 8/4/2017.</p>
 */

public class WoWCharacterGuild extends WoWCharacterField {
    private WoWGuild mGuild;

    private WoWCharacterGuild() {

    }

    private WoWCharacterGuild(WoWGuild guild) {
        mGuild = guild;
    }

    public static WoWCharacterGuild newInstance() {
        return new WoWCharacterGuild();
    }

    public static WoWCharacterGuild newInstance(WoWGuild guild) {
        return new WoWCharacterGuild(guild);
    }

    public static WoWCharacterGuild newInstanceFromJSON(JsonObject jsonObject) {
        WoWCharacterGuild characterGuild = new WoWCharacterGuild();

        /*try {
            WoWGuild guild = WoWGuild.newInstance();
            guild.setName(jsonObject.getString("name"));
            guild.setRealm(WoWUSRealms.fromString(jsonObject.getString("realm")));
            guild.setBattleGroup(WoWUSBattlegroups.valueOf(jsonObject.getString("battlegroup")));
            guild.setLevel(0);
            guild.setSide(0);
            guild.setAchievementPoints(0);
            guild.setEmblem(WoWGuildEmblem.fromJSON(jsonObject));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }*/

        return characterGuild;
    }
}
