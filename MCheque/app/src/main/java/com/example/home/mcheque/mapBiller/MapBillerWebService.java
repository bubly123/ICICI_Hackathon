package com.example.home.mcheque.mapBiller;

import com.example.home.mcheque.participantDataMapping.ParticipantDataMappingInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by home on 10/04/17.
 */

public class MapBillerWebService {
    private MapBillerWebService() {}

    public static final String BASE_URL_MAP = "https://biller.mybluemix.net/biller/icicibank/";

    //https://biller.mybluemix.net/biller/icicibank/addbiller?client_id=mayuriardad@gmail.com&
    // token=ace6de86db04&billerdetail=Tata Power&state=gujarat&custid=33337213&nickname=A2214&consumerno=79202021112

    public static MapBillerInterface mapBiller() {

        MapBillerInterface mapBillerInterface =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL_MAP)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(MapBillerInterface.class);
        return mapBillerInterface;
    }
}
