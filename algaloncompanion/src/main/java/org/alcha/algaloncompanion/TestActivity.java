package org.alcha.algaloncompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.JsonObject;

import org.alcha.algalona.interfaces.RequestCallback;
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
        mAlgalon.executeRequest(WoWCommunityRequest.getItem(18803), new RequestCallback() {
            @Override
            public void onTaskCompleted(JsonObject response) {
            }
        });
    }
}
