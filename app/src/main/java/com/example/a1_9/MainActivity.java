package com.example.a1_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1_9.NetWork.Adapter.AdapterQuotes;
import com.example.a1_9.NetWork.ApiHandler;
import com.example.a1_9.NetWork.Models.AllResponce;
import com.example.a1_9.NetWork.Models.ApiResponse;
import com.example.a1_9.NetWork.Quotes;
import com.example.a1_9.NetWork.Service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ApiResponse> apiResponses;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AdapterQuotes quoteAdapter;

    final int DIALOG_EXIT = 1;

    private ApiService serviceMovie = ApiHandler.getInstance().getService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteAdapter = new AdapterQuotes(apiResponses = new ArrayList<>(), MainActivity.this);
        recyclerView = findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getQuotes();
    }
    private void getQuotes() {
        AsyncTask.execute(() -> {
            serviceMovie.getQuotes().enqueue(new Callback<AllResponce>() {
                @Override
                public void onResponse(Call<AllResponce> call, Response<AllResponce> response) {
                    if(response.isSuccessful()){
                        apiResponses = new ArrayList<ApiResponse>(response.body().getData());
                        quoteAdapter = new AdapterQuotes(apiResponses, MainActivity.this);
                        recyclerView.setAdapter(quoteAdapter);
                    }
                }
                @Override
                public void onFailure(Call<AllResponce> call, Throwable t) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Ошибочка вышла")
                            .setMessage(t.getLocalizedMessage())
                            .setNegativeButton("Okay", null)
                            .create()
                            .show();
                }
            });
        });
    }
}