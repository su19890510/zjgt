package com.su.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.su.des.DesActivity;
import com.su.login.activity.LoginIndexActivity;
import com.su.match.MatchActivity;
import com.su.myroom.activity.MyRoomActivity;
import com.su.project.ProjectActivity;


import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;


public class TabShow extends TabActivity {
	private final static String TAG = "TabShow";
	private TabHost mHost;
	private RadioGroup tabItems;
	
	// MineTab ï¿½ï¿½ ï¿½ï¿½ï¿½ÒµÄ¡ï¿½ ï¿½ï¿½Ò»Ñ¡ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ê¾
	private PopupWindow minePop;
	private RadioButton mineBut;
	private static  boolean FINISH = false;
    boolean isShow;
	Toast backToast;
	 public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.tabshow);
	    initResourceRefs();
	    initSettings();
	   
	 }
	 private void initResourceRefs(){
		  mHost = getTabHost();
		  
		  mHost.addTab(mHost.newTabSpec("Rec").setIndicator("Rec")
		    		.setContent(new Intent(this , RecActivity.class)));
		    
		  mHost.addTab(mHost.newTabSpec("Pro").setIndicator("Pro")
		    		.setContent(new Intent(this , ProjectActivity.class)));
		    
		  mHost.addTab(mHost.newTabSpec("Dec").setIndicator("Dec")
		    		.setContent(new Intent(this , DesActivity.class)));  
			    
		  mHost.addTab(mHost.newTabSpec("Match").setIndicator("Match")
		    		.setContent(new Intent(this , MatchActivity.class)));
		  
		  mHost.addTab(mHost.newTabSpec("Mine").setIndicator("Mine")
		    		.setContent(new Intent(this , MyRoomActivity.class)));
		   
		  tabItems = (RadioGroup)findViewById(R.id.tab_items);
		
	 }
	 
	 private void initSettings(){
		 
		 
		 tabItems.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					
					
					switch(checkedId){
					
					 case R.id.tab_item_rec :
						 mHost.setCurrentTabByTag("Rec");
						 break;
					 case R.id.tab_item_pro :
						 mHost.setCurrentTabByTag("Pro");
						 break;
					 case R.id.tab_item_dec :
						 mHost.setCurrentTabByTag("Dec");
						 break;	
					 case R.id.tab_item_mine :
						 mHost.setCurrentTabByTag("Mine");
						 break;	
					 case R.id.tab_item_match :
						 mHost.setCurrentTabByTag("Match");
						 break;	
			
					
					}
					
				}
			});

	 }
	 
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
    		if(event.getAction() == KeyEvent.ACTION_DOWN
				&& event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			
				 if (!FINISH){
					 backToast = Toast.makeText(this, "ÔÙ°´Ò»´ÎÍÆ³ö³ÌÐò", Toast.LENGTH_SHORT);
					 backToast.show();
					 FINISH = true;
					 new Timer().schedule(new TimerTask() {
						
						@Override
						public void run() {
							 FINISH = false;
							
						}
					}, 2000);
				 }else {
					 return super.dispatchKeyEvent(event);
				 }
		      return true; 
	     } 
		return super.dispatchKeyEvent(event);
	}

	
	

	@Override
	protected void onPause() {
		if(FINISH){
		   backToast.cancel();	
		   FINISH = false;
		 }
		super.onPause();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}
}
