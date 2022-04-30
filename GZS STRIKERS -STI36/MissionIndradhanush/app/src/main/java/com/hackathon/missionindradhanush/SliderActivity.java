package com.hackathon.missionindradhanush;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class SliderActivity extends Activity {
    private ViewPager viewPager;
    private LinearLayout dlayout;
    private sideadapter helloadapter;
    private TextView[] mdots;
    int mcurrentpage = 0;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        viewPager = findViewById(R.id.sideviewpager);
        dlayout = findViewById(R.id.dlayout);
        Calendar c=Calendar.getInstance();
        c.set(2018,Calendar.MARCH,19,23,32,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        Intent t=new Intent(SliderActivity.this,snotification.class);
        PendingIntent p=PendingIntent.getBroadcast(this,0,t,0);
        if (alarmManager != null) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),p);
        }
        helloadapter = new sideadapter(this);
        viewPager.setAdapter(helloadapter);
        adddotsindicator(0);
        viewPager.addOnPageChangeListener(viewlistener);
        btn1 = findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mdots.length);
            }
        });


    }

    public void adddotsindicator(int position) {
        mdots = new TextView[4];
        dlayout.removeAllViews();
        for (int i = 0; i < mdots.length; i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colortransparentwhite));
            dlayout.addView(mdots[i]);
        }
        if (mdots.length > 0) {
            mdots[position].setTextColor(getResources().getColor(R.color.colorwhite));
        }


    }

    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            adddotsindicator(position);
            mcurrentpage = position;
            if (position == 0) {
                btn1.setEnabled(true);


                btn1.setText("SKIP");


            } else if (position == mdots.length-1) {
                btn1.setEnabled(true);

                btn1.setText("FINISH");
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent l=new Intent(SliderActivity.this,LoginActivity.class);
                        SliderActivity.this.startActivity(l);

                    }
                });


            } else {
                btn1.setEnabled(true);

                btn1.setText("SKIP");


            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

