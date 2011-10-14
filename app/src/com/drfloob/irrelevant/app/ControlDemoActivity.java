package com.drfloob.irrelevant.app;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.util.Log;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;

public class ControlDemoActivity extends ListActivity
{
	private static final String TAG = "ControlDemoActivity";

	@Override public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		String[] BUTTONS = new String[]{"up", "down", "left", "right", "a", "b", "start", "select", "register", "unregister"};
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, BUTTONS));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		final DefaultHttpClient httpclient = new DefaultHttpClient();

		lv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
					HttpGet httpget = new HttpGet("http://10.0.2.2:8080/" + ((TextView) view).getText());
					try {
						HttpResponse response = httpclient.execute(httpget);
						Log.d(TAG, response.toString());
					} catch(Exception e) {
						e.printStackTrace();
						Log.e(TAG, e.getMessage());
					}
				}
			});
	}


}


