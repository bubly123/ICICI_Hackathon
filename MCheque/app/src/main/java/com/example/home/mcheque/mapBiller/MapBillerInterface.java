package com.example.home.mcheque.mapBiller;

import com.example.home.mcheque.participantDataMapping.Accounts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by home on 10/04/17.
 */

public interface MapBillerInterface {
    //https://biller.mybluemix.net/biller/icicibank/addbiller?client_id=mayuriardad@gmail.com&token=
    // ace6de86db04&billerdetail=Tata Power&state=gujarat&custid=33337213&nickname=A2214&consumerno=79202021112
    @GET
    Call<ResponseBody> getParticpantMappingData(@Url String url,
                                                @Query("client_id") String clientId,
                                                @Query("token") String token,
                                                @Query("billerdetail") String billerDetail,
                                                @Query("state") String state,
                                                @Query("custid") String custId,
                                                @Query("nickname") String nickName,
                                                @Query("consumerno") String consumerNo);
}
