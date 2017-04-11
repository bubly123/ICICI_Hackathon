package com.example.home.mcheque.schedulePay;

import com.example.home.mcheque.mapBiller.MapBillerInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by home on 10/04/17.
 */

public class SchedulePayWebService {
    private SchedulePayWebService() {}

    public static final String BASE_URL_MAP = "https://biller.mybluemix.net/biller/icicibank/";

//    https://biller.mybluemix.net/biller/icicibank/schedulePay?client_id=mayuriardad@gmail.com&toke
//    n=2f1f6e397244&custid=33337213&nickname=A2214&consumerno=79202021112&autodate=10&limitedpay=Y&limitedamt=10

    public static SchedulePayInterface schedulePayment() {

        SchedulePayInterface schedulePayInterface =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL_MAP)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(SchedulePayInterface.class);
        return schedulePayInterface;
    }
}
