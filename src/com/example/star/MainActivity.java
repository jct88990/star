package com.example.star;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {		
		case R.id.about:			
			Toast.makeText(this, "BipBip App",
					Toast.LENGTH_LONG).show();
//			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//		    alertDialog.setTitle("BipBip App");
//		    alertDialog.setMessage("BipBip, This is the best app forever");
//		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//		      public void onClick(DialogInterface dialog, int which) {
//		        return;
//		    } });
//		    alertDialog.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}				
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);			
		startActivity(myIntent);		
	}

}
