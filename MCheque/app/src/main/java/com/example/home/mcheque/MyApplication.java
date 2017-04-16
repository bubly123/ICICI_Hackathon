package com.example.home.mcheque;

import android.app.Application;

import com.example.home.mcheque.payeeList.Payee;

import java.util.List;

public class MyApplication extends Application{
    private String authToken = "";
    public List<Payee> payeeList;
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
