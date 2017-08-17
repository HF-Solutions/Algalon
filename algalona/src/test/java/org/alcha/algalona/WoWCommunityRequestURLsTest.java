package org.alcha.algalona;

import org.alcha.algalona.models.wow.characters.WoWCharacterField;
import org.alcha.algalona.models.wow.realms.WoWRealm;
import org.alcha.algalona.network.WoWCommunityRequest;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.alcha.algalona.models.wow.realms.WoWUSRealms.Alterac_Mountains;

/**
 * <p>Created by Alcha on 8/9/2017.</p>
 * Used to test the {@link WoWCommunityRequest} class and verify it works as intended.
 */
public class WoWCommunityRequestURLsTest {
    /**
     * Test the {@link WoWCommunityRequest#getAchievement(int)} method to verify it returns a valid URL to
     * execute.
     */
    @Test
    public void wowRequest_CorrectAchievementURL() {
        assertEquals(WoWCommunityRequest.getAchievement(2144).getRelativeUrl(), "/wow/achievement/2144");
    }

    /**
     * Test the {@link WoWCommunityRequest#getAuctionIndexFile(WoWRealm)} method to verify it returns a valid
     * URL to execute.
     */
    @Test
    public void wowRequest_CorrectAuctionIndexURL() {
        assertEquals(WoWCommunityRequest.getAuctionIndexFile(Alterac_Mountains).getRelativeUrl(), "/wow/auction/data/alterac%20mountains");
    }

    @Test
    public void wowRequest_CorrectBossListURL() {
        assertEquals(WoWCommunityRequest.getBossMasterList().getRelativeUrl(), "/wow/boss/");
    }

    @Test
    public void wowRequest_CorrectBossURL() {
        assertEquals(WoWCommunityRequest.getBoss(2473).getRelativeUrl(), "/wow/boss/2473");
    }

    @Test
    public void wowRequest_CorrectCharacterURL() {
        assertEquals(WoWCommunityRequest.getCharacterProfile(Alterac_Mountains, "Alcha").getRelativeUrl(), "/wow/character/alterac%20mountains/Alcha");
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

        assertEquals(WoWCommunityRequest.getCharacterProfileFields(Alterac_Mountains, "Alcha", fields).getRelativeUrl(),
                "/wow/character/alterac%20mountains/Alcha?fields=achievements%2Cappearance%2Cfeed%2Cguild%2ChunterPets%2Citems");
    }

    @Test
    public void wowRequest_CorrectPetAbilityURL() {
        assertEquals(WoWCommunityRequest.getPetAbility(640).getRelativeUrl(), "/wow/pet/ability/640");
    }
}
