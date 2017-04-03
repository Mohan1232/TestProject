package com.example.mohan.testproject.API;


import com.example.mohan.testproject.Fragments.Models.Model_Data;
import com.example.mohan.testproject.Fragments.Models.Model_Report;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user1 on 7/3/2016.
 */
public interface ApiInterface {




    @GET("JhwvrifZ")
    Call<Model_Data> getList();


    @GET("5vDZpqPr")
    Call<Model_Data> getCarrier();


    @GET("sCG7Xmuw")
    Call<Model_Data> getTrailerStatus();


    @GET("H14dGMBV")
    Call<Model_Data> getLocation();



















}
