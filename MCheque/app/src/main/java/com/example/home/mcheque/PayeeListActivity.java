package com.example.home.mcheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.home.mcheque.homePage.HomePageActivity;
import com.example.home.mcheque.login.User;
import com.example.home.mcheque.payeeList.Payee;
import com.example.home.mcheque.payeeList.PayeeListInterface;
import com.example.home.mcheque.payeeList.PayeeListWebService;
import com.example.home.mcheque.utility.InternetConnectivityUtility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayeeListActivity extends AppCompatActivity {
    private PayeeListInterface mPayeeListInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payee_list);
        Button mListPayeeButton = (Button) findViewById(R.id.list_payee_button);
        mPayeeListInterface = PayeeListWebService.getPayeeListService();

        mListPayeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPayees();
            }
        });


    }
    private void listPayees(){
        if(InternetConnectivityUtility.isNetworkAvailable(this)) {
            Call<List<Payee>> call = mPayeeListInterface.getPayeeList("mayuriardad@gmail.com","f013e6f28854", "33337213");
//            call.enqueue(new Callback<List<Payee>>() {
            call.enqueue(new Callback<List<Payee>>() {
                @Override
                public void onResponse(Call<List<Payee>> call, Response<List<Payee>> response) {
                    if (response.isSuccessful()) {
                        List<Payee> payees = response.body();
                        //((MyApplication)getApplicationContext()).setAuthToken(payees.get(1).getToken());
                        Log.i("payee name", "payee name."+ payees.get(1).getPayeeName());
                        //Intent intent = new Intent(PayeeListActivity.this, HomePageActivity.class);
                        //startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<List<Payee>> call, Throwable t) {

                }
            });
        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this,"No Internet available",Toast.LENGTH_SHORT);
        }

    }
}
