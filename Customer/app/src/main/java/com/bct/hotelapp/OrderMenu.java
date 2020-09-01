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
    private HashMap<String,List<BillModel>> listHashMap;
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

        List<BillModel> breakfast = new ArrayList<>();
        breakfast.add(new BillModel(0,"Idly", 10.00, 0));
        breakfast.add(new BillModel(0,"Dosai", 30.00, 0));
        breakfast.add(new BillModel(0,"Pongal", 30.00, 0));
        breakfast.add(new BillModel(0,"Poori", 20.00, 0));

        List<BillModel> starter = new ArrayList<>();
        starter.add(new BillModel(0,"Chilli Chicken", 120.00, 0));
        starter.add(new BillModel(0,"Chicken 65", 120.00, 0));
        starter.add(new BillModel(0,"Mutton Pepper Fry", 180.00, 0));
        starter.add(new BillModel(0,"Mutton Keema Balls", 190.00, 0));

        List<BillModel> course = new ArrayList<>();
        course.add(new BillModel(0,"Chicken Masala", 120.00, 0));
        course.add(new BillModel(0,"Butter Masala", 130.00, 0));
        course.add(new BillModel(0,"Garlic Masala", 130.00, 0));
        course.add(new BillModel(0,"Mutton Masala", 210.00, 0));

        List<BillModel> biriyani = new ArrayList<>();
        biriyani.add(new BillModel(0,"Plain Biriyani", 120.00, 0));
        biriyani.add(new BillModel(0,"Egg Biriyani", 130.00, 0));
        biriyani.add(new BillModel(0,"Chicken Biriyani", 150.00, 0));
        biriyani.add(new BillModel(0,"Mutton Biriyani", 200.00, 0));

        listHashMap.put(listDataHeader.get(0),breakfast);
        listHashMap.put(listDataHeader.get(1),starter);
        listHashMap.put(listDataHeader.get(2),course);
        listHashMap.put(listDataHeader.get(3),biriyani);

    }
}