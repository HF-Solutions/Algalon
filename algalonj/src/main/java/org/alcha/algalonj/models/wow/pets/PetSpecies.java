package org.alcha.algalonj.models.wow.pets;

import com.google.gson.JsonObject;

import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 16:22.</p>
 */

public class PetSpecies {
    private int mSpeciesId;
    private int mPetTypeId;
    private int mCreatureId;
    private String mName;
    private boolean mCanBattle;
    private String mIcon;
    private String mDescription;
    private String mSource;
    private List<PetAbility> mPetAbilities;

    public PetSpecies() {

    }

    public static PetSpecies newInstanceFromJson(JsonObject jsonObject) {
        PetSpecies species = new PetSpecies();

        if (jsonObject.has("speciesId"))
            species.setSpeciesId(jsonObject.get("speciesId").getAsInt());
        else species.setSpeciesId(-1);

        if (jsonObject.has("petTypeId"))
            species.setPetTypeId(jsonObject.get("petTypeId").getAsInt());
        else species.setPetTypeId(-1);

        if (jsonObject.has("creatureId"))
            species.setCreatureId(jsonObject.get("creatureId").getAsInt());
        else species.setCreatureId(-1);

        if (jsonObject.has("name"))
            species.setName(jsonObject.get("name").getAsString());
        else species.setName("");

        if (jsonObject.has("canBattle"))
            species.setCanBattle(jsonObject.get("canBattle").getAsBoolean());
        else species.setCanBattle(false);

        if (jsonObject.has("icon"))
            species.setIcon(jsonObject.get("icon").getAsString());
        else species.setIcon("");

        if (jsonObject.has("description"))
            species.setDescription(jsonObject.get("description").getAsString());
        else species.setDescription("");

        if (jsonObject.has("source"))
            species.setSource(jsonObject.get("source").getAsString());
        else species.setSource("");

        if (jsonObject.has("abilities"))
            species.setPetAbilities(PetAbility.parseJsonArray(jsonObject.getAsJsonArray("abilities")));

        return species;
    }

    public int getSpeciesId() {
        return mSpeciesId;
    }

    public void setSpeciesId(int speciesId) {
        mSpeciesId = speciesId;
    }

    public int getPetTypeId() {
        return mPetTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        mPetTypeId = petTypeId;
    }

    public int getCreatureId() {
        return mCreatureId;
    }

    public void setCreatureId(int creatureId) {
        mCreatureId = creatureId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isCanBattle() {
        return mCanBattle;
    }

    public void setCanBattle(boolean canBattle) {
        mCanBattle = canBattle;
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
        mDescription = description;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public List<PetAbility> getPetAbilities() {
        return mPetAbilities;
    }

    public void setPetAbilities(List<PetAbility> petAbilities) {
        mPetAbilities = petAbilities;
    }
}
