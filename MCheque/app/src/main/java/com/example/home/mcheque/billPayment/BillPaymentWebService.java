package com.example.home.mcheque.billPayment;

import com.example.home.mcheque.mapBiller.MapBillerInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by home on 10/04/17.
 */

public class BillPaymentWebService {
    private BillPaymentWebService() {}

    public static final String BASE_URL_MAP = "https://biller.mybluemix.net/biller/icicibank/";

//    https://biller.mybluemix.net/biller/icicibank/billpay?client_id=mayuriardad@gmail.com&token=2f1f6e397244&custid=33337213&nickname=A2214&amount=10


    public static BillPaymentInterface makeBillPayment() {

        BillPaymentInterface billPaymentInterface =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL_MAP)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(BillPaymentInterface.class);
        return billPaymentInterface;
    }
}
