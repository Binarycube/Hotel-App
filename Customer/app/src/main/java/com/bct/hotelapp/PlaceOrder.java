package com.bct.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

public class PlaceOrder extends AppCompatActivity {
    private Button cancelBtn;
    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        confirmBtn = (Button) findViewById(R.id.confirmBtn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaceOrder.this, OrderMenu.class);
                startActivity(intent);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaceOrder.this, Options.class);
                //intent.putExtra(EXTRA_MESSAGE, listAdapater);
                startActivity(intent);
            }
        });
    }
}