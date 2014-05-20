package com.example.star;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class OSTActivity extends Activity implements OnClickListener, OnItemClickListener {
	
	String[] ost_titles;
	String[] ost_links;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ost);
		
		Resources res = getResources();
		ost_titles = res.getStringArray(R.array.str_arr_ost_title);
		ost_links = res.getStringArray(R.array.str_arr_ost_link);			
		
        ListView list = (ListView) findViewById(R.id.listView1);		
		ArrayAdapter ost_title = new ArrayAdapter(getApplicationContext(),
		     android.R.layout.simple_list_item_1,
		     ost_titles);
		
        list.setAdapter(ost_title);
        list.setOnItemClickListener(this);		
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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {		
		//showOST(position);	
		PlayVideo(position);	
	}
	
	private void showOST(int position) {
		// TODO Auto-generated method stub
		String youtubeUrl = "";
		String youtubeId = "";
		String rtsp_link = "";
		
		//urlYoutube = ost_links[position];
		//youtubeUrl = "http://www.youtube.com/watch?v=MV5qvrxmegY";
		//rtsp_link = getUrlVideoRTSP(youtubeUrl);
		//rtsp_link = "rtsp://r1---sn-a5m7zu7e.c.youtube.com/CiILENy73wIaGQkGema8vmpeMRMYDSANFEgGUgZ2aWRlb3MM/0/0/0/video.3gp";
		//rtsp_link = "https://archive.org/download/Pbtestfilemp4videotestmp4/video_test_512kb.mp4";
		//rtsp_link = "rtsp://r3---sn-a5m7zu7d.c.youtube.com/CiILENy73wIaGQn061BlwOVsxRMYDSANFEgGUgZ2aWRlb3MM/0/0/0/video.3gp";
		rtsp_link = ost_links[position];		
		VideoView videoView = (VideoView) this.findViewById(R.id.videoView1);
		Log.v("Video", "***Video to Play:: " + rtsp_link);
		
		// add controls to a MediaPlayer like play, pause.
		MediaController mc = new MediaController(this);
		videoView.setMediaController(mc);
	
		// Set the path of Video or URI
		mc.setAnchorView(videoView);
		Uri videoPath = null;
		videoPath = Uri.parse(rtsp_link);
		
		videoView.setVideoURI(videoPath);
		videoView.requestFocus();
		videoView.start();	
		mc.show();
	}

	private void PlayVideo(int position){
		final VideoView videoView;
	    try{      
	    	String rtspPath = "";	    	
	    	rtspPath = ost_links[position];
	        getWindow().setFormat(PixelFormat.TRANSLUCENT);

	        videoView = (VideoView)findViewById(R.id.videoView1);

	        MediaController mediaController = new MediaController(this);
	        mediaController.setAnchorView(videoView);

	        Uri videoPath = Uri.parse(rtspPath);
	        System.out.println(videoPath);
	        videoView.setMediaController(mediaController);
	        //videoView.setVideoURI(videoPath);
	        videoView.setVideoPath(rtspPath);
	        videoView.requestFocus();

	        videoView.setOnPreparedListener(new OnPreparedListener() {

	            @Override
	            public void onPrepared(MediaPlayer mp) {
	                //progressDialog.dismiss();
	                videoView.start();
	            }
	        });


	    }catch(Exception e){
	        System.out.println("Message : " + e.getMessage());
	        e.printStackTrace();
	        //progressDialog.dismiss();
	        System.out.println("Video Play Error : "+e.toString());
	        finish();
	    }
	}
	
	public static String getUrlVideoRTSP(String urlYoutube)
    {
        try
        {
            String gdy = "http://gdata.youtube.com/feeds/api/videos/";
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String id = extractYoutubeId(urlYoutube);
            URL url = new URL(gdy + id);
    		//Log.v("Video", "***URL: " + url);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Document doc = documentBuilder.parse(connection.getInputStream());
            Element el = doc.getDocumentElement();
            NodeList list = el.getElementsByTagName("media:content");///media:content
            String cursor = urlYoutube;
    		//Log.v("Video", "***List length: " + String.valueOf(list.getLength()));            
            for (int i = 0; i < list.getLength(); i++)
            {
                Node node = list.item(i);
                if (node != null)
                {
                    NamedNodeMap nodeMap = node.getAttributes();
                    HashMap<String, String> maps = new HashMap<String, String>();
                    for (int j = 0; j < nodeMap.getLength(); j++)
                    {
                        Attr att = (Attr) nodeMap.item(j);
                        maps.put(att.getName(), att.getValue());
                    }
                    if (maps.containsKey("yt:format"))
                    {
                        String f = maps.get("yt:format");
                        if (maps.containsKey("url"))
                        {
                            cursor = maps.get("url");
                        }
                        if (f.equals("1"))
                            return cursor;
                    }
                }
            }
            return cursor;
        }
        catch (Exception ex)
        {
            Log.e("Get Url Video RTSP Exception======>>", ex.toString());
        }
        return urlYoutube;

    }	
	
	protected static String extractYoutubeId(String url) throws MalformedURLException
    {
        String id = null;
        try
        {
            String query = new URL(url).getQuery();
            if (query != null)
            {
                String[] param = query.split("&");
                for (String row : param)
                {
                    String[] param1 = row.split("=");
                    if (param1[0].equals("v"))
                    {
                        id = param1[1];
                    }
                }
            }
            else
            {
                if (url.contains("embed"))
                {
                    id = url.substring(url.lastIndexOf("/") + 1);
                }
            }
        }
        catch (Exception ex)
        {
            //Log.e("Exception", ex.toString());
        }
        return id;
    }	
}
