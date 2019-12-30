package com.example.sarashpaz.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.sarashpaz.R;
import com.example.sarashpaz.Tozihat;
import com.example.sarashpaz.model.FoodGroups;
import com.example.sarashpaz.model.Foods;

import java.util.ArrayList;
import java.util.List;

public class AdapterGrid extends ArrayAdapter {

    public int resourceId;
    public Activity activity;
    public ArrayList<FoodGroups> data;

    public AdapterGrid(Activity activity, int resourceId, ArrayList<FoodGroups> object) {
        super(activity, resourceId, object);
        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            grid = inflater.inflate(R.layout.item_menu, null);
            TextView textView = grid.findViewById(R.id.txt_itemmenu);
            ImageView imageView = grid.findViewById(R.id.img_itemmenu);
            FoodGroups groups = new FoodGroups();
            groups = data.get(position);
            textView.setText(groups.getTitle());
            imageView.setImageResource(groups.getImage());
            grid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent  = new Intent(activity, Tozihat.class);
                    activity.startActivity(intent);
                }
            });
        }
        else {
            grid = view;
        }
        return grid;
    }
}
