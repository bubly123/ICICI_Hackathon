package com.example.home.mcheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.mcheque.accountSummary.AccountSummary;
import com.example.home.mcheque.accountSummary.AccountSummaryInterface;
import com.example.home.mcheque.accountSummary.AccountSummaryWebService;
import com.example.home.mcheque.utility.InternetConnectivityUtility;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountSummaryActivity extends AppCompatActivity {
    AccountSummaryInterface accountSummaryInterface;
    TextView tvSummaryAccountNo, tvSummaryBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Account Summary");
        setContentView(R.layout.activity_account_summary);
        mapIds();
        accountSummaryInterface = AccountSummaryWebService.getAccountSummaryCall();
        callAccountSummaryWebService();
    }

    private void mapIds() {
        tvSummaryAccountNo = (TextView)findViewById(R.id.tvSummaryAccountNo);
        tvSummaryBalance = (TextView)findViewById(R.id.tvSummaryBalance);
    }

    private void callAccountSummaryWebService() {
        if(InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<List<AccountSummary>> call = accountSummaryInterface.getAccountSummary("https://retailbanking.mybluemix.net/banking/icicibank/balanceenquiry",
                    "mayuriardad@gmail.com",
                    ((MyApplication)getApplicationContext()).getAuthToken(),
                    "4444777755552213"
                    );

            call.enqueue(new Callback<List<AccountSummary>>() {
                @Override
                public void onResponse(Call<List<AccountSummary>> call, Response<List<AccountSummary>> response) {
                    if (response.isSuccessful()) {
                        Log.i("ACCOUNT_SUMMARY", "Received account summary!");
                        tvSummaryAccountNo.setText(response.body().get(1).getAccountNo());
                        tvSummaryBalance.setText(getResources().getString(R.string.rupee) + " " + response.body().get(1).getBalance());
                    }
                }
                @Override
                public void onFailure(Call<List<AccountSummary>> call, Throwable t) {
                    Log.i("ACCOUNT_SUMMARY", "failed.");
                }
            });
        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this,"No Internet available",Toast.LENGTH_LONG).show();
        }
    }
}
