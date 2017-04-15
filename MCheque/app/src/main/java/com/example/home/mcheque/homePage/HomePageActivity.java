package com.example.home.mcheque.homePage;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.home.mcheque.LoginActivity;
import com.example.home.mcheque.MyApplication;
import com.example.home.mcheque.R;
import com.example.home.mcheque.login.User;
import com.example.home.mcheque.participantDataMapping.Accounts;
import com.example.home.mcheque.participantDataMapping.CustomerDetails;
import com.example.home.mcheque.participantDataMapping.ParticipantDataMappingInterface;
import com.example.home.mcheque.participantDataMapping.ParticipantDataMappingWebService;
import com.example.home.mcheque.utility.InternetConnectivityUtility;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity {
    Button buttonSendCheque;
    private ParticipantDataMappingInterface participantDataMappingInterface;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        buttonSendCheque = (Button) findViewById(R.id.buttonSendCheque);
        participantDataMappingInterface = ParticipantDataMappingWebService.getParticipantDataMapped();
        buttonSendCheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sendCheque();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    void sendCheque() throws IOException {
        if (InternetConnectivityUtility.isNetworkAvailable(this)) {

            Call<List<Accounts>> call = participantDataMappingInterface.getParticpantMappingData("https://retailbanking.mybluemix.net/banking/icicibank/participantmapping",
                    "mayuriardad@gmail.com");

            call.enqueue(new Callback<List<Accounts>>() {
                @Override
                public void onResponse(Call<List<Accounts>> call, Response<List<Accounts>> response) {
                    Log.i("url", response.raw().request().url().toString());
                    if(response.isSuccessful()) {
                        Log.i("ACC_NO","account no "+ response.body().get(0).getAccountNo());
                        CustomerDetails customerDetailOne = new CustomerDetails(response.body().get(0).getAccountNo(),
                                response.body().get(0).getCustId());
                        CustomerDetails customerDetailTwo = new CustomerDetails(response.body().get(2).getAccountNo(),
                                response.body().get(2).getCustId());
                        CustomerDetails customerDetailThree = new CustomerDetails(response.body().get(4).getAccountNo(),
                                response.body().get(4).getCustId());
                        CustomerDetails customerDetailFour = new CustomerDetails(response.body().get(6).getAccountNo(),
                                response.body().get(6).getCustId());
                        ((MyApplication)getApplicationContext()).customerDetails = new ArrayList<CustomerDetails>();
                        ((MyApplication)getApplicationContext()).customerDetails.add(customerDetailOne);
                        ((MyApplication)getApplicationContext()).customerDetails.add(customerDetailTwo);
                        ((MyApplication)getApplicationContext()).customerDetails.add(customerDetailThree);
                        ((MyApplication)getApplicationContext()).customerDetails.add(customerDetailFour);
                        //Log.i("JSON", new Gson().toJson(response.body().toString()));
                    }
                    else {
                        Log.i("ACC_NO","success code is not 200 " +response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Accounts>> call, Throwable t) {
                    Log.i("ACC_NO", "failed.");
                }
            });

        } else {
            Log.i("NO_INTERNET", "No internet available");
            Toast.makeText(this, "No Internet available", 2);
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("HomePage Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
