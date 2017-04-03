package com.example.mohan.testproject.Fragments;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mohan.testproject.API.ApiClient;
import com.example.mohan.testproject.API.ApiInterface;
import com.example.mohan.testproject.Adapters.Adapter_Report;
import com.example.mohan.testproject.Fragments.Models.Model_Data;
import com.example.mohan.testproject.Fragments.Models.Model_Report;
import com.example.mohan.testproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jiten on 2/04/2017.
 */
public class Fragment_TabularView extends Fragment{
    EditText txt;
    List<Model_Report> list;
    Adapter_Report adapter;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup parent , Bundle SaveInstanceState){
        View view = inflater.inflate(R.layout.tabular_layout , parent ,false);

        txt = (EditText) view.findViewById(R.id.inputSearch);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);

        addTextListener();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Model_Data> call = apiService.getList();

        call.enqueue(new Callback<Model_Data>() {
            @Override
            public void onResponse(Call<Model_Data> call, Response<Model_Data> response) {

                int statusCode = response.code();

                list = response.body().getData();
                adapter = new Adapter_Report(list, getActivity());
                recyclerView.setAdapter(adapter);





            }

            @Override
            public void onFailure(Call<Model_Data> call, Throwable t) {

            }
        });


        return view;
    }

    public void addTextListener() {

        txt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<Model_Report> filteredList = new ArrayList<>();


                for (int i = 0; i < list.size(); i++) {

                    final String textId = list.get(i).getCol12().toString().toLowerCase();
                    final String textStatus = list.get(i).getCol13().toString().toLowerCase();
                    if (textId.contains(query)) {


                        filteredList.add(list.get(i));

                    }
                    else if(textStatus.contains(query)){
                        filteredList.add(list.get(i));
                    }
                }



                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                adapter = new Adapter_Report(filteredList , getActivity());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });



    }


}
