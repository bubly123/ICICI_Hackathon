package com.example.home.mcheque.payeeList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Mayu on 14-04-2017.
 */

public interface PayeeListInterface {
    //?client_id=mayuriardad@gmail.com&token=f013e6f28854&custid=33337213"
    @GET
    Call <List<Payee>> getPayeeList(@Url String url,@Query("client_id") String client_id, @Query("token") String token, @Query("custid") String cust_id);
    }

