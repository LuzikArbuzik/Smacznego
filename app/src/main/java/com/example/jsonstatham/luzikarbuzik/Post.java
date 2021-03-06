package com.example.jsonstatham.luzikarbuzik;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Post {

    @Headers( "Content-Type: application/json" )
    @POST("mule/orders/")
    Call<String> sendOrder(@Body String jsonOrderDetails);

}
