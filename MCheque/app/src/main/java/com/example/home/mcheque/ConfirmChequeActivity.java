package com.example.home.mcheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.mcheque.billPayment.BillPaymentInterface;
import com.example.home.mcheque.billPayment.BillPaymentWebService;
import com.example.home.mcheque.homePage.HomePageActivity;
import com.example.home.mcheque.login.User;
import com.example.home.mcheque.mapBiller.MapBillerInterface;
import com.example.home.mcheque.mapBiller.MapBillerWebService;
import com.example.home.mcheque.schedulePay.SchedulePayInterface;
import com.example.home.mcheque.schedulePay.SchedulePayWebService;
import com.example.home.mcheque.utility.InternetConnectivityUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmChequeActivity extends AppCompatActivity {
 TextView tvConfirmAccNo, tvConfirmName, tvConfirmAmt, tvConfirmDate;
    Button buttonConfirm;
    MapBillerInterface mapBillerInterface;
    BillPaymentInterface billPaymentInterface;
    SchedulePayInterface schedulePayInterface;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_cheque);
        setTitle("Confirm Cheque");
        mapIds();
        setData();
        mapBillerInterface = MapBillerWebService.mapBiller();
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBillerApi();
            }
        });
    }

    private void mapIds() {
        tvConfirmAccNo = (TextView)findViewById(R.id.tvConfirmAccNo);
        tvConfirmName = (TextView)findViewById(R.id.tvConfirmName);
        tvConfirmAmt = (TextView)findViewById(R.id.tvConfirmAmount);
        tvConfirmDate = (TextView)findViewById(R.id.tvConfirmDate);
        buttonConfirm = (Button)findViewById(R.id.buttonConfirm);
    }

    private void setData() {
        Intent intent = getIntent();
        position = intent.getIntExtra("positionOfPayee",0);
        tvConfirmAccNo.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeAccountNo());
        tvConfirmName.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName());
        tvConfirmAmt.setText(getResources().getString(R.string.rupee) + " " + intent.getStringExtra("amount"));
        tvConfirmDate.setText(intent.getStringExtra("date"));
    }

    private void callBillerApi() {
        mapBiller();
    }

    private void mapBiller() {
        if(InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<ResponseBody> call = mapBillerInterface.getBillerMapped("https://biller.mybluemix.net/biller/icicibank/addbiller",
                    "mayuriardad@gmail.com",
                    ((MyApplication)getApplicationContext()).getAuthToken(),
                    "Tata Power",
                    "gujarat",
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getCustomerId(),
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName(),
                    tvConfirmAmt.getText().toString()
                    );
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Log.i("MAP_BILLER", "Biller mapped!");
//                        Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
//                        startActivity(intent);
                        createCheque();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.i("MAP_BILLER", "failed.");
                }
            });
        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this,"No Internet available",Toast.LENGTH_LONG).show();
        }
    }

    private void createCheque() {
        if(tvConfirmDate.getText().toString().equals(getFormattedCurrentDate())) {
            billPaymentInterface = BillPaymentWebService.makeBillPayment();
            billPayment();
        } else {
            schedulePayInterface = SchedulePayWebService.schedulePayment();
            schedulePay();
        }
    }

    private void billPayment() {
        if(InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<ResponseBody> call = billPaymentInterface.setBillPayment("https://biller.mybluemix.net/biller/icicibank/billpay",
                    "mayuriardad@gmail.com",
                    ((MyApplication)getApplicationContext()).getAuthToken(),
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getCustomerId(),
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName(),
                    Integer.parseInt(tvConfirmAmt.getText().toString()));

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Log.i("BILL_PAYMENT", "Biller mapped!");
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

    private void schedulePay() {
        if(InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<ResponseBody> call = mapBillerInterface.getBillerMapped("https://biller.mybluemix.net/biller/icicibank/addbiller",
                    "mayuriardad@gmail.com",
                    ((MyApplication)getApplicationContext()).getAuthToken(),
                    "Tata Power",
                    "gujarat",
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getCustomerId(),
                    ((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName(),
                    tvConfirmAmt.getText().toString()
            );
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Log.i("MAP_BILLER", "Biller mapped!");
//                        Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
//                        startActivity(intent);
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.i("MAP_BILLER", "failed.");
                }
            });
        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this,"No Internet available",Toast.LENGTH_LONG).show();
        }
    }

    private String getFormattedCurrentDate() {
        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(c.getTime());
    }
}
