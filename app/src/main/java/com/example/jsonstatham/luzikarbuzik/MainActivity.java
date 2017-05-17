package com.example.jsonstatham.luzikarbuzik;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void loginRestaurant(View button) {
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl("http://127.0.0.1:8081/")
              .addConverterFactory(ScalarsConverterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build();
       Post post = retrofit.create(Post.class);
       Map<String, String> jsonParams = new ArrayMap<>();
       jsonParams.put("login", "1312");
       jsonParams.put("password", "Haslomaslo");
       Call<String> response = post.login(new JSONObject(jsonParams).toString());

       response.enqueue(new Callback<String>()
       {
           @Override
           public void onResponse(Call<String> call, retrofit2.Response<String> rawResponse)
           {
               try
               {
                   Toast.makeText(getApplicationContext(), "Wysłano", Toast.LENGTH_LONG).show();
               }
               catch (Exception e)
               {
                   Toast.makeText(getApplicationContext(), "Wystąpił problem z odpowiedzią", Toast.LENGTH_LONG).show();               }
           }

           @Override
           public void onFailure(Call<String> call, Throwable throwable)
           {
               Toast.makeText(getApplicationContext(), "Nie wysłano", Toast.LENGTH_LONG).show();
           }
       });
       /*Intent newScreen = new Intent(this, Order.class);
       startActivity(newScreen);*/
   }

}
