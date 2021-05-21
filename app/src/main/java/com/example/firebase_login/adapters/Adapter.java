package com.example.firebase_login.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_login.R;
import com.example.firebase_login.database.database_model;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewholder> {

    ArrayList<database_model> information;

    public Adapter(ArrayList<database_model> information) {
        this.information = information;
    }

    @Override
    public MyViewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recycler_view, parent, false);
        MyViewholder viewHolder = new MyViewholder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( Adapter.MyViewholder holder, int position) {
        String name=information.get(position).getName();
        holder.textView.setText(name);

    }

    @Override
    public int getItemCount() {
        return information.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewholder( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name_field);
        }
    }
}
