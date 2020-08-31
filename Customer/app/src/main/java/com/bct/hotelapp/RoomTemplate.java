package com.bct.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RoomTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomtemp);
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {
            String value = bundle.getString("value");
            TextView textView = findViewById(R.id.text_view);
            textView.setText(value);
        }
    }
}