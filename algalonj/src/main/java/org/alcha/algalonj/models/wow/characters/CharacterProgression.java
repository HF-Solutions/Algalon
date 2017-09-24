package org.alcha.algalonj.models.wow.characters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.alcha.algalonj.models.wow.RaidEvent;

import java.util.List;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 12:38.</p>
 */

public class CharacterProgression extends CharacterField {
    private List<RaidEvent> mRaidEvents;

    public CharacterProgression() {
        setFieldName(Name.Progression);
    }

    public static CharacterProgression newInstanceFromJson(JsonObject jsonObject) {
        CharacterProgression progression = new CharacterProgression();

        if (jsonObject.has("raids"))
            progression.setRaidEvents(RaidEvent.parseJsonArray(jsonObject.getAsJsonArray("raids")));
        else progression.setRaidEvents(RaidEvent.parseJsonArray(new JsonArray()));

        return progression;
    }

    public List<RaidEvent> getRaidEvents() {
        return mRaidEvents;
    }

    public void setRaidEvents(List<RaidEvent> raidEvents) {
        mRaidEvents = raidEvents;
    }
}
