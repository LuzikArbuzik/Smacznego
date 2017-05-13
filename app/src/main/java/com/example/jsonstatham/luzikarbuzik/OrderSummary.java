package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class OrderSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary);
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        TextView orderTextView = (TextView)findViewById(R.id.order);
        Set<String> orderSet = sharedPref.getStringSet("orders", new HashSet<String>());
        String orderText = "";
        for (String order: orderSet) {
            orderText += order + "\n";
        }
        orderTextView.setText(orderText);
    }

}
