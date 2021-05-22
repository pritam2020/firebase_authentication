package com.example.firebase_login.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.firebase_login.R;
import com.example.firebase_login.database.database_model;
import com.example.firebase_login.database.retrive_data;
import com.google.android.material.switchmaterial.SwitchMaterial;
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
    TextView mode;
    SwitchMaterial switchMaterial;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        recyclerView=findViewById(R.id.recycler_view);
        switchMaterial=findViewById(R.id.switcher);
        mode=findViewById(R.id.mode_state);
        sharedPreferences=getSharedPreferences("Mode",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        boolean state=sharedPreferences.getBoolean("mode",true);//dark== true

        if (state){
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_YES);
            switchMaterial.setChecked(true);
            mode.setText("switch to light mode");
        }else {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_NO);
            switchMaterial.setChecked(false);
            mode.setText("switch to dark mode");
        }
        switchMaterial.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate
                        .setDefaultNightMode(
                                AppCompatDelegate
                                        .MODE_NIGHT_YES);
                editor.putBoolean("mode",true);
                editor.apply();
                mode.setText("switch to light mode");
            }else {
                AppCompatDelegate
                        .setDefaultNightMode(
                                AppCompatDelegate
                                        .MODE_NIGHT_NO);
                editor.putBoolean("mode",false);
                editor.apply();
                mode.setText("switch to dark mode");
            }
        });


        retrive(this,recyclerView);








    }

}