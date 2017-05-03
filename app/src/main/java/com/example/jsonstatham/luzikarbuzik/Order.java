package com.example.jsonstatham.luzikarbuzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        final String[] food = new String[]{"Pizza Florentina", "Pizza Fiume", "Pizza Maffioso", "Pizza Frutti Di Mare",
                "Pizza Marco Polo", "Pizza Giuseppe", "Pizza Uczta Sołtysa", "Pizza Jordano", "Pizza Vegetariana",
                "Pizza Cosa Nostra"};
        FoodItemAdapter foodAdapter = new FoodItemAdapter(this, food);
        ListView list = (ListView)findViewById(R.id.food_list);
        list.setAdapter(foodAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newScreen = new Intent(getApplication(), OrderDetails.class);
                newScreen.putExtra("foodName", food[position]);
                startActivity(newScreen);
            }
        });
    }

}
