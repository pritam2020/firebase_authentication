package com.example.firebase_login.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.firebase_login.R;
import com.example.firebase_login.database.authentication;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    String TAG="FIREBASE";
    Button sign,sign_out,delete;
    com.example.firebase_login.database.authentication authentication;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign =findViewById(R.id.sign_in);
        sign_out=findViewById(R.id.sign_out);
        delete=findViewById(R.id.sign_delete);
        user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(MainActivity.this, BaseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        authentication=new authentication(MainActivity.this);
        sign.setOnClickListener(v->{
          user= authentication.sign_in(v);
            Intent intent=new Intent(MainActivity.this, BaseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

    }

}