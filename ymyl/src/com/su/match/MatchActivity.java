package com.su.match;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.su.activity.R;

public class MatchActivity extends Activity {

    public static final String TAG = "nian";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.match_activity);
       
    }

   
}
