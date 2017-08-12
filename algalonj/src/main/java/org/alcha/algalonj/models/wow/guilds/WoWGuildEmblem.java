package org.alcha.algalonj.models.wow.guilds;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

public class WoWGuildEmblem {
    public String mIconColor,
            mBorderColor,
            mBackgroundColor;

    public int mIcon,
            mIconColorId,
            mBorder,
            mBorderColorId,
            mBackgroundColorId;

    public WoWGuildEmblem() {
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

    public static WoWGuildEmblem fromJSON(JsonObject jsonObject)  {
        WoWGuildEmblem emblem = new WoWGuildEmblem();

        emblem.setIconColor(jsonObject.get("iconColor").getAsString());
        emblem.setBorderColor(jsonObject.get("borderColor").getAsString());
        emblem.setBackgroundColor(jsonObject.get("backgroundColor").getAsString());
        emblem.setIcon(jsonObject.get("icon").getAsInt());
        emblem.setIconId(jsonObject.get("iconColorId").getAsInt());
        emblem.setBorder(jsonObject.get("border").getAsInt());
        emblem.setBorderColorId(jsonObject.get("borderColorId").getAsInt());
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
