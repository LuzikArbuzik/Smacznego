package com.example.jsonstatham.luzikarbuzik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void loginRestaurant(View button) {
       EditText login = (EditText)findViewById(R.id.login_text);
       EditText password = (EditText)findViewById(R.id.password_text);
       String loginText = login.getText().toString();
       if(loginText.equals("mc") && password.getText().toString().equals("12")) {
           SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),
                   Context.MODE_PRIVATE);
           SharedPreferences.Editor editor = sharedPref.edit();
           editor.putString("login", loginText);
           editor.apply();
           Intent newScreen = new Intent(this, Order.class);
           startActivity(newScreen);
       }
       else {
           Toast.makeText(getApplicationContext(), "Nieprawidłowy login lub hasło", Toast.LENGTH_LONG).show();
       }
   }

}
