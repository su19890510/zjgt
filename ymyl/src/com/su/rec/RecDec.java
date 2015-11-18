package com.su.rec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.su.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;



public class RecDec extends Fragment implements OnClickListener {

    private TextView abstractTextView;
    private TextView titleTextView;
    private TextView needTextView;
    private TextView scheduleTextView;
    private TextView prizeTextView;
    private TextView commTextView;
    private TextView zhubanTextView;
    private TextView xiebanTextView;
    private TextView chengbanTextView;
    View startView;
    public static JSONObject match = null;
    private Activity matchActivity;
    private WebView webview;


    private ArrayList<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();

    public RecDec(Activity _matchActivity) {
        matchActivity = _matchActivity;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        startView = inflater.inflate(R.layout.rec_pro, null);
        findView();
        getNetMessage();
        return startView;
    }

    private void findView() {


    }

    private void getNetMessage() {
       
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }
}
