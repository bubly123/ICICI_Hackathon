package com.example.home.mcheque.accountSummary;

import com.example.home.mcheque.participantDataMapping.Accounts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by roman on 18/4/17.
 */

public interface AccountSummaryInterface {
    @GET
//    https://retailbanking.mybluemix.net/banking/icicibank/balanceenquiry?client_id=mayuriardad@gmail.com&token=861b78709e94&accountno=4444777755552213

    Call<List<AccountSummary>> getAccountSummary(@Url String url,
                                           @Query("client_id") String clientId,
                                           @Query("token") String token,
                                           @Query("accountno") String accountNo);
}
