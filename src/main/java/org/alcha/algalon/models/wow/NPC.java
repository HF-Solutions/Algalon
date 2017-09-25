package org.alcha.algalon.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 04:06.</p>
 */
public class NPC {
    private int mId;
    private String mName;
    private String mUrlSlug;
    private int mCreatureDisplayId;

    private NPC() {

    }

    @Override
    public String toString() {
        return "id = " + mId + "; " +
                "name = " + mName + "; " +
                "urlSlug = " + mUrlSlug + "; " +
                "creatureDisplayId = " + mCreatureDisplayId + ";";
    }

    public static NPC newInstanceFromJson(JsonObject jsonObject) {
        NPC NPC = new NPC();

        if (jsonObject.has("id"))
            NPC.setId(jsonObject.get("id").getAsInt());

        if (jsonObject.has("name"))
            NPC.setName(jsonObject.get("name").getAsString());

        if (jsonObject.has("urlSlug"))
            NPC.setUrlSlug(jsonObject.get("urlSlug").getAsString());

        if (jsonObject.has("creatureDisplayId"))
            NPC.setCreatureDisplayId(jsonObject.get("creatureDisplayId").getAsInt());

        return NPC;
    }

    public static List<NPC> parseJsonArray(JsonArray jsonArray) {
        List<NPC> NPCs = new ArrayList<>();

        for (int x = 0; x < jsonArray.size(); x++) {
            JsonObject jsonObject = jsonArray.get(x).getAsJsonObject();

            NPCs.add(NPC.newInstanceFromJson(jsonObject));
        }

        return NPCs;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrlSlug() {
        return mUrlSlug;
    }

    public void setUrlSlug(String urlSlug) {
        mUrlSlug = urlSlug;
    }

    public int getCreatureDisplayId() {
        return mCreatureDisplayId;
    }

    public void setCreatureDisplayId(int creatureDisplayId) {
        mCreatureDisplayId = creatureDisplayId;
    }
}
