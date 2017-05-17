package com.example.jsonstatham.luzikarbuzik;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Post {

    @Headers( "Content-Type: application/json" )
    @POST("mule/login")
    Call<String> login(@Body String jsonLoginDetails);

    @Headers( "Content-Type: application/json" )
    @POST("mule/login")
    Call<String> sendOrder(@Body String jsonOrderDetails);

}
