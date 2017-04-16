package com.example.home.mcheque.payeeList;

import com.example.home.mcheque.utility.RetrofitClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mayu on 14-04-2017.
 */

public class PayeeListWebService {
    public static final String BASE_URL = "https://retailbanking.mybluemix.net/banking/";
    //?client_id=mayuriardad@gmail.com&token=f013e6f28854&custid=33337213"
    public static PayeeListInterface getPayeeListService(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(PayeeListInterface.class);
    }
}
