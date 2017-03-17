package com.facer.client.models;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by perumaa on 3/17/2017.
 */

public class ApplicationAdapter extends BaseAdapter {

    private ArrayList<Application> appList;
    private Context appContext;

    public ApplicationAdapter(Context c,ArrayList<Application> al) {
        appContext = c;
        appList = al;
    }

    public int getCount() {
       return appList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Button button = new Button(appContext);
        button.setLayoutParams(new GridView.LayoutParams(400, 150));
        button.setPadding(0, 0, 0, 2);
        button.setText(appList.get(position).getApplication());
        if(appList.get(position).getStatus().equalsIgnoreCase("green")){
            button.setBackgroundColor(Color.rgb(11,129,0));
        } else if(appList.get(position).getStatus().equalsIgnoreCase("yellow")){
            button.setBackgroundColor(Color.rgb(255,191,0));
        } else if(appList.get(position).getStatus().equalsIgnoreCase("red")){
            button.setBackgroundColor(Color.rgb(154,0,0));
        }
        return button;
    }
}
