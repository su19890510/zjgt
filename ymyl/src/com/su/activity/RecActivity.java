package com.su.activity;

import java.util.ArrayList;

import com.su.rec.RecDec;
import com.su.rec.RecPro;
import com.su.tool.net.MyFragmentPagerAdapter;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class RecActivity extends FragmentActivity implements OnClickListener {

    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private int currIndex = 0;
    private TextView decTextView;
    private TextView proTextView;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchactivity);
        InitTextView();
        InitViewPager();
    }

    private void InitTextView() {
        decTextView = (TextView) findViewById(R.id.rec_type_dec);
        proTextView = (TextView) findViewById(R.id.rec_type_pro);
       
        decTextView.setOnClickListener(new MyOnClickListener(1));
        proTextView.setOnClickListener(new MyOnClickListener(2));

    }

    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.match_activity_pager);
        fragmentsList = new ArrayList<Fragment>();

        Fragment Fragment01 = new RecPro(this);
        Fragment Fragment02 = new RecDec(this);
   

        fragmentsList.add(Fragment01);
        fragmentsList.add(Fragment02);
        

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
                    proTextView.setBackgroundResource(R.drawable.frage_item_line);
                    proTextView.setTextColor(getResources().getColor(R.color.tab_text));
                  
                    decTextView.setBackgroundResource(0);
                    decTextView.setTextColor(getResources().getColor(R.color.type_back));
                   
                    break;
                case 1:
                	proTextView.setBackgroundResource(0);
                    proTextView.setTextColor(getResources().getColor(R.color.type_back));
                  
                    decTextView.setBackgroundResource(R.drawable.frage_item_line);
                    decTextView.setTextColor(getResources().getColor(R.color.tab_text));
                    break;
                
            }
            currIndex = arg0;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {}

        @Override
        public void onPageScrollStateChanged(int arg0) {}
    }

    @Override
    public void onClick(View v) {

    }
}
