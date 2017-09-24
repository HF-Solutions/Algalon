package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

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

        private String name;

        Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Name fromString(String string) {
            for (Name name : Name.values())
                if (name.getName().equalsIgnoreCase(string)) return name;

            return Name.Unknown;
        }
    }

    private Name mName;
    private String mSlug;

    /** Returns the slug to be used for URL request fields **/
    public String getSlug() {
        if (mSlug == null) return mName.toString().toLowerCase().replace('_', '-');
        else return mSlug;
    }

    /** Returns the relative URL to be used for URL request parameters **/
    public String getRelativeUrl() {
        return mName.toString().toLowerCase().replace("_", "%20");
    }

    public static Battlegroup newInstanceFromJson(JsonObject jsonObject) {
        if (jsonObject.has("battlegroup"))
            return fromString(jsonObject.get("battlegroup").getAsString());
        else if (jsonObject.has("name") && jsonObject.has("slug")) {
            Battlegroup battlegroup = new Battlegroup();
            battlegroup.setName(Name.fromString(jsonObject.get("name").getAsString()));
            battlegroup.setSlug(jsonObject.get("slug").getAsString());
            return battlegroup;
        } else return fromString(jsonObject.getAsString());
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public static Battlegroup fromString(String name) {
        for (Name battlegroupName : Name.values()) {
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

    public static Battlegroup fromString(String name, String slug) {
        for (Name battlegroupName : Name.values()) {
            if (battlegroupName.name.equalsIgnoreCase(name)) {
                Battlegroup usBattlegroup = new Battlegroup();
                usBattlegroup.setName(battlegroupName);
                usBattlegroup.setSlug(slug);
                return usBattlegroup;
            }
        }

        Battlegroup battlegroup = new Battlegroup();
        battlegroup.setName(Name.Unknown);
        battlegroup.setSlug(null);

        return battlegroup;
    }


    public static List<Battlegroup> parseJsonArray(JsonArray jsonArray) {
        List<Battlegroup> battlegroups = new ArrayList<>();

        for (JsonElement element : jsonArray)
            battlegroups.add(newInstanceFromJson(element.getAsJsonObject()));

        return battlegroups;
    }

    public void setName(Name name) {
        mName = name;
    }

    public Name getName() {
        return mName;
    }
}
