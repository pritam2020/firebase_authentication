package com.example.firebase_login.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.firebase_login.R;

import java.util.Objects;

public class task extends AppCompatActivity {
    EditText visible_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        visible_task=findViewById(R.id.visible_task);
        String name=getIntent().getExtras().get("name").toString();
        String task=getIntent().getExtras().get("task").toString();
        Objects.requireNonNull(getSupportActionBar()).setTitle(name);
        visible_task.setText(task);



    }
}