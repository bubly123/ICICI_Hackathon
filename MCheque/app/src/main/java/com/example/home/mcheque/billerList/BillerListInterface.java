package com.example.home.mcheque.billerList;

import com.example.home.mcheque.payeeList.Payee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Mayu on 16-04-2017.
 */

public interface BillerListInterface {
    @GET
    Call<List<Biller>> getBillerList(@Url String url, @Query("client_id") String client_id, @Query("token") String token, @Query("billername") String billername);
}
