package com.su.myroom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.su.activity.R;
import com.su.activity.TabShow;
import com.su.login.activity.LoginAcitvity;

public class MyRoomActivity extends Activity implements OnClickListener {

    public static final String TAG = "nian";
    private RelativeLayout mymessage;
    private RelativeLayout mymember;
    private RelativeLayout mychat;
    private RelativeLayout myparttask;
    private RelativeLayout mysavetask;
    private RelativeLayout mypublishtask;
    private RelativeLayout myarchive;
    private RelativeLayout mygrowupplane;
    private RelativeLayout myset;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.myroom);
        findViewById();
        setListener();
    }
    private void findViewById()
    {
    	mymessage = (RelativeLayout) findViewById(R.id.myroom_detail);
    	mymember = (RelativeLayout) findViewById(R.id.myroom_member);
    	mychat = (RelativeLayout) findViewById(R.id.myroom_chat);
    	myparttask = (RelativeLayout) findViewById(R.id.myroom_task_apply);
    	mysavetask = (RelativeLayout) findViewById(R.id.myroom_task_save);
    	mypublishtask = (RelativeLayout) findViewById(R.id.myroom_task_publish);
    	myarchive = (RelativeLayout) findViewById(R.id.myroom_achieve);
    	mygrowupplane = (RelativeLayout) findViewById(R.id.myroom_grow_plane);
    	myset = (RelativeLayout) findViewById(R.id.myroom_set);

    }
    private void setListener()
    {
    	mymessage.setOnClickListener(this);
    	mymember.setOnClickListener(this);
    	mychat.setOnClickListener(this);
    	myparttask.setOnClickListener(this);
    	mysavetask.setOnClickListener(this);
    	mypublishtask.setOnClickListener(this);
    	myarchive.setOnClickListener(this);
    	mygrowupplane.setOnClickListener(this);
    	myset.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 switch (v.getId()) {
         case R.id.myroom_detail:
        	 Intent intent = new Intent(MyRoomActivity.this, MyMessageActivity.class);
        	 MyRoomActivity.this.startActivity(intent);
        	 break;
         case R.id.myroom_member:
        	 Intent intent1 = new Intent(MyRoomActivity.this, MyMemberActivity.class);
        	 MyRoomActivity.this.startActivity(intent1);
        	 break;
         case R.id.myroom_chat:
        	 break;
         case R.id.myroom_task_apply:
        	 Intent intent3 = new Intent(MyRoomActivity.this, MyPartTaskActivity.class);
        	 MyRoomActivity.this.startActivity(intent3);
        	 break;
         case R.id.myroom_task_save:
        	 Intent intent4 = new Intent(MyRoomActivity.this, MySaveTaskActivity.class);
        	 MyRoomActivity.this.startActivity(intent4);
        	 break;
         case R.id.myroom_task_publish:
        	 Intent intent5 = new Intent(MyRoomActivity.this, MyPublishTaskActivity.class);
        	 MyRoomActivity.this.startActivity(intent5);
        	 break;
         case R.id.myroom_achieve:
        	 Intent intent6 = new Intent(MyRoomActivity.this, MyArchiveActivity.class);
        	 MyRoomActivity.this.startActivity(intent6);
        	 break;
         case R.id.myroom_grow_plane:
        	 Intent intent7 = new Intent(MyRoomActivity.this, MyGrowUpPlaneActivity.class);
        	 MyRoomActivity.this.startActivity(intent7);
        	 break;
         case R.id.myroom_set:
        	 Intent intent8 = new Intent(MyRoomActivity.this, MySetOtherActivity.class);
        	 MyRoomActivity.this.startActivity(intent8);
        	 break;
		 }
	}

   
}
