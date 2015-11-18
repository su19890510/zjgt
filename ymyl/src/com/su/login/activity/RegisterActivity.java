package com.su.login.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;

import com.su.activity.R;

public class RegisterActivity extends Activity {

    public static final String TAG = "nian";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);
       
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getAction() == KeyEvent.ACTION_DOWN
			&& event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
		
			Intent intent = new Intent(RegisterActivity.this, LoginIndexActivity.class);
			RegisterActivity.this.startActivity(intent);
			RegisterActivity.this.finish();
	        return true; 
         } 
	   return super.dispatchKeyEvent(event);
     }
}

