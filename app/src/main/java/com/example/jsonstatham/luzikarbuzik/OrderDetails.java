package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class OrderDetails extends AppCompatActivity {

    private TextView foodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        Intent input = getIntent();
        foodName = (TextView)findViewById(R.id.food_name);
        foodName.setText(input.getStringExtra("foodName"));
    }

    public void showSummary(View button) {
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Set<String> orders = sharedPref.getStringSet("orders", new HashSet<String>());
        EditText editAmmount = (EditText)findViewById(R.id.editAmmount);
        int foodAmmount = Integer.parseInt(editAmmount.getText().toString());
        if(foodAmmount > 0) {
            EditText editKind = (EditText)findViewById(R.id.editKind);
            orders.add(foodAmmount + " x " + editKind.getText().toString() + " " + foodName.getText().toString());
            editor.putStringSet("orders", orders);
            editor.apply();
        }
        Intent newScreen = new Intent(this, OrderSummary.class);
        startActivity(newScreen);
    }

}
