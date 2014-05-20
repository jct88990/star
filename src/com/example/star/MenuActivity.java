package com.example.star;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);	
        
		Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);	
        
		Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);	
        
		Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);	      
        
		Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);        
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
		switch (v.getId()) {
 		case R.id.button1:
 			Intent myIntent1 = new Intent(MenuActivity.this, IntroActivity.class);			
 			startActivity(myIntent1);	 			
 			break;
 		case R.id.button2:
 			Intent myIntent2 = new Intent(MenuActivity.this, CastActivity.class);			
 			startActivity(myIntent2);	 			
 			break; 			
 		case R.id.button3:
 			Intent myIntent3 = new Intent(MenuActivity.this, HighlightActivity.class);			
 			startActivity(myIntent3);	 			
 			break; 			
 		case R.id.button4:
 			Intent myIntent4 = new Intent(MenuActivity.this, OSTActivity.class);			
 			startActivity(myIntent4);	 			
 			break; 			
 		case R.id.button5:
 			Intent myIntent5 = new Intent(MenuActivity.this, WordActivity.class);			
 			startActivity(myIntent5);	 			
 			break; 			
		}
	}

}
