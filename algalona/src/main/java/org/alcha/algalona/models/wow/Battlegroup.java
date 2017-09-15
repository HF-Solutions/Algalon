package org.alcha.algalona.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 * Interface that represents a Battlegroup in WoW. Since there's a separate list for EU and US, each
 * one has overlapping names. Instead of using one giant enum and then trying to figure out which
 * belongs where, this interface is the middleman for {@link WoWUSBattlegroups} and
 * {@link WoWEUBattlegroups}.
 */
public class Battlegroup {
    public enum Name {
        Aunz_Battle_Group("AU/NZ Battle Group"),
        Cataclysm("Cataclysm"),
        Emberstorm("Emberstorm"),
        Frenzy("Frenzy"),
        Retaliation("Retaliation"),
        Shadowburn("Shadowburn"),
        Stormstrike("Stormstrike"),
        Vindication("Vindication"),
        Whirlwind("Whirlwind"),
        Blackout("Blackout"),
        Bloodlust("Bloodlust"),
        Blutdurst("Blutdurst"),
        Cataclysme("Cataclysme"),
        Conviction("Conviction"),
        Crueldad("Crueldad"),
        Cyclone("Cyclone"),
        Ferocite("Ferocite"),
        Glutsturm("Glutsturm"),
        Hinterhalt("Hinterhalt"),
        Misery("Misery"),
        Nemesis("Nemesis"),
        Nightfall("Nightfall"),
        Proximamente("Proximamente"),
        Rampage("Rampage"),
        Raserei("Raserei"),
        Reckoning("Reckoning"),
        Represailles("Represailles"),
        Ruin("Ruin"),
        Schattenbrand("Schattenbrand"),
        Sturmangriff("Sturmangriff"),
        Todbringer("Todbringer"),
        Unknown("Unknown"),
        Vengeance("Vengeance"),
        VerderBnis("VerderBnis");

        public String name;

        Name(String name) {
            this.name = name;
        }
    }

    private Name mName;

    /** Returns the slug to be used for URL request fields **/
    public String getSlug() {
        return mName.toString().toLowerCase().replace('_', '-');
    }

    /** Returns the relative URL to be used for URL request parameters **/
    public String getRelativeUrl() {
        return mName.toString().toLowerCase().replace("_", "%20");
    }

    public static Battlegroup newInstanceFromJson(JsonObject jsonObject) {
        if (jsonObject.has("battlegroup"))
            return fromString(jsonObject.get("battlegroup").getAsString());
        else return fromString("");
    }

    public static Battlegroup fromString(String name) {
        for (Battlegroup.Name battlegroupName : Battlegroup.Name.values()) {
            if (battlegroupName.name.equalsIgnoreCase(name)) {
                Battlegroup usBattlegroup = new Battlegroup();
                usBattlegroup.setName(battlegroupName);
                return usBattlegroup;
            }
        }

        Battlegroup battlegroup = new Battlegroup();
        battlegroup.setName(Name.Unknown);

        return battlegroup;
    }

    public void setName(Name name) {
        mName = name;
    }

    public Name getName() {
        return mName;
    }
}
