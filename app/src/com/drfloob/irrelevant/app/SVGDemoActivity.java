package com.drfloob.irrelevant.app;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;

import android.widget.ImageView;
import android.graphics.Color;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class SVGDemoActivity extends Activity
{
	private static final String TAG = "SVGDemoActivity";

	@Override public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		// Create a new ImageView
		ImageView imageView = new ImageView(this);

		// Set the background color to white
		imageView.setBackgroundColor(Color.WHITE);

		// Parse the SVG file from the resource
		SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.android);

		// Get a drawable from the parsed SVG and set it as the drawable for the ImageView
		imageView.setImageDrawable(svg.createPictureDrawable());

		// Set the ImageView as the content view for the Activity
		setContentView(imageView);
	}


}


