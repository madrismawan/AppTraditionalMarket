package com.rismawan.sistem_pasar.API;

public class APIConnection {
    public static final String BASE_URL = "http://192.168.1.69/sistem_pasar/public/api/";

    public static BaseApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(BaseApiService.class);
    }

}
