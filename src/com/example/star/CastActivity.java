package com.example.star;



import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CastActivity extends Activity implements OnItemClickListener, TabListener  {

	Resources res;
	String[] cast_titles;
	String[] cast_contents;	
	String[] cast1_contents;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cast);
		
		res = getResources();
		cast_titles = res.getStringArray(R.array.str_arr_str_cast1_title);
		cast_contents = res.getStringArray(R.array.str_arr_str_cast1_content);
		cast1_contents = res.getStringArray(R.array.str_arr_str_cast1_content);
		
        ListView list = (ListView) findViewById(R.id.listView1);
        ArrayAdapter casts = new ArrayAdapter<String>(getApplicationContext(),
        		android.R.layout.simple_list_item_1, 
        		cast_titles);
        list.setAdapter(casts);
        list.setOnItemClickListener(this);
        
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //actionBar.setDisplayShowTitleEnabled(false);   
        
        actionBar.addTab(actionBar.newTab().setText(R.string.str_cast1_title).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.str_cast2_title).setTabListener(this)); 		
        actionBar.addTab(actionBar.newTab().setText(R.string.str_cast3_title).setTabListener(this));        
	}

    /* Add a Fragment to our stack with n Androids in it
    */
   private void stackAFragment(int nAndroids) {
   	//Fragment f = new TestFragment(nAndroids);
		Fragment f;
		
		if(this.getActionBar().getSelectedTab().getPosition() == 1){
			//f = new TestFragment(nAndroids);
			//this.getActionBar().setIcon(R.drawable.icon);
		}else{
			//f = new NaFragment(nAndroids);
			//this.getActionBar().setIcon(R.drawable.icon2);
		}
		
       //FragmentTransaction ft = getFragmentManager().beginTransaction();
       //ft.replace(R.id.the_frag, f);
       //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
       //ft.addToBackStack(null);
       //ft.commit();
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
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ListView mylist = (ListView) findViewById(R.id.listView1);
		TextView mycontent = (TextView) findViewById(R.id.textView1);
    	ImageView myimage = (ImageView) findViewById(R.id.imageView1);
    	
		if(this.getActionBar().getSelectedTab().getPosition() == 1){
			mylist.setVisibility(View.GONE);
	    	myimage.setVisibility(View.GONE);			
	    	mycontent.setVisibility(View.VISIBLE);			
	    	mycontent.setText(R.string.str_cast2_content);	

			this.getActionBar().setTitle(R.string.str_cast2_title);
		} else if (this.getActionBar().getSelectedTab().getPosition() == 2){
			mylist.setVisibility(View.GONE);	
	    	mycontent.setVisibility(View.GONE);				
			myimage.setVisibility(View.VISIBLE);
	    	myimage.setImageResource(R.drawable.relationship);	
    	
			this.getActionBar().setTitle(R.string.str_cast3_title);	    	
		} else {
			mylist.setVisibility(View.VISIBLE);			
	    	mycontent.setVisibility(View.VISIBLE);				
			myimage.setVisibility(View.VISIBLE);				
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TextView mycontent = (TextView) findViewById(R.id.textView1);
    	ImageView myimage = (ImageView) findViewById(R.id.imageView1);
    	

		//stackAFragment(position + 1);	
		if (position==0){
			myimage.setImageResource(R.drawable.cast1_large);
		} else if (position==1){
			myimage.setImageResource(R.drawable.cast2_large);
		} else if (position==2){
			myimage.setImageResource(R.drawable.cast3_large);
		} else if (position==3){
			myimage.setImageResource(R.drawable.cast4_large);
		} else {
			myimage.setImageResource(R.drawable.theme_pic2);
		} 
    	mycontent.setText(cast1_contents[position]);					
	}

}
