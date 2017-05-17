package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class OrderSummary extends AppCompatActivity {

    private TextView orderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary);
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        orderTextView = (TextView)findViewById(R.id.order);
        Set<String> orderSet = sharedPref.getStringSet("orders", new HashSet<String>());
        String orderText = "";
        for (String order: orderSet) {
            orderText += order + "\n";
        }
        orderTextView.setText(orderText);
    }

    public void send(View button) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8081/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Post post = retrofit.create(Post.class);
        Map<String, String> jsonParams = new ArrayMap<>();
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.apply();
        JSONObject root = new JSONObject();
        try {
            JSONArray orders = new JSONArray("orders");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Set<String> orders = sharedPref.getStringSet("orders", new HashSet<String>());
       /* jsonParams.put("login", login.getText().toString());
        jsonParams.put("password", password.getText().toString());*/
        Call<String> response = post.login(new JSONObject(jsonParams).toString());

        response.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> rawResponse) {
                try {
                    Toast.makeText(getApplicationContext(), "Wysłano", Toast.LENGTH_LONG).show();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Wystąpił problem z odpowiedzią", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Nie wysłano", Toast.LENGTH_LONG).show();
            }

        });
    }

}
