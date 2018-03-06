package com.daewichan.apitest.data.remote;

import retrofit2.Retrofit;

/**
 * Created by daewichan on 3/2/18.
 */

public class AppUtility {
    public static final String BASE_URL="https://api.stackexchange.com/2.2/";
    public static ApiService getService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
