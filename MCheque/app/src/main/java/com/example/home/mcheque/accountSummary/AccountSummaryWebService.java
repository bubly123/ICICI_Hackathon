package com.example.home.mcheque.accountSummary;

import com.example.home.mcheque.participantDataMapping.ParticipantDataMappingInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by roman on 18/4/17.
 */

public class AccountSummaryWebService {
    private AccountSummaryWebService() {}

    public static final String BASE_URL_MAP = "https://retailbanking.mybluemix.net/banking/";

    public static AccountSummaryInterface getAccountSummaryCall() {

        AccountSummaryInterface accountSummaryInterface =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL_MAP)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(AccountSummaryInterface.class);
        return accountSummaryInterface;
    }
}
