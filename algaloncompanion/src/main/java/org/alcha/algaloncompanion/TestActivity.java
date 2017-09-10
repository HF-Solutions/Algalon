package org.alcha.algaloncompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.JsonObject;

import org.alcha.algalona.interfaces.RequestCallback;
import org.alcha.algalona.models.wow.TalentTree;
import org.alcha.algalona.models.wow.characters.Character;
import org.alcha.algalona.models.wow.characters.CharacterField;
import org.alcha.algalona.models.wow.characters.CharacterTalents;
import org.alcha.algalona.models.wow.realms.WoWUSRealms;
import org.alcha.algalona.network.AlgalonClient;
import org.alcha.algalona.network.WoWCommunityRequest;

import static org.alcha.algaloncompanion.MainActivity.API_KEY;

public class TestActivity extends AppCompatActivity {
    private AlgalonClient mAlgalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mAlgalon = AlgalonClient.newUSInstance(API_KEY);
        mAlgalon.executeRequest(
                WoWCommunityRequest.getCharacterProfileFields(
                        WoWUSRealms.fromString("Alterac Mountains"),
                        "Alcha",
                        new CharacterField.Name[]{CharacterField.Name.Talents}
                ), new RequestCallback() {
                    @Override
                    public void onTaskCompleted(JsonObject response) {
                        Character character = Character.newInstanceFromJson(response);
                        if (character.hasField(CharacterField.Name.Talents)) {
                            CharacterTalents talents = character.getField(CharacterField.Name.Talents);

                            for (TalentTree tree : talents.getTalentTrees()) {
                                if (tree.getTalents().size() > 0) {
                                    System.out.println(tree.getTalents().get(0).getSpec().getName());
                                }
                            }
                        }
                    }
                });
    }
}
