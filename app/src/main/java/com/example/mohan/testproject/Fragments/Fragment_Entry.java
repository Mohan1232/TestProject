package com.example.mohan.testproject.Fragments;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.mohan.testproject.API.ApiClient;
import com.example.mohan.testproject.API.ApiInterface;
import com.example.mohan.testproject.Adapters.Adapter_Report;
import com.example.mohan.testproject.Fragments.Models.Model_Data;
import com.example.mohan.testproject.Fragments.Models.Model_dropdown;
import com.example.mohan.testproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jiten on 3/04/2017.
 */
public class Fragment_Entry extends Fragment {

    Spinner spn1  , spn3 , spn4;
    List<Model_dropdown> list;
    List<String>  items;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup parent , Bundle SavedInstanceState){
        View  view  =inflater.inflate(R.layout.entry_layout  , parent , false);

        spn1 = (Spinner)  view.findViewById(R.id.carrier);

        spn3 = (Spinner)  view.findViewById(R.id.location);
        spn4  = (Spinner) view.findViewById(R.id.trailerStatus);






        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Model_Data> call = apiService.getCarrier();

        call.enqueue(new Callback<Model_Data>() {
            @Override
            public void onResponse(Call<Model_Data> call, Response<Model_Data> response) {

                int statusCode = response.code();
                list = response.body().getDropdowns();
                items = getItems();
                ArrayAdapter<String> adapter;

                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, items);
                spn1.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Model_Data> call, Throwable t) {
            }
        });


        apiService =
                ApiClient.getClient().create(ApiInterface.class);

      call = apiService.getLocation();

        call.enqueue(new Callback<Model_Data>() {
            @Override
            public void onResponse(Call<Model_Data> call, Response<Model_Data> response) {

                int statusCode = response.code();
                list = response.body().getDropdowns();
                items = getItems();
                ArrayAdapter<String> adapter;

                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
                spn3.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Model_Data> call, Throwable t) {

            }
        });

        apiService =
                ApiClient.getClient().create(ApiInterface.class);

        call = apiService.getTrailerStatus();

        call.enqueue(new Callback<Model_Data>() {
            @Override
            public void onResponse(Call<Model_Data> call, Response<Model_Data> response) {

                int statusCode = response.code();
                list = response.body().getDropdowns();
                items = getItems();
                ArrayAdapter<String> adapter;

                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
                spn4.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Model_Data> call, Throwable t) {

            }
        });


        return view;

    }

    private List<String> getItems() {

        ArrayList<String> li = new ArrayList<>();

        for(int id =0 ; id<list.size() ; id++) {
            li.add(list.get(id).getName());
        }
        return li;
    }


}
