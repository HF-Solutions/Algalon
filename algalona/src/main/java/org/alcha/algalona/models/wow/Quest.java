package org.alcha.algalona.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 18:38.</p>
 */

public class Quest {
    private int mId;
    private String mTitle;
    private int mReqLevel;
    private int mSuggestedPartyMembers;
    private String mCategory;
    private int mLevel;

    public Quest() {

    }

    @Override
    public String toString() {
        return "Id = " + mId + ";" +
                "Title=" + mTitle + ";";
    }

    public static Quest newInstanceFromJson(JsonObject jsonObject) {
        Quest quest = new Quest();

        if (jsonObject.has("id"))
            quest.setId(jsonObject.get("id").getAsInt());
        else quest.setId(-1);

        if (jsonObject.has("title"))
            quest.setTitle(jsonObject.get("title").getAsString());
        else quest.setTitle("");

        if (jsonObject.has("reqLevel"))
            quest.setReqLevel(jsonObject.get("reqLevel").getAsInt());
        else quest.setReqLevel(-1);

        if (jsonObject.has("suggestedPartyMembers"))
            quest.setSuggestedPartyMembers(jsonObject.get("suggestedPartyMembers").getAsInt());
        else quest.setSuggestedPartyMembers(-1);

        if (jsonObject.has("category"))
            quest.setCategory(jsonObject.get("category").getAsString());
        else quest.setCategory("");

        if (jsonObject.has("level"))
            quest.setLevel(jsonObject.get("level").getAsInt());
        else quest.setLevel(-1);

        return quest;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getReqLevel() {
        return mReqLevel;
    }

    public void setReqLevel(int reqLevel) {
        mReqLevel = reqLevel;
    }

    public int getSuggestedPartyMembers() {
        return mSuggestedPartyMembers;
    }

    public void setSuggestedPartyMembers(int suggestedPartyMembers) {
        mSuggestedPartyMembers = suggestedPartyMembers;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }
}
