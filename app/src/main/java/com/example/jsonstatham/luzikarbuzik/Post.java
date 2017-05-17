package com.example.jsonstatham.luzikarbuzik;

import org.json.JSONObject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Post {

    @Headers( "Content-Type: application/json" )
    @POST("/mule/login")
    Call<String> login(@Body String json);

}
