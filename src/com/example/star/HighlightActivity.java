package com.example.star;

import java.util.ArrayList;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HighlightActivity extends Activity implements OnItemClickListener, OnNavigationListener  {

	boolean initializing = true;
	Resources res;
	String[] hightlight_titles;
	String[] hightlight_contents;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_highlight);

		res = getResources();
		hightlight_titles = res.getStringArray(R.array.str_arr_hightlight_title);
		hightlight_contents = res.getStringArray(R.array.str_arr_hightlight_content);	
					
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        //actionBar.setDisplayShowTitleEnabled(false);

        ArrayList<String> itemList = new ArrayList<String>();
        
        for (int i=1; i<=21; i++){
        	itemList.add("第"+i+"個記錄");
        }

        ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, itemList);
        actionBar.setListNavigationCallbacks(aAdpt, this); 
        
        showHighlight(0);
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public boolean onNavigationItemSelected(int position, long itemId) {	
		// TODO Auto-generated method stub
        if (initializing) {
            initializing = false;
        } else {                   	
        	showHighlight(position);
        }
		
		
		return false;
	}

	private void showHighlight(int position) {
		// TODO Auto-generated method stub
    	TextView mytitle = (TextView) findViewById(R.id.textView1);
    	mytitle.setText(hightlight_titles[position]);
    	
    	TextView mycontent = (TextView) findViewById(R.id.textView2);
    	mycontent.setText(hightlight_contents[position]);
    	
        //WebView engine = (WebView) findViewById(R.id.webView1);          
        //engine.setWebViewClient(new WebViewClient());
		
        //engine.loadUrl("http://www.google.com");
        //engine.getSettings().setJavaScriptEnabled(true);
       
        //String strHtml = "<html><body>" +
        //		hightlight_contents[position] +
        //        "</body></html>";

        //engine.loadData(strHtml, "text/html", "UTF-8");		
	}

	
}
