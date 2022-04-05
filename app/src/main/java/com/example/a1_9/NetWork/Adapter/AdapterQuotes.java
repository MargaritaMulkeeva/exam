package com.example.a1_9.NetWork.Adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1_9.NetWork.Models.ApiResponse;
import com.example.a1_9.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterQuotes extends RecyclerView.Adapter<AdapterQuotes.ViewHolder>{

    private ArrayList<ApiResponse> apiResponses;
    private LayoutInflater inflater;
    private Context context;
    private LinearLayout linearLayout;

    public AdapterQuotes(ArrayList<ApiResponse> apiResponses, Context context) {
        this.apiResponses = apiResponses;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }
    @NonNull
    @Override
    public AdapterQuotes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ApiResponse apiResponse = apiResponses.get(position);
        holder.setTxtTitle(apiResponse.getTitle());
        holder.setTxtDescriprion(apiResponse.getDescription());
        Picasso.with(context).load(apiResponse.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return apiResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final private ImageView image;
        final private TextView txtTitle;
        final private TextView txtDescriprion;

        private ViewHolder(View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.image);
            this.txtTitle = (TextView) view.findViewById(R.id.tv_title);
            this.txtDescriprion = (TextView) view.findViewById(R.id.tv_description);
        }

        public void setTxtTitle(String text){
            this.txtTitle.setText(text);
        }

        public void setTxtDescriprion(String text){
            this.txtDescriprion.setText(text);
        }
    }

}
