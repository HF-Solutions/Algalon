package org.alcha.algaloncompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String API_KEY = "asauqh5pmb6ppsjs5c4ff3d8wsmtq4js";
    private List<String> mListHeaders;
    private HashMap<String, List<String>> mListChildren;
    private ListAdapter mAdapter;
    private ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ExpandableListView) findViewById(R.id.api_list_view);

        prepareListData();

        mAdapter = new ListAdapter(this, mListHeaders, mListChildren);

        mListView.setAdapter(mAdapter);

        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (mAdapter.getChild(groupPosition, childPosition).toString()) {
                    case "Achievements":
                        startActivity(new Intent(getApplicationContext(), AchievementActivity.class));
                        break;
                    case "Auction":
                        break;
                    case "Boss":
                        break;
                }
                return true;
            }
        });
    }

    private void prepareListData() {
        mListHeaders = new ArrayList<>();
        mListChildren = new HashMap<>();

        mListHeaders.add("World of Warcraft");
        mListHeaders.add("Diablo III");
        mListHeaders.add("Starcraft 2");

        List<String> wow = new ArrayList<>();
        wow.add("Achievements");
        wow.add("Auction");
        wow.add("Boss");
        wow.add("Character Profile");
        wow.add("Guild Profile");
        wow.add("Items");
        wow.add("Mounts");
        wow.add("Pets");
        wow.add("PvP");
        wow.add("Quests");
        wow.add("Realm Status");
        wow.add("Recipes");
        wow.add("Spells");
        wow.add("Zones");
        wow.add("Data Resources");

        mListChildren.put(mListHeaders.get(0), wow);
    }
}
