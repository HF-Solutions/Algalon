package org.alcha.algalona.models.wow;

/**
 * <p>Created by Alcha on 8/3/2017.</p>
 */

public class WoWSpell {
    private int mId;
    private String mName;
    private String mSubtext;
    private String mIcon;
    private String mDescription;
    private String mCastTime;
    private String mCooldown;

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

    public String getSubtext() {
        return mSubtext;
    }

    public void setSubtext(String subtext) {
        mSubtext = subtext;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getCastTime() {
        return mCastTime;
    }

    public void setCastTime(String castTime) {
        mCastTime = castTime;
    }

    public String getCooldown() {
        return mCooldown;
    }

    public void setCooldown(String cooldown) {
        mCooldown = cooldown;
    }
}
