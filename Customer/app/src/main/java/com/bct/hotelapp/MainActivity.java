package com.bct.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button signIn;
    private EditText username;
    private EditText password;
    public static final String EXTRA_MESSAGE = "com.bct.Hotel-App.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        signIn = (Button)findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.equals("test") && password.equals("test")){
                    Intent intent = new Intent(MainActivity.this, OrderMenu.class);
                    String message = username.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);
                }
            }
        });

    }
}