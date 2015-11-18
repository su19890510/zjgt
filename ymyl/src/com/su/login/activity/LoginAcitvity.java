package com.su.login.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.su.activity.MissPreferentialActivity;
import com.su.activity.R;
import com.su.activity.TabShow;

public class LoginAcitvity extends Activity {

    public static final String TAG = "nian";
    private Button loginbutton;
    private TextView forget;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        findViewById();
        setListener();
    }
    private void findViewById()
    {
    	loginbutton = (Button) findViewById(R.id.login_activity_login);
    	forget = (TextView) findViewById(R.id.login_activity_forget);
    }
    private void setListener()
    {
    	loginbutton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到功能引导页
				Intent intent = new Intent(LoginAcitvity.this, TabShow.class);
                LoginAcitvity.this.startActivity(intent);
                LoginAcitvity.this.finish();
			}
		});
    	
    	forget.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到功能引导页
				Intent intent = new Intent(LoginAcitvity.this, ForgetPasswordActivity.class);
                LoginAcitvity.this.startActivity(intent);
			}
		});
    }
    

    public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getAction() == KeyEvent.ACTION_DOWN
			&& event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
		
			Intent intent = new Intent(LoginAcitvity.this, LoginIndexActivity.class);
            LoginAcitvity.this.startActivity(intent);
            LoginAcitvity.this.finish();
	      return true; 
         } 
	   return super.dispatchKeyEvent(event);
     }
}