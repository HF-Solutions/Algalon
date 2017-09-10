package org.alcha.algaloncompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.JsonObject;

import org.alcha.algalona.interfaces.RequestCallback;
import org.alcha.algalona.models.wow.Achievement;
import org.alcha.algalona.network.AlgalonClient;
import org.alcha.algalona.network.WoWCommunityRequest;

import java.util.ArrayList;
import java.util.List;

import static org.alcha.algaloncompanion.MainActivity.API_KEY;

public class AchievementActivity extends AppCompatActivity {
    private ArrayAdapter<String> mAdapter;
    private EditText mAchievementId;
    private AlgalonClient algalon;
    private ListView mListView;
    private Button mExecute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        initializeControls();
    }

    private void initializeControls() {
        mAchievementId = (EditText) findViewById(R.id.achievement_id);
        mListView = (ListView) findViewById(R.id.listView);
        algalon = AlgalonClient.newUSInstance(API_KEY);
        mExecute = (Button) findViewById(R.id.execute);
        mExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int achievementId = Integer.parseInt(mAchievementId.getText().toString());

                algalon.executeRequest(WoWCommunityRequest.getAchievement(achievementId), new RequestCallback() {
                    @Override
                    public void onTaskCompleted(JsonObject response) {
                        populateList(response);
                        clearInput();
                    }
                });
            }
        });
    }

    private void clearInput() {
        mAchievementId.setText("");
    }

    private void populateList(JsonObject response) {
        Achievement achievement = Achievement.newInstanceFromJson(response);
        List<String> listItems = new ArrayList<>();

        for (String result : achievement.toString().split(";")) {
            listItems.add(result.trim());
        }

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(mAdapter);
    }
}
