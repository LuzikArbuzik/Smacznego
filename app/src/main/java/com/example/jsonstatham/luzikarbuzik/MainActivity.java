package com.example.jsonstatham.luzikarbuzik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void loginRestaurant(View button) {
      Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("127.0.0.1:8081")
               .build();
       Intent newScreen = new Intent(this, Order.class);
       startActivity(newScreen);
   }

}
