package org.alcha.algalona.models.wow.guilds;

import org.json.JSONException;
import org.json.JSONObject;

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

    public static WoWGuildEmblem fromJSON(JSONObject jsonObject) throws JSONException {
        WoWGuildEmblem emblem = new WoWGuildEmblem();

        emblem.setIconColor(jsonObject.getString("iconColor"));
        emblem.setBorderColor(jsonObject.getString("borderColor"));
        emblem.setBackgroundColor(jsonObject.getString("backgroundColor"));
        emblem.setIcon(jsonObject.getInt("icon"));
        emblem.setIconId(jsonObject.getInt("iconColorId"));
        emblem.setBorder(jsonObject.getInt("border"));
        emblem.setBorderColorId(jsonObject.getInt("borderColorId"));
        emblem.setBackgroundColorId(jsonObject.getInt("backgroundColorId"));

        return emblem;
    }

    public void setIconColor(String iconColor) {
        mIconColor = iconColor;
    }

    public void setBorderColor(String borderColor) {
        mBorderColor = borderColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    public void setIconId(int iconId) {
        mIconColorId = iconId;
    }

    public void setBorder(int border) {
        mBorder = border;
    }

    public void setBorderColorId(int borderId) {
        mBorderColorId = borderId;
    }

    public void setBackgroundColorId(int backgroundColorId) {
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
