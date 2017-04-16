package com.example.home.mcheque.billerList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.home.mcheque.MyApplication;
import com.example.home.mcheque.R;
import com.example.home.mcheque.payeeList.Payee;
import com.example.home.mcheque.utility.InternetConnectivityUtility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillerActivity extends AppCompatActivity {
    private BillerListInterface mBillerListInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mBillerListInterface = BillerListWebService.getBillerListService();

        listBillers();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void listBillers() {
        if (InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<List<Biller>> call = mBillerListInterface.getBillerList("https://retailbanking.mybluemix.net/banking/icicibank/listBiller",
                    "mayuriardad@gmail.com", ((MyApplication) getApplicationContext()).getAuthToken(), "33337213");
            call.enqueue(new Callback<List<Biller>>() {
                @Override
                public void onResponse(Call<List<Biller>> call, Response<List<Biller>> response) {
                    if (response.isSuccessful()) {
                        List<Biller> Billers = response.body();
                        Biller billerOne = new Biller(
                                response.body().get(1).getBillerDetail(),
                                response.body().get(1).getState()
                        );
                        ((MyApplication)getApplicationContext()).billerList = new ArrayList<Biller>();
                        ((MyApplication)getApplicationContext()).billerList.add(billerOne);
                        Log.i("PRINT", "biller details " + ((MyApplication) getApplicationContext()).billerList.get(1).getBillerDetail());
                        //((MyApplication)getApplicationContext()).setAuthToken(Billers.get(1).getToken());
                        Log.i("Biller name", "Biller name." + Billers.get(1).getBillerDetail());
                        //Intent intent = new Intent(BillerListActivity.this, HomePageActivity.class);
                        //startActivity(intent);
                    }
                }
                @Override
                public void onFailure(Call<List<Biller>> call, Throwable t) {

                }
            });
        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this, "No Internet available", Toast.LENGTH_SHORT).show();
        }
    }
}
