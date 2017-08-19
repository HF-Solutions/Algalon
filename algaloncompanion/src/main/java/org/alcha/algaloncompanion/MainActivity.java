package org.alcha.algaloncompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
