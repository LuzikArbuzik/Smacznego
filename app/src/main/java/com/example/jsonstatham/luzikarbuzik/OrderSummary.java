package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.apply();
        JSONObject root = new JSONObject();
        try {
            JSONObject client = new JSONObject();
            client.put("first_name", "Jan");
            client.put("last_name", "Kowalski");
            client.put("phone_number", "+48 123123123");
            JSONObject address = new JSONObject();
            address.put("city", "Wroclaw");
            address.put("street", "Grunwaldzka");
            address.put("address_num", "12");
            address.put("door_num", "1");
            root.put("address", address);
            JSONArray ordersArray = new JSONArray();
            Set<String> orders = sharedPref.getStringSet("orders", new HashSet<String>());
            for(String order: orders) {
                OrderItem currentItem = OrderItem.decode(order);
                JSONObject orderJson = new JSONObject();
                orderJson.put("name", currentItem.getName());
                orderJson.put("quantity", currentItem.getQuantity());
                ordersArray.put(orderJson);
            }
            root.put("dishes", ordersArray);
            JSONObject restaurant = new JSONObject();
            restaurant.put("name", "Pizza Station");
            JSONObject restaurantAddress = new JSONObject();
            restaurantAddress.put("city", "Wroclaw");
            restaurantAddress.put("street", "Grabiszyńska");
            restaurantAddress.put("address_num", "55");
            restaurantAddress.put("door_num", "2");
            restaurant.put("address", restaurantAddress);
            root.put("restaurant", restaurant);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<String> response = post.sendOrder(root.toString());

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
