package org.alcha.algalona;

import org.alcha.algalona.models.wow.characters.WoWCharacterField;
import org.alcha.algalona.models.wow.realms.WoWRealm;
import org.alcha.algalona.network.WoWRequest;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.alcha.algalona.models.wow.realms.WoWUSRealms.Alterac_Mountains;

/**
 * <p>Created by Alcha on 8/9/2017.</p>
 * Used to test the {@link WoWRequest} class and verify it works as intended.
 */
public class WoWRequestURLsTest {
    /**
     * Test the {@link WoWRequest#getAchievement(int)} method to verify it returns a valid URL to
     * execute.
     */
    @Test
    public void wowRequest_CorrectAchievementURL() {
        assertEquals(WoWRequest.getAchievement(2144).getRelativeUrl(), "/wow/achievement/2144");
    }

    /**
     * Test the {@link WoWRequest#getAuctionIndexFile(WoWRealm)} method to verify it returns a valid
     * URL to execute.
     */
    @Test
    public void wowRequest_CorrectAuctionIndexURL() {
        assertEquals(WoWRequest.getAuctionIndexFile(Alterac_Mountains).getRelativeUrl(), "/wow/auction/data/alterac%20mountains");
    }

    @Test
    public void wowRequest_CorrectBossListURL() {
        assertEquals(WoWRequest.getBossMasterList().getRelativeUrl(), "/wow/boss/");
    }

    @Test
    public void wowRequest_CorrectBossURL() {
        assertEquals(WoWRequest.getBoss(2473).getRelativeUrl(), "/wow/boss/2473");
    }

    @Test
    public void wowRequest_CorrectCharacterURL() {
        assertEquals(WoWRequest.getCharacterProfile(Alterac_Mountains, "Alcha").getRelativeUrl(), "/wow/character/alterac%20mountains/Alcha");
    }

    @Test
    public void wowRequest_CorrectCharacterFieldsURL() {
        WoWCharacterField.Name[] fields = new WoWCharacterField.Name[]{
                WoWCharacterField.Name.Achievements,
                WoWCharacterField.Name.Appearance,
                WoWCharacterField.Name.Feed,
                WoWCharacterField.Name.Guild,
                WoWCharacterField.Name.Hunter_Pets,
                WoWCharacterField.Name.Items
        };

        assertEquals(WoWRequest.getCharacterProfileFields(Alterac_Mountains, "Alcha", fields).getRelativeUrl(),
                "/wow/character/alterac%20mountains/Alcha?fields=achievements%2Cappearance%2Cfeed%2Cguild%2ChunterPets%2Citems");
    }

    @Test
    public void wowRequest_CorrectPetAbilityURL() {
        assertEquals(WoWRequest.getPetAbility(640).getRelativeUrl(), "/wow/pet/ability/640");
    }
}
