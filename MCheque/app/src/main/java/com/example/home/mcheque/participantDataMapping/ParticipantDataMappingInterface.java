package com.example.home.mcheque.participantDataMapping;

import android.accounts.Account;

import com.example.home.mcheque.login.User;


import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by roman on 14/4/17.
 */

public interface ParticipantDataMappingInterface {
    @GET
    //https://retailbanking.mybluemix.net/banking/icicibank/participantmapping?client_id=mayuriardad@gmail.com

    ////https://retailbanking.mybluemix.net/banking/icicibank/participantmapping?client_id=mayuriardad@gmail.com
//    @FormUrlEncoded
    Call <List<Accounts>> getParticpantMappingData(@Url String url,
                                                 @Query("client_id") String clientId);
}
