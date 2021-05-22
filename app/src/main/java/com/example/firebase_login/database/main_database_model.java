package com.example.firebase_login.database;

import java.util.ArrayList;

public class main_database_model {
    public void setData(ArrayList<database_model> data) {
        this.data = data;
    }

    public ArrayList<database_model> getData() {
        return data;
    }

    private ArrayList<database_model> data;
    public main_database_model() {
    }

}
