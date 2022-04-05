package com.example.a1_9.NetWork.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllResponce {
    @SerializedName("data")
    List<ApiResponse> data = new ArrayList<>();

    public List<ApiResponse> getData() {
        return data;
    }

    public void setData(List<ApiResponse> data) {
        this.data = data;
    }
}
