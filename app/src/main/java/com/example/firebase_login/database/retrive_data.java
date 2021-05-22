package com.example.firebase_login.database;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_login.adapters.Adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class retrive_data  {



     public static void retrive(Context context, RecyclerView recyclerView){


         try {



             database_connection.connection().addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(DataSnapshot snapshot) {
                     ArrayList<database_model> information;
                     information = new ArrayList<database_model>();
                    // information=null;
                     for (DataSnapshot unit : snapshot.getChildren()) {
                         database_model modell = unit.getValue(database_model.class);
                         information.add(modell);
                     }


                     recyclerView.setLayoutManager(new LinearLayoutManager(context));
                     Adapter adapter = new Adapter(information,context);
                     recyclerView.setAdapter(adapter);
                 }


                 @Override
                 public void onCancelled(DatabaseError error) {
                     Toast.makeText(context,"unable to retrive data",Toast.LENGTH_SHORT).show();
                 }
             });

         }
         catch (Exception e){
             Toast.makeText(context,"Catch",Toast.LENGTH_SHORT).show();

         }
     }


}

