package com.example.home.mcheque.homePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.home.mcheque.R;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
