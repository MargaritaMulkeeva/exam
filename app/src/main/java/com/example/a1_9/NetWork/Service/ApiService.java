package com.example.a1_9.NetWork.Service;

import com.example.a1_9.NetWork.Models.AllResponce;
import com.example.a1_9.NetWork.Models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("quotes")
    Call<AllResponce> getQuotes();
}
