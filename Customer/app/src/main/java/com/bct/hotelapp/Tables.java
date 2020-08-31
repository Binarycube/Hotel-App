package com.bct.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Tables extends AppCompatActivity {
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private String[] rooms;
    private  ArrayList<String> roomlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        mainListView = (ListView) findViewById( R.id.mainListView );
        initData();
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, roomlist);

        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=roomlist.get(position);
                Toast.makeText(Tables.this, name+"", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("value",name);
                Intent intent = new Intent(Tables.this, RoomTemplate.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        rooms = new String[] { "Room 1", "Room 2", "Room 3", "Room 4","Room 5"};
        roomlist = new ArrayList<String>();
        roomlist.addAll( Arrays.asList(rooms) );

    }
}