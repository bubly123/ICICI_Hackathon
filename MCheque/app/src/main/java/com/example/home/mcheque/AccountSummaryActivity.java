package com.example.home.mcheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.home.mcheque.accountSummary.AccountSummaryInterface;
import com.example.home.mcheque.accountSummary.AccountSummaryWebService;
import com.example.home.mcheque.utility.InternetConnectivityUtility;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountSummaryActivity extends AppCompatActivity {
    AccountSummaryInterface accountSummaryInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Account Summary");
        setContentView(R.layout.activity_account_summary);
        accountSummaryInterface = AccountSummaryWebService.getAccountSummaryCall();
    }

    private void callAccountSummaryWebService() {
        if(InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<ResponseBody> call = billPaymentInterface.setBillPayment("https://biller.mybluemix.net/biller/icicibank/billpay",
                    "mayuriardad@gmail.com",
                    ((MyApplication)getApplicationContext()).getAuthToken(),
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getCustomerId(),
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName(),
                    amt);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Log.i("BILL_PAYMENT", "Biller payment done!");
                        Intent intent = new Intent(ConfirmChequeActivity.this, InvoiceActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.i("BILL_PAYMENT", "failed.");
                }
            });
        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this,"No Internet available",Toast.LENGTH_LONG).show();
        }
    }
}
