package com.su.myroom.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.su.activity.R;
import com.su.activity.RecActivity.MyOnClickListener;
import com.su.activity.RecActivity.MyOnPageChangeListener;
import com.su.rec.RecDec;
import com.su.rec.RecPro;
import com.su.tool.net.MyFragmentPagerAdapter;

public class MyGrowUpPlaneActivity extends FragmentActivity {

    public static final String TAG = "nian";
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private TextView myclass,rank,type,search;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.myroom_growplane);
        InitTextView();
        InitViewPager();
    }

    private void InitTextView() {
        myclass = (TextView) findViewById(R.id.myroom_growup_myclass);
        rank = (TextView) findViewById(R.id.myroom_growup_rank);
        type = (TextView) findViewById(R.id.myroom_growup_type);
        search = (TextView) findViewById(R.id.myroom_growup_search);
       
        myclass.setOnClickListener(new MyOnClickListener(1));
        rank.setOnClickListener(new MyOnClickListener(2));
        type.setOnClickListener(new MyOnClickListener(3));
        search.setOnClickListener(new MyOnClickListener(4));

    }

    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.myroom_growup_pager);
        fragmentsList = new ArrayList<Fragment>();

        Fragment Fragment01 = new RecPro(this);
        Fragment Fragment02 = new RecDec(this);
        Fragment Fragment03 = new RecPro(this);
        Fragment Fragment04 = new RecDec(this);
   

        fragmentsList.add(Fragment01);
        fragmentsList.add(Fragment02);
        fragmentsList.add(Fragment03);
        fragmentsList.add(Fragment04);
        

        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    };

    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:
                    myclass.setBackgroundResource(R.drawable.frage_item_line);
                    myclass.setTextColor(getResources().getColor(R.color.tab_text));
                  
                    rank.setBackgroundResource(0);
                    rank.setTextColor(getResources().getColor(R.color.type_back));
                   
                    type.setBackgroundResource(0);
                    type.setTextColor(getResources().getColor(R.color.type_back));
                    
                    search.setBackgroundResource(0);
                    search.setTextColor(getResources().getColor(R.color.type_back));
                    
                    break;
                case 1:
                	rank.setBackgroundResource(R.drawable.frage_item_line);
                    rank.setTextColor(getResources().getColor(R.color.tab_text));
                  
                    myclass.setBackgroundResource(0);
                    myclass.setTextColor(getResources().getColor(R.color.type_back));
                   
                    type.setBackgroundResource(0);
                    type.setTextColor(getResources().getColor(R.color.type_back));
                    
                    search.setBackgroundResource(0);
                    search.setTextColor(getResources().getColor(R.color.type_back));
                    break;
                case 2:
                	type.setBackgroundResource(R.drawable.frage_item_line);
                    type.setTextColor(getResources().getColor(R.color.tab_text));
                  
                    myclass.setBackgroundResource(0);
                    myclass.setTextColor(getResources().getColor(R.color.type_back));
                   
                    rank.setBackgroundResource(0);
                    rank.setTextColor(getResources().getColor(R.color.type_back));
                    
                    search.setBackgroundResource(0);
                    search.setTextColor(getResources().getColor(R.color.type_back));
                    break;
                case 3:
                	search.setBackgroundResource(R.drawable.frage_item_line);
                    search.setTextColor(getResources().getColor(R.color.tab_text));
                  
                    myclass.setBackgroundResource(0);
                    myclass.setTextColor(getResources().getColor(R.color.type_back));
                   
                    type.setBackgroundResource(0);
                    type.setTextColor(getResources().getColor(R.color.type_back));
                    
                    rank.setBackgroundResource(0);
                    rank.setTextColor(getResources().getColor(R.color.type_back));
                    break;
                
            }
            
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {}

        @Override
        public void onPageScrollStateChanged(int arg0) {}
    }

   

   
}
