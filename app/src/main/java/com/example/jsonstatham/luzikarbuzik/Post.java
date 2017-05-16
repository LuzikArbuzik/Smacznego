package com.example.jsonstatham.luzikarbuzik;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface Post {

    @POST("/mule/login")
    Call<ResponseBody> login(@Body RequestBody params);

}
