package com.hackathon.missionindradhanush;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

/**
 * Created by Yashkirat Singh on 31-Mar-18.
 */

public class Vaccine extends ArrayAdapter<String>
{

    Activity context;
    String vacinationNames[];
    String status[];
    String vaccinationDates[];

    public Vaccine(Activity context, String vacinationNames[],String status[], String vaccinationDates[])
    {
        super(context,R.layout.vaccination_details_row,vacinationNames);
        this.context=context;
        this.vacinationNames=vacinationNames;
        this.status=status;
        this.vaccinationDates=vaccinationDates;

    }


    /*@Override
    public int getCount()
    {
        return 0;
    }
*/
  /*  @Override
    public long getItemId(int position)
    {
        return 0;
    }
*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.vaccination_details_row,null,true);

        TextView tvHeading=rowView.findViewById(R.id.tvHeadingVaccinationDetailsRow);
        TextView tvDesc=rowView.findViewById(R.id.tvDescVaccinationDetailsRow);
        TextView tvVaccinationDates=rowView.findViewById(R.id.tvDateVaccinationDates);


        tvHeading.setText(vacinationNames[position]);
        tvDesc.setText(status[position]);
        tvVaccinationDates.setText(vaccinationDates[position]);



        return rowView;
    }
}
