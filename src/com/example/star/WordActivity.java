package com.example.star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WordActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word);

		Resources res = getResources();
		String[] words = res.getStringArray(R.array.str_arr_word);
        ListView list = (ListView) findViewById(R.id.listView1);		
		ArrayAdapter word = new ArrayAdapter(getApplicationContext(),
		     android.R.layout.simple_list_item_1,
		     words);
		
        //ArrayAdapter ost_title = new ArrayAdapter<String>(getApplicationContext(),
        //		android.R.layout.expandable_list_content, R.array.str_arr_word
        //		);
        list.setAdapter(word);
        //list.setOnItemClickListener(this);	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {		
		case R.id.home:
 			Intent myIntent0 = new Intent(this, MenuActivity.class);			
 			startActivity(myIntent0);	 			
			return true;
		case R.id.intro:
 			Intent myIntent1 = new Intent(this, IntroActivity.class);			
 			startActivity(myIntent1);	 			
			return true;
		case R.id.cast:
 			Intent myIntent2 = new Intent(this, CastActivity.class);			
 			startActivity(myIntent2);	 			
			return true;
		case R.id.highlight:
 			Intent myIntent3 = new Intent(this, HighlightActivity.class);			
 			startActivity(myIntent3);	 			
			return true;
		case R.id.ost:
 			Intent myIntent4 = new Intent(this, OSTActivity.class);			
 			startActivity(myIntent4);	 			
			return true;
		case R.id.word:
 			Intent myIntent5 = new Intent(this, WordActivity.class);			
 			startActivity(myIntent5);	 			
			return true;
		case R.id.about:			
			Toast.makeText(this, "BipBip App",
					Toast.LENGTH_LONG).show();
			return true;				
		default:
			return super.onOptionsItemSelected(item);
		}				
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}	
}
