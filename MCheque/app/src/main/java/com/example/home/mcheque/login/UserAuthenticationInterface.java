package com.example.home.mcheque.login;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserAuthenticationInterface {
    @GET("mybank/authenticate_client")
//    @FormUrlEncoded
    Call <List<User>> getAuthToken(@Query("client_id") String clientId,
                             @Query("password") String password);
}
