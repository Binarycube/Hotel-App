package com.bct.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderMenu extends AppCompatActivity {
    private ExpandableListView foodmenu;
    private MenuListAdapter listAdapater;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menu);

        foodmenu = (ExpandableListView) findViewById(R.id.foodmenu);
        initData();
        listAdapater = new MenuListAdapter(this,listDataHeader,listHashMap);
        foodmenu.setAdapter(listAdapater);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        listDataHeader.add("Breakfast");
        listDataHeader.add("Starter");
        listDataHeader.add("Main Course");
        listDataHeader.add("Biriyani");

        List<String> breakfast = new ArrayList<>();
        breakfast.add("Idly (Rs.10)");
        breakfast.add("Dosai (Rs.30)");
        breakfast.add("Pongal (Rs.30)");
        breakfast.add("Poori (Rs.20)");

        List<String> starter = new ArrayList<>();
        starter.add("Chilli Chicken (Rs.120)");
        starter.add("Chicken 65 (Rs.120)");
        starter.add("Mutton Pepper Fry (Rs.180)");
        starter.add("Mutton Keema Balls (Rs.190)");

        List<String> course = new ArrayList<>();
        course.add("Chicken Masala (Rs.120)");
        course.add("Butter Chicken (Rs.130)");
        course.add("Garlic Chicken (Rs.130)");
        course.add("Mutton Masala (Rs.210)");

        List<String> biriyani = new ArrayList<>();
        biriyani.add("Plain Biriyani (Rs.120)");
        biriyani.add("Egg Biriyani (Rs.130)");
        biriyani.add("Chicken Biriyani (Rs.150)");
        biriyani.add("Mutton Biriyani (Rs.200)");

        listHashMap.put(listDataHeader.get(0),breakfast);
        listHashMap.put(listDataHeader.get(1),starter);
        listHashMap.put(listDataHeader.get(2),course);
        listHashMap.put(listDataHeader.get(3),biriyani);

    }
}