package com.example.home.mcheque.billPayment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by home on 10/04/17.
 */

public interface BillPaymentInterface {
    @GET
    Call<ResponseBody> setBillPayment(@Url String url,
                                       @Query("client_id") String clientId,
                                       @Query("token") String token,
                                       @Query("custid") String custId,
                                       @Query("nickname") String nickName,
                                       @Query("amount") int consumerNo);
}
