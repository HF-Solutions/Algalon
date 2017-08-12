package org.alcha.algalonj.models.wow;

/**
 * <p>Created by Alcha on 8/1/2017.</p>
 */

public class WoWRewardItem {
    private static final String LOG_TAG = "WoWRewardItem";
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

    void setBonusLists(String[] bonusLists) {
        this.bonusLists = bonusLists;
    }

    public String[] getStats() {
        return stats;
    }

    void setStats(String[] stats) {
        this.stats = stats;
    }

    public String[] getArtifactTraits() {
        return artifactTraits;
    }

    void setArtifactTraits(String[] artifactTraits) {
        this.artifactTraits = artifactTraits;
    }

    public String[] getRelics() {
        return relics;
    }

    void setRelics(String[] relics) {
        this.relics = relics;
    }

    public String[] getAppearance() {
        return appearance;
    }

    void setAppearance(String[] appearance) {
        this.appearance = appearance;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContext() {
        return context;
    }

    void setContext(String context) {
        this.context = context;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public int getArtifactId() {
        return artifactId;
    }

    void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    public int getQuality() {
        return quality;
    }

    void setQuality(int quality) {
        this.quality = quality;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public int getArmor() {
        return armor;
    }

    void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public int getArtifactAppearanceId() {
        return artifactAppearanceId;
    }

    void setArtifactAppearanceId(int artifactAppearanceId) {
        this.artifactAppearanceId = artifactAppearanceId;
    }
}
