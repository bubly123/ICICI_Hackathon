package com.example.home.mcheque.participantDataMapping;


import com.example.home.mcheque.login.UserAuthenticationInterface;
import com.example.home.mcheque.utility.RetrofitClient;
import com.example.home.mcheque.utility.RetrofitClientParticipant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParticipantDataMappingWebService {
    private ParticipantDataMappingWebService() {}

    public static final String BASE_URL_MAP = "https://retailbanking.mybluemix.net/banking/";
//https://retailbanking.mybluemix.net/banking/icicibank/participantmapping?client_id=mayuriardad@gmail.com

    public static ParticipantDataMappingInterface getParticipantDataMapped() {

        ParticipantDataMappingInterface participantDataMappingInterface =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL_MAP)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(ParticipantDataMappingInterface.class);
                //RetrofitClient.getClient(BASE_URL_MAP).create(ParticipantDataMappingInterface.class);
//    participantDataMappingInterface.getParticpantMappingData("https://re
// tailbanking.mybluemix.net/banking/icicibank/participantmapping",
//            "mayuriardad@gmail.com");
        return participantDataMappingInterface;
    }
}
