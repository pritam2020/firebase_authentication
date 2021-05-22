package com.example.firebase_login.database;

import com.google.firebase.auth.FirebaseUser;

public class set_data extends Thread{
    FirebaseUser user;
    String task;

    public set_data(FirebaseUser user,String task) {
        this.user=user;
        this.task=task;
    }

    @Override
    public void run() {

        database_model model=new database_model();

        model.setName(user.getDisplayName());
        model.setTask(task);
        database_connection.connection().child(user.getUid()).setValue(model);
    }


}

