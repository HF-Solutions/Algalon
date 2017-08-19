package org.alcha.algaloncompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static android.graphics.Typeface.BOLD;

/**
 * <p>Created by Alcha on Aug 18, 2017 @ 19:34.</p>
 * Copyright (c) 2017 Paranoid Devs.
 */

public class ListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mListHeaders;
    private HashMap<String, List<String>> mListChild;

    public ListAdapter(Context context, List<String> listHeaders, HashMap<String, List<String>> listChildren) {
        mContext = context;
        mListHeaders = listHeaders;
        mListChild = listChildren;
    }

    @Override
    public int getGroupCount() {
        return mListHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mListChild.get(mListHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListChild.get(mListHeaders.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.api_group, null);
        }

        TextView titleHeader = (TextView) convertView.findViewById(R.id.api_group_header);
        titleHeader.setText(title);
        titleHeader.setTypeface(null, BOLD);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.api_list_item, null);
        }

        TextView childItem = (TextView) convertView.findViewById(R.id.api_list_item_text);
        childItem.setText(childText);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
