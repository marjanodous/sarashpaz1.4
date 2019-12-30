package com.example.sarashpaz.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarashpaz.R;
import com.example.sarashpaz.Tozihat;
import com.example.sarashpaz.model.Foods;
import com.example.sarashpaz.model.LikedFoods;

import java.util.ArrayList;

public class AdapterGroupFoods extends ArrayAdapter {

    public int resourceId;
    public Activity activity;
    public ArrayList<Foods> data;
    public static boolean flag_group=false;

    public AdapterGroupFoods(Activity activity, int resourceId, ArrayList<Foods> object) {
        super(activity, resourceId, object);
        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            grid = inflater.inflate(R.layout.item_menu, null);
            TextView textView = grid.findViewById(R.id.txt_itemmenu);
            ImageView imageView = grid.findViewById(R.id.img_itemmenu);
            Foods foods = new Foods();
            foods = data.get(position);
            textView.setText(foods.getName());
            imageView.setImageResource(foods.getImage());
            grid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    flag_group=true;
                    Intent intent  = new Intent(activity, Tozihat.class);
                    intent.putExtra("title_group",data.get(position).getName());
                    intent.putExtra("image_group",data.get(position).getImage());
                    activity.startActivity(intent);
                }
            });
        } else {
            grid = view;
        }
        return grid;
    }
}
