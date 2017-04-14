package com.example.home.mcheque.payeeList;

import com.example.home.mcheque.utility.RetrofitClient;

/**
 * Created by Mayu on 14-04-2017.
 */

public class PayeeListWebService {
    public static final String BASE_URL = "https://retailbanking.mybluemix.net/banking/";
    //?client_id=mayuriardad@gmail.com&token=f013e6f28854&custid=33337213"
    public static PayeeListInterface getPayeeListService(){
        //https://retailbanking.mybluemix.net/banking/icicibank/listpayee?client_id=mayuriardad@gmail.com&token=f013e6f28854&custid=33337213
        return RetrofitClient.getClient(BASE_URL).create(PayeeListInterface.class);
    }

}
