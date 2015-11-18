package com.su.login.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.su.activity.MissPreferentialActivity;
import com.su.activity.R;
import com.su.activity.TabShow;
import com.su.activity.RecActivity.MyOnClickListener;
import com.su.database.DataAccess;
import com.su.tool.net.AppData;
import com.su.tool.net.HttpMethod;
import com.su.tool.net.NetManager;

public class LoginIndexActivity extends Activity implements OnClickListener {

    public static final String TAG = "nian";
    private Button register;
    private Button login;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_index_activity);
        findViewById();
    }
    private void findViewById()
    {
    	register = (Button) findViewById(R.id.login_index_activity_registerbutton);
        login = (Button) findViewById(R.id.login_index_activity_loginbutton);
       
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		
		switch(v.getId())
		{
		case R.id.login_index_activity_registerbutton:
			startActivity(new Intent(LoginIndexActivity.this, RegisterActivity.class));
			LoginIndexActivity.this.finish();
			break;
		case R.id.login_index_activity_loginbutton:
			startActivity(new Intent(LoginIndexActivity.this, LoginAcitvity.class));
			LoginIndexActivity.this.finish();
			break;
		}
	}
    

   
}
