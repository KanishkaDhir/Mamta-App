package com.hackathon.missionindradhanush;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Yashkirat Singh on 31-Mar-18.
 */

public class Vaccination_Details extends AppCompatActivity
{
    ListView listView;
    String vaccinationNames[]={"At Birth","After 6 weeks","After 10 weeks","After 14 weeks","After 9 month","After 16 months","After 1 year"};
    String status[]={"Yes","Yes","Yes","Yes","Yes","No","No"};
    String dates[]={"1 Mar 2018","15 Apr 2018","15 May 2018","15 June 2018","13 Feb 2019","1 July 2020","1 July 2021"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccination_details);

        Vaccine vac=new Vaccine(this,vaccinationNames,status,dates);
        listView=(ListView)findViewById(R.id.listViewVaccinationDetails);
        listView.setAdapter(vac);

    }
}
