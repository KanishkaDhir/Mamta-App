package com.hackathon.missionindradhanush;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Empfragment extends Fragment {

  TextView vaccine1;
  TextView vaccine2;


    public Empfragment() {
        // Required empty public constructor
    }





    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle=this.getArguments();

        int vac1= bundle != null ? bundle.getInt("vaccine1") : 0;
        int vac2= bundle != null ? bundle.getInt("vaccine2") : 0;
        View view=inflater.inflate(R.layout.fragment_empfragment, container, false);
       vaccine1= view.findViewById(R.id.vaccine1);
        vaccine2= view.findViewById(R.id.vaccine2);
        String v1=Integer.toString(vac1);
        String v2=Integer.toString(vac2);
        v1=v1.concat("hello ji");
        v2=v2.concat("vadiya ji");
        vaccine1.setText(v1);
        vaccine2.setText(v2);



        configureImageButton1(view);

        return view;
    }

    private void configureImageButton1(View view) {

       Button button = (Button) view.findViewById(R.id.graph);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(v.getContext(), graph.class));
            }
        });



    }


}

