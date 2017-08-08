package com.alcha.models;

/**
 * Created by Alcha on 8/1/2017.
 */

public class WoWRewardItem {
    private String[] bonusLists,
            stats,
            artifactTraits,
            relics,
            appearance;
    private String name,
            icon,
            context;
    private int id,
            artifactId,
            quality,
            itemLevel,
            armor,
            displayInfoId,
            artifactAppearanceId;

    public String[] getBonusLists() {
        return bonusLists;
    }

    public void setBonusLists(String[] bonusLists) {
        this.bonusLists = bonusLists;
    }

    public String[] getStats() {
        return stats;
    }

    public void setStats(String[] stats) {
        this.stats = stats;
    }

    public String[] getArtifactTraits() {
        return artifactTraits;
    }

    public void setArtifactTraits(String[] artifactTraits) {
        this.artifactTraits = artifactTraits;
    }

    public String[] getRelics() {
        return relics;
    }

    public void setRelics(String[] relics) {
        this.relics = relics;
    }

    public String[] getAppearance() {
        return appearance;
    }

    public void setAppearance(String[] appearance) {
        this.appearance = appearance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public int getArtifactAppearanceId() {
        return artifactAppearanceId;
    }

    public void setArtifactAppearanceId(int artifactAppearanceId) {
        this.artifactAppearanceId = artifactAppearanceId;
    }
}
