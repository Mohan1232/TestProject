package com.example.mohan.testproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohan.testproject.R;

/**
 * Created by jiten on 2/04/2017.
 */
public class Fragment_main extends Fragment implements View.OnClickListener {
    TextView report , entry;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle SaveInstanceState) {
        View view = inflater.inflate(R.layout.main_layout, parent, false);


        report = (TextView)  view.findViewById(R.id.rpt);
        entry  = (TextView)   view.findViewById(R.id.ent);



        report.setOnClickListener(this);
        entry.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        int id =v.getId();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();


        if(id == R.id.rpt){
            Fragment fragment = new Fragment_TabularView();
            fragmentManager.beginTransaction().replace(R.id.contain , fragment).addToBackStack(null).commit();

        }
        else if(id ==R.id.ent){
            Fragment fragment = new Fragment_Entry();
            fragmentManager.beginTransaction().replace(R.id.contain , fragment).addToBackStack(null).commit();

        }
    }
}
