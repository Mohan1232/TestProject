package com.example.mohan.testproject.Fragments.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jiten on 2/04/2017.
 */
public class Model_Data {

    @SerializedName("TruckCenterData")
    @Expose
    private List<Model_Report> data = null;

    public List<Model_Report> getData() {
        return data;
    }

    @SerializedName("ValidData")
    @Expose
    private List<Model_dropdown> dropdowns = null;

    public List<Model_dropdown> getDropdowns() {
        return dropdowns;
    }
}
