package com.example.home.mcheque.schedulePay;

import com.example.home.mcheque.mapBiller.MapBillerInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by home on 10/04/17.
 */

public interface SchedulePayInterface {
    @GET
    Call<ResponseBody> setSchedulePay(@Url String url,
                                       @Query("client_id") String clientId,
                                       @Query("token") String token,
                                       @Query("custid") String custId,
                                       @Query("nickname") String nickName,
                                       @Query("consumerno") String consumerNo,
                                       @Query("autodate") int autoDate,
                                       @Query("limitedpay") String limitedPay,
                                       @Query("limitedamt") int limitedAmount);
}
