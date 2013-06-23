package com.wikitude.samples;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.wikitude.sdksamples.R;

public class SamplePoiDetailActivity extends Activity {
	
	public static final String EXTRAS_KEY_POIDATA = "poiData";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_5_1_poidetail);
		
		// fill layout with JSON object data
		try {
			JSONObject poiData = new JSONObject(getIntent().getExtras().getString(EXTRAS_KEY_POIDATA) );
			((TextView)findViewById(R.id.poi_title)).setText(poiData.getString("name"));
			((TextView)findViewById(R.id.poi_description)).setText(poiData.getString("description"));
			((TextView)findViewById(R.id.poi_latitude)).setText(poiData.getString("latitude"));
			((TextView)findViewById(R.id.poi_longitude)).setText(poiData.getString("longitude"));
		} catch (JSONException e) {
			Toast.makeText(this, "Unexpected error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
			e.printStackTrace();
			this.finish();
			return;
		}
	}

}
