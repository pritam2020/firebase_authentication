package com.example.firebase_login.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class database_connection {
    public static FirebaseDatabase firebaseDatabase;
    public static DatabaseReference reference;

     public  database_connection(){ }

    public static DatabaseReference connection(){
        firebaseDatabase= FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference("users");
        return reference;
    }
}
