package com.example.home.mcheque;

import android.app.Application;

import com.example.home.mcheque.participantDataMapping.CustomerDetails;

import java.util.List;

public class MyApplication extends Application{
    private String authToken = "";
    public List<CustomerDetails> customerDetails;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
