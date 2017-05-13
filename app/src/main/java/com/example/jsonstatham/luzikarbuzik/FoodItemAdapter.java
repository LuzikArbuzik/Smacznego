package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class FoodItemAdapter extends ArrayAdapter<String> {

    FoodItemAdapter(Context context, String[] foods) {
        super(context, 0, foods);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        String foodName = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food, parent, false);
        }
        TextView foodText = (TextView) convertView.findViewById(R.id.food_text);
        foodText.setText(foodName);
        return convertView;
    }

}
