package org.alcha.algalona.models.wow.guilds;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

public class GuildEmblem {
    private String mIconColor,
            mBorderColor,
            mBackgroundColor;

    private int mIcon,
            mIconColorId,
            mBorder,
            mBorderColorId,
            mBackgroundColorId;

    private GuildEmblem() {
    }

    @Override
    public String toString() {
        return "IconColor = " + mIconColor + "; " +
                "BorderColor = " + mBorderColor + "; " +
                "BackgroundColor = " + mBackgroundColor + "; " +
                "Icon = " + mIcon + "; " +
                "IconColorId = " + mIconColorId + "; " +
                "Border = " + mBorder + "; " +
                "BorderColorId = " + mBorderColorId + "; " +
                "BackgroundColorId = " + mBackgroundColorId + ";";
    }

    public static GuildEmblem newInstanceFromJson(JsonObject jsonObject) {
        GuildEmblem emblem = new GuildEmblem();

        if (jsonObject.has("iconColor"))
            emblem.setIconColor(jsonObject.get("iconColor").getAsString());

        if (jsonObject.has("borderColor"))
            emblem.setBorderColor(jsonObject.get("borderColor").getAsString());

        if (jsonObject.has("backgroundColor"))
            emblem.setBackgroundColor(jsonObject.get("backgroundColor").getAsString());

        if (jsonObject.has("icon"))
            emblem.setIcon(jsonObject.get("icon").getAsInt());

        if (jsonObject.has("iconColorId"))
            emblem.setIconId(jsonObject.get("iconColorId").getAsInt());

        if (jsonObject.has("border"))
            emblem.setBorder(jsonObject.get("border").getAsInt());

        if (jsonObject.has("borderColorId"))
            emblem.setBorderColorId(jsonObject.get("borderColorId").getAsInt());

        if (jsonObject.has("backgroundColorId"))
            emblem.setBackgroundColorId(jsonObject.get("backgroundColorId").getAsInt());

        return emblem;
    }

    void setIconColor(String iconColor) {
        mIconColor = iconColor;
    }

    void setBorderColor(String borderColor) {
        mBorderColor = borderColor;
    }

    void setBackgroundColor(String backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    void setIcon(int icon) {
        mIcon = icon;
    }

    void setIconId(int iconId) {
        mIconColorId = iconId;
    }

    void setBorder(int border) {
        mBorder = border;
    }

    void setBorderColorId(int borderId) {
        mBorderColorId = borderId;
    }

    void setBackgroundColorId(int backgroundColorId) {
        mBackgroundColorId = backgroundColorId;
    }

    public String getIconColor() {
        return mIconColor;
    }

    public String getBorderColor() {
        return mBorderColor;
    }

    public String getBackgroundColor() {
        return mBackgroundColor;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getIconId() {
        return mIconColorId;
    }

    public int getBorder() {
        return mBorder;
    }

    public int getBorderColorId() {
        return mBorderColorId;
    }

    public int getBackgroundColorId() {
        return mBackgroundColorId;
    }
}
