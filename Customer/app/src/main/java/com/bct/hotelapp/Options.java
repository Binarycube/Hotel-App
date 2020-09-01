package com.bct.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {
    private Button orderMenu;
    private Button viewBill;
    private Button callWaiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        orderMenu = (Button) findViewById(R.id.orderMenu);
        viewBill = (Button) findViewById(R.id.viewBill);
        callWaiter = (Button) findViewById(R.id.callWaiter);

        orderMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, OrderMenu.class);
                startActivity(intent);
            }
        });

        viewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, OrderMenu.class);
                startActivity(intent);
            }
        });

        callWaiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, OrderMenu.class);
                startActivity(intent);
            }
        });

    }
}