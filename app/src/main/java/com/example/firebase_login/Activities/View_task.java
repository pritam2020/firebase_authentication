package com.example.firebase_login.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firebase_login.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class View_task extends AppCompatActivity {
    TextView visible_task;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        visible_task=findViewById(R.id.visible_task);
        floatingActionButton=findViewById(R.id.fab);
        String name=getIntent().getExtras().get("name").toString();
        String task=getIntent().getExtras().get("task").toString();
        Objects.requireNonNull(getSupportActionBar()).setTitle(name);
        visible_task.setText(task);
        floatingActionButton.setOnClickListener(v -> {
            Intent intent=new Intent(View_task.this,add_task.class);
            startActivity(intent);
        });



    }
}