package org.alcha.algaloncompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.JsonObject;

import org.alcha.algalona.interfaces.RequestCallback;
import org.alcha.algalona.models.wow.characters.Character;
import org.alcha.algalona.models.wow.characters.CharacterAudit;
import org.alcha.algalona.models.wow.characters.CharacterField;
import org.alcha.algalona.models.wow.realms.WoWRealm;
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
                        WoWRealm.fromString("Alterac Mountains"),
                        "Alcha",
                        new CharacterField.Name[]{CharacterField.Name.Audit}
                ), new RequestCallback() {
                    @Override
                    public void onTaskCompleted(JsonObject response) {
                        Character character = Character.newInstanceFromJson(response);
                        if (character.hasField(CharacterField.Name.Audit)) {
                            CharacterAudit audit = character.getField(CharacterField.Name.Audit);
                        }
                    }
                });
    }
}
