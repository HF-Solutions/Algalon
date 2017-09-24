package org.alcha.algalonj.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 * Represents the various races within WoW and stores their id as well as faction affiliation. The
 * faction is stored using the {@link Faction} type and the id is an int.
 */
public class Race {
    private int mId;
    private int mMask;
    private Faction mSide;
    private Name mName;

    public static Race newInstanceFromJson(JsonObject jsonObject) {
        Race race = new Race();

        if (jsonObject.has("id"))
            race.setId(jsonObject.get("id").getAsInt());
        else race.setId(-1);

        if (jsonObject.has("mask"))
            race.setMask(jsonObject.get("mask").getAsInt());
        else race.setMask(-1);

        if (jsonObject.has("side"))
            race.setSide(Faction.fromString(jsonObject.get("side").getAsString()));
        else race.setSide(Faction.UNKNOWN);

        if (jsonObject.has("name"))
            race.setName(Name.fromString(jsonObject.get("name").getAsString()));
        else race.setName(Name.Unknown);

        return race;
    }

    public static Race fromId(int idIn) {
        Race race = new Race();
        race.setName(Name.fromId(idIn));

        return race;
    }

    public static List<Race> parseJsonArray(JsonArray jsonArray) {
        List<Race> races = new ArrayList<>();

        for (JsonElement element : jsonArray)
            races.add(newInstanceFromJson(element.getAsJsonObject()));

        return races;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getMask() {
        return mMask;
    }

    public void setMask(int mask) {
        mMask = mask;
    }

    public Faction getSide() {
        return mSide;
    }

    public void setSide(Faction side) {
        mSide = side;
    }

    public Name getName() {
        return mName;
    }

    public void setName(Name name) {
        mName = name;
    }

    public enum Name {
        Human(1, "Human"),
        Orc(2, "Orc"),
        Dwarf(3, "Dwarf"),
        Night_Elf(4, "Night Elf"),
        Undead(5, "Undead"),
        Tauren(6, "Tauren"),
        Gnome(7, "Gnome"),
        Troll(8, "Troll"),
        Goblin(9, "Goblin"),
        Blood_Elf(10, "Blood Elf"),
        Draenei(11, "Draenei"),
        Worgen(22, "Worgen"),
        PandarenN(24, "Pandaren"),
        PandarenA(25, "Pandaren"),
        PandarenH(26, "Pandaren"),
        Unknown(42, "Unknown");

        private String name;
        private int id;

        Name(int id, String string) {
            this.id = id;
            this.name = string;
        }

        @Override
        public String toString() {
            return getName();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static Name fromString(String nameIn) {
            for (Name name : Name.values())
                if (name.getName().equalsIgnoreCase(nameIn)) return name;

            return Unknown;
        }

        public static Name fromId(int id) {
            for (Name name : Name.values())
                if (name.getId() == id) return name;

            return Unknown;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
