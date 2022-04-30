package com.hackathon.missionindradhanush;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class graph extends AppCompatActivity {
PieChart piechart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        piechart=findViewById(R.id.piechart);
        piechart.setUsePercentValues(false);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,5);
        piechart.setDragDecelerationFrictionCoef(0.99f);
        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);
        ArrayList<PieEntry> yValues =new ArrayList<>();
        yValues.add(new PieEntry(14f,"VACCINE 1"));
        yValues.add(new PieEntry(14f,"VACCINE 2"));
        yValues.add(new PieEntry(14f,"VACCINE 3"));
        yValues.add(new PieEntry(14f,"VACCINE 4"));
        yValues.add(new PieEntry(14f,"VACCINE 5"));
        yValues.add(new PieEntry(14f,"VACCINE 6"));
        yValues.add(new PieEntry(14f,"VACCINE 7"));
        piechart.animateY(1000, Easing.EasingOption.EaseInOutCubic);
        PieDataSet dataset =new PieDataSet(yValues,"Vaccine");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);
        ArrayList<Integer> color=new ArrayList<>();
color.add(Color.rgb(238,130,238));
        color.add(Color.rgb(238,130,238));
        color.add(Color.rgb(75, 0, 130));
        color.add(Color.rgb(0, 0, 255));
        color.add(Color.rgb(0, 255, 0));
        color.add(Color.rgb(211,211,211));
        color.add(Color.rgb(211,211,211));
        dataset.setColors(color);
        PieData data= new PieData(dataset);
        data.setValueTextColor(Color.TRANSPARENT);
        data.setValueTextSize(10f);
        piechart.setData(data);









    }
}
