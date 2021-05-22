package com.example.firebase_login.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase_login.R;
import com.example.firebase_login.database.set_data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class add_task extends AppCompatActivity {

    Button save;
    EditText task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        save=findViewById(R.id.save);
        task=findViewById(R.id.enter_text);
        save.setOnClickListener(v -> {
            set_data upload=new set_data(FirebaseAuth.getInstance().getCurrentUser(), task.getText().toString().trim());
            upload.start();
            finish();
        });
    }
}