package org.alcha.algalon.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Aug 27, 2017 @ 02:56.</p>
 */

public class Title {
    private int mId;
    private String mName;

    public Title() {
    }

    public Title(int id, String name) {
        mId = id;
        mName = name;
    }

    public static Title newInstanceFromJson(JsonObject jsonObject) {
        Title title = new Title();

        if (jsonObject.has("id"))
            title.setId(jsonObject.get("id").getAsInt());
        else title.setId(-1);

        if (jsonObject.has("name"))
            title.setName(jsonObject.get("name").getAsString());
        else title.setName("");

        return title;
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
}
