package com.bct.hotelapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.HashMap;
import java.util.List;

public class MenuListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<BillModel>> listHashMap;
    //private Button add;
    //private Button sub;
    //private EditText quantity;
    private int curr_qty;

    public MenuListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<BillModel>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group,null);
        }
        TextView listheader = (TextView) convertView.findViewById(R.id.listheader);
        listheader.setTypeface(null, Typeface.BOLD);
        listheader.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final BillModel itemModel = (BillModel) getChild(groupPosition,childPosition);
        final String childText = itemModel.getItemName()+" (Rs."+String.valueOf(itemModel.getPrice())+")";
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item,null);
        }
        TextView listchild = (TextView) convertView.findViewById(R.id.listitem);
        listchild.setText(childText);
        final Button add = (Button) convertView.findViewById(R.id.addBtn);
        final Button sub = (Button) convertView.findViewById(R.id.subBtn);
        final TextView quantity = (TextView) convertView.findViewById(R.id.quantity);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_qty = itemModel.getQuantity();
                if (curr_qty >= 0) {
                    itemModel.setQuantity(itemModel.getQuantity()+1);
                    quantity.setText(String.valueOf(itemModel.getQuantity()));
                    //Toast.makeText(context.getApplicationContext(), "Item Added :" + childText + String.valueOf(curr_qty + 1) , Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_qty = itemModel.getQuantity();
                if (curr_qty > 0) {
                    itemModel.setQuantity(itemModel.getQuantity()-1);
                    quantity.setText(String.valueOf(itemModel.getQuantity()));
                    //Toast.makeText(context.getApplicationContext(), "Item Removed :" + childText + String.valueOf(curr_qty + 1) , Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
