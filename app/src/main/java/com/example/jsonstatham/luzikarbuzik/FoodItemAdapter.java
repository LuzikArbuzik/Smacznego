package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FoodItemAdapter extends ArrayAdapter {

    private String[] foods;

    public FoodItemAdapter(@NonNull Context context, String[] foods) {
        super(context, 0);
        this.foods = foods;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String foodName = foods[position];
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food, parent, false);
        }
        TextView foodText = (TextView) convertView.findViewById(R.id.food_text);
        foodText.setText(foodName);
        return convertView;
    }

}
