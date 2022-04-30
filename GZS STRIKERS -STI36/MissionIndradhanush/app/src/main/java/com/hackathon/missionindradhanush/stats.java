package com.hackathon.missionindradhanush;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class stats extends AppCompatActivity {
ViewPager viewPager;
int n=4;
int k=0;
int test[]=new int[n];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        viewPager=findViewById(R.id.viewpager);

        for(k=0;k<n;k++)
        {
            test[k]=k;
        }
        viewPager.setAdapter(new fragmentadapter(getSupportFragmentManager()) );
    }

   private class fragmentadapter extends FragmentStatePagerAdapter{


        private fragmentadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle;
            com.hackathon.missionindradhanush.Empfragment empfragment=new com.hackathon.missionindradhanush.Empfragment();
            for ( k=0;k<n;k++) {

                if(position==k)
                {
                    bundle=new Bundle();
                    bundle.putInt("vaccine1",test[k]);
                    bundle.putInt("vaccine2",test[k]);
                    empfragment.setArguments(bundle);
                    break;
                }
            }

            return empfragment;
        }

        @Override
        public int getCount() {
            return n;
        }
    }
}
