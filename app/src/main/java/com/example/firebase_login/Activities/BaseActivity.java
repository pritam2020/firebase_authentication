package com.example.firebase_login.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.firebase_login.R;
import com.example.firebase_login.database.database_model;
import com.example.firebase_login.database.retrive_data;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.firebase_login.database.retrive_data.retrive;

public class BaseActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    RecyclerView recyclerView;
    ArrayList<database_model> model=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        recyclerView=findViewById(R.id.recycler_view);


        retrive(this,recyclerView);








    }

}