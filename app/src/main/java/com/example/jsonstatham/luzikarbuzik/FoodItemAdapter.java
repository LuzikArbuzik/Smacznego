package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FoodItemAdapter extends ArrayAdapter<String> {

    public FoodItemAdapter(Context context, String[] foods) {
        super(context, 0, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String foodName = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food, parent, false);
        }
        TextView foodText = (TextView) convertView.findViewById(R.id.food_text);
        foodText.setText(foodName);
        return convertView;

    }

}
