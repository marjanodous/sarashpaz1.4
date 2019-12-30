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
import com.example.sarashpaz.model.FoodGroups;
import com.example.sarashpaz.model.LikedFoods;

import java.util.ArrayList;

public class AdapterLiked extends ArrayAdapter {

    public int resourceId;
    public Activity activity;
    public ArrayList<LikedFoods> data;
    public static boolean flag_Liked=false;

    public AdapterLiked(Activity activity, int resourceId, ArrayList<LikedFoods> object) {
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
            LikedFoods likedFoods = new LikedFoods();
            likedFoods = data.get(position);
            textView.setText(likedFoods.getTitle());
            imageView.setImageResource(likedFoods.getImage());
            grid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    flag_Liked=true;
                    Intent intent  = new Intent(activity, Tozihat.class);
                    intent.putExtra("title_liked",data.get(position).getTitle());
                    intent.putExtra("image_liked",data.get(position).getImage());
                    activity.startActivity(intent);
                }
            });
        } else {
            grid = view;
        }
        return grid;
    }
}