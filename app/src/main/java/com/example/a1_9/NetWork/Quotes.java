package com.example.a1_9.NetWork;

import com.example.a1_9.MainActivity;
import com.example.a1_9.NetWork.Models.ApiResponse;

import java.util.ArrayList;

public class Quotes {

    String title;
    String description;
    int image;

    public Quotes(String title, String description, int image){
        this.description = description;
        this.title = title;
        this.image = image;
    }
}
