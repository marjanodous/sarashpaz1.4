package com.example.sarashpaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarashpaz.adapter.AdapterGroupFoods;
import com.example.sarashpaz.model.FoodGroups;
import com.example.sarashpaz.model.Foods;

import java.util.ArrayList;

public class ActivityGroupFoods extends AppCompatActivity {
    private ImageView imgBackDastebandi;
    TextView txtTitle;
    GridView gridView;
    private ArrayList<Foods> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /* Get object from xml file*/
        txtTitle = findViewById(R.id.txttitledastehbandi);
        imgBackDastebandi = findViewById(R.id.img_backdastehbandi);
        gridView= findViewById(R.id.grid_menu);


        /*back to dastebandi*/
        imgBackDastebandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*set adapter to gridview */
        AdapterGroupFoods adapter = new AdapterGroupFoods(ActivityGroupFoods.this, R.layout.item_menu, foods);
        setFoodGroop();
        gridView.setAdapter(adapter);
    }
    /*method set item list grid*/
    public void setFoodGroop() {
        foods.add(new Foods("سوپ", R.drawable.myan1));
        foods.add(new Foods("غذای مدرن", R.drawable.myan2));
        foods.add(new Foods("سنتی", R.drawable.myan3));
        foods.add(new Foods("تزئینات", R.drawable.myan4));
        foods.add(new Foods("دانشجویی", R.drawable.myan5));
        foods.add(new Foods("رژیمی", R.drawable.myan6));
        foods.add(new Foods("نوشیدنی", R.drawable.myan6));
        foods.add(new Foods("ترشی و شور", R.drawable.myan6));
        foods.add(new Foods("دسر", R.drawable.myan6));
        foods.add(new Foods("غذای محلی", R.drawable.myan6));
        foods.add(new Foods("سالاد", R.drawable.myan6));
        foods.add(new Foods("کیک و شیرینی", R.drawable.myan6));
        foods.add(new Foods("تنقلات", R.drawable.myan6));
        foods.add(new Foods("غذای کودک", R.drawable.myan6));
    }
}
