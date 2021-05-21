package com.example.firebase_login.database;

public class database_model {
    private String name;
    private String task;

    public database_model(){

    }
    public void setTask(String task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getTask() {
        return task;
    }
}
