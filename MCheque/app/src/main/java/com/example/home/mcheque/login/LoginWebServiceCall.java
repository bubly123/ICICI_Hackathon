package com.example.home.mcheque.login;

import com.example.home.mcheque.utility.RetrofitClient;

public class LoginWebServiceCall {
    private LoginWebServiceCall() {}

    public static final String BASE_URL = "https://corporateapiprojectwar.mybluemix.net/corporate_banking/";
//https://corporateapiprojectwar.mybluemix.net/corporate_banking/mybank/authenticate_client

    public static UserAuthenticationInterface getUserAuthenticationService() {
        return RetrofitClient.getClient(BASE_URL).create(UserAuthenticationInterface.class);
    }
}
