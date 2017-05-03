package com.example.jsonstatham.luzikarbuzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        Intent input = getIntent();
        TextView foodName = (TextView)findViewById(R.id.food_name);
        foodName.setText(input.getStringExtra("foodName"));
    }

}
