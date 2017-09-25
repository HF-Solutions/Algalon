package org.alcha.algalon.models.wow.characters;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Aug 24, 2017 @ 13:34.</p>
 */

public class CharacterBracket {
    private String mSlug;
    private int mRating;
    private int mWeeklyPlayed;
    private int mWeeklyWon;
    private int mWeeklyLost;
    private int mSeasonPlayed;
    private int mSeasonWon;
    private int mSeasonLost;

    public CharacterBracket() {

    }

    public static CharacterBracket newInstanceFromJson(JsonObject jsonObject) {
        CharacterBracket bracket = new CharacterBracket();

        if (jsonObject.has("slug"))
            bracket.setSlug(jsonObject.get("slug").getAsString());
        else bracket.setSlug("");

        if (jsonObject.has("rating"))
            bracket.setRating(jsonObject.get("rating").getAsInt());
        else bracket.setRating(-1);

        if (jsonObject.has("weeklyPlayed"))
            bracket.setWeeklyPlayed(jsonObject.get("weeklyPlayed").getAsInt());
        else bracket.setWeeklyPlayed(-1);

        if (jsonObject.has("weeklyWon"))
            bracket.setWeeklyWon(jsonObject.get("weeklyWon").getAsInt());
        else bracket.setWeeklyWon(-1);

        if (jsonObject.has("weeklyLost"))
            bracket.setWeeklyLost(jsonObject.get("weeklyLost").getAsInt());
        else bracket.setWeeklyLost(-1);

        if (jsonObject.has("seasonPlayed"))
            bracket.setSeasonPlayed(jsonObject.get("seasonPlayed").getAsInt());
        else bracket.setSeasonPlayed(-1);

        if (jsonObject.has("seasonWon"))
            bracket.setSeasonWon(jsonObject.get("seasonWon").getAsInt());
        else bracket.setSeasonWon(-1);

        if (jsonObject.has("seasonLost"))
            bracket.setSeasonLost(jsonObject.get("seasonLost").getAsInt());
        else bracket.setSeasonLost(-1);

        return bracket;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        mRating = rating;
    }

    public int getWeeklyPlayed() {
        return mWeeklyPlayed;
    }

    public void setWeeklyPlayed(int weeklyPlayed) {
        mWeeklyPlayed = weeklyPlayed;
    }

    public int getWeeklyWon() {
        return mWeeklyWon;
    }

    public void setWeeklyWon(int weeklyWon) {
        mWeeklyWon = weeklyWon;
    }

    public int getWeeklyLost() {
        return mWeeklyLost;
    }

    public void setWeeklyLost(int weeklyLost) {
        mWeeklyLost = weeklyLost;
    }

    public int getSeasonPlayed() {
        return mSeasonPlayed;
    }

    public void setSeasonPlayed(int seasonPlayed) {
        mSeasonPlayed = seasonPlayed;
    }

    public int getSeasonWon() {
        return mSeasonWon;
    }

    public void setSeasonWon(int seasonWon) {
        mSeasonWon = seasonWon;
    }

    public int getSeasonLost() {
        return mSeasonLost;
    }

    public void setSeasonLost(int seasonLost) {
        mSeasonLost = seasonLost;
    }
}
