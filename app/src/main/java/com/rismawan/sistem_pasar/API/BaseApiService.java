package com.rismawan.sistem_pasar.API;

import android.content.SharedPreferences;

import com.rismawan.sistem_pasar.DataModel.LoginRespone;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static android.app.PendingIntent.getActivity;

public interface BaseApiService {


    @FormUrlEncoded
    @POST("login")
    Call<LoginRespone> login(@Field("username") String username,
                             @Field("password") String password);

    @Headers(
            "Accept: application/json"
    )
    @GET("logout")
    Call<LoginRespone> logout(@Header("Authorization") String token);

}
