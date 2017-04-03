package com.example.mohan.testproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mohan.testproject.Fragments.Models.Model_Report;
import com.example.mohan.testproject.R;

import java.util.List;

/**
 * Created by jiten on 7/03/2017.
 */
public class Adapter_Report extends RecyclerView.Adapter<Adapter_Report.ContactViewHolder> {
    List<Model_Report> list;
    Context context;


    public Adapter_Report(List<Model_Report> list, Context context){
        this.list = list;
        this.context = context;

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabular_card, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Model_Report model = list.get(position);
        holder.row1.setText(model.getCol1());
        holder.row2.setText(model.getCol2());
        holder.row3.setText(model.getCol3());
        holder.row4.setText(model.getCol4());
        holder.row5.setText(model.getCol5());
        holder.row6.setText(model.getCol6());
        holder.row7.setText(model.getCol7());
        holder.row8.setText(model.getCol8());
        holder.row9.setText(model.getCol9());
        holder.row10.setText(model.getCol10());
        holder.row11.setText(model.getCol11());
        holder.row12.setText(model.getCol12());
        holder.row13.setText(model.getCol13());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView row1 , row2 , row3 , row4 , row5 , row6 , row7 , row8 , row9 , row10 ,row11 ,row12 ,row13;


        public ContactViewHolder(View itemView) {
            super(itemView);

            row1 = (TextView) itemView.findViewById(R.id.col1);
            row2 = (TextView) itemView.findViewById(R.id.col2);
            row3 = (TextView) itemView.findViewById(R.id.col3);
            row4 = (TextView) itemView.findViewById(R.id.col4);
            row5 = (TextView) itemView.findViewById(R.id.col5);
            row6 = (TextView) itemView.findViewById(R.id.col6);
            row7 = (TextView) itemView.findViewById(R.id.col7);
            row8 = (TextView) itemView.findViewById(R.id.col8);
            row9 = (TextView) itemView.findViewById(R.id.col9);
            row10 = (TextView) itemView.findViewById(R.id.col10);
            row11 = (TextView) itemView.findViewById(R.id.col11);
            row12 = (TextView) itemView.findViewById(R.id.col12);
            row13 = (TextView) itemView.findViewById(R.id.col13);


        }
    }
}
