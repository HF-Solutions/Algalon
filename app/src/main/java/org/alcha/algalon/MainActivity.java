package org.alcha.algalon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.alcha.algalona.models.wow.realms.WoWRealms;
import org.alcha.algalona.network.AlgalonClient;
import org.alcha.algalona.network.Callback;
import org.json.JSONObject;

import static org.alcha.algalon.util.APIKeys.getBlizzardKey;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlgalonClient algalon = AlgalonClient.newUSInstance(getBlizzardKey(getResources()));
        algalon.getCharacterProfileJSON(WoWRealms.Alterac_Mountains, "Alcha", new Callback() {
            @Override
            public void onTaskCompleted(JSONObject result) {
                System.out.println("Printing results:");
                System.out.println(result);
            }
        });
    }
}
