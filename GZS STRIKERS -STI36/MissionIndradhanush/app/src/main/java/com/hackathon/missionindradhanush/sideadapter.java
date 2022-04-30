package com.hackathon.missionindradhanush;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class sideadapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public sideadapter(Context context)
    {

        this.context =context;
    }
    private   int[] slide_images ={

            R.drawable.mission,
            R.drawable.noti,
            R.drawable.mapspic,
            R.drawable.analytics
    };
    public String [] slideheading={
            "MISSION INDRADANUSH",
            "NOTIFICATIONS",
            "NEAR BY HOSPITALS",
            "STATICTICS"
    };
    public String [] slidedesc={
            "Mission Indradhanush launched by government to fully immunize all the children of INDIA by 2020.Mission Indradhanush App accomplish the goal of government digitally to make INDIA healthy and safe.  ",
            " Parents getting weekly updates of vaccines Immediately User will be notified when an immunization process of a vaccine will be completed.",
            "Users can instantly track nearby hospitals through MAP GUI.Tracking of nearby hospitals by GPS.",
            "For illiterate people Vaccination Report is represented in form of pie chart. Summary of Vaccines of a child individually."
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view== object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.sidelayout,container,false);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        TextView slidehead=view.findViewById(R.id.heading);
        TextView slidedescription=view.findViewById(R.id.desc);
        imageView.setImageResource(slide_images[position]);
        slidehead.setText(slideheading[position]);
        slidedescription.setText(slidedesc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
