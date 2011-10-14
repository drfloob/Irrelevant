package com.drfloob.irrelevant.app;

import android.content.Intent;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DemoListActivity extends ListActivity
{
	private static final String TAG = "DemoListActivity";
	private HashMap<String, Class> actions = new HashMap<String, Class>();

	@Override public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		actions.put("Communication Demo", ControlDemoActivity.class);
		actions.put("SVG Demo", SVGDemoActivity.class);
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, new ArrayList<String>(actions.keySet())));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
					Log.d(TAG, "starting activity: " + ((TextView) view).getText()); 
					startActivity(new Intent(getApplicationContext(), actions.get(((TextView) view).getText())));
				}
			});
	}


}


