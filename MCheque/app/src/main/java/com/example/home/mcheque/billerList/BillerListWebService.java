package com.example.home.mcheque.billerList;

import com.example.home.mcheque.payeeList.PayeeListInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mayu on 16-04-2017.
 */

public class BillerListWebService {
    public static final String BASE_URL = "https://biller.mybluemix.net/biller/";
    //https://biller.mybluemix.net/biller/icicibank/billerdetail?client_id=mayuriardad@gmail.com&token=f013e6f28854&billername=electricity
    //?client_id=mayuriardad@gmail.com&token=f013e6f28854&custid=33337213"
    public static BillerListInterface getBillerListService(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(BillerListInterface.class);
    }
}
