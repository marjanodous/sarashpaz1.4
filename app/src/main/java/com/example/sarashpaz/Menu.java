package com.example.sarashpaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarashpaz.adapter.AdapterGrid;
import com.example.sarashpaz.model.FoodGroups;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Menu extends AppCompatActivity {

    private ImageView imgBackDastebandi;
    public static String titleMenu;
    TextView txtTitle;
    GridView gridView;
    private ArrayList<FoodGroups> foodGroups = new ArrayList<>();
    private ArrayList<FoodGroups> sonati = new ArrayList<>();
    private ArrayList<FoodGroups> modern = new ArrayList<>();
    private ArrayList<FoodGroups> soap = new ArrayList<>();
    private ArrayList<FoodGroups> rejimi = new ArrayList<>();
    private ArrayList<FoodGroups> daneshjuee = new ArrayList<>();
    private ArrayList<FoodGroups> tanaqolat = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /* Get object from xml file*/
        txtTitle = findViewById(R.id.txttitledastehbandi);
        txtTitle.setText(titleMenu);
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
        AdapterGrid adapter = new AdapterGrid(Menu.this, R.layout.item_menu, foodGroups);
        setFoodGroop();
        gridView.setAdapter(adapter);

    }
    /*method set item list grid*/
    public void setFoodGroop() {
        foodGroups.add(new FoodGroups("سوپ", R.drawable.myan1));
        foodGroups.add(new FoodGroups("غذای مدرن", R.drawable.myan2));
        foodGroups.add(new FoodGroups("سنتی", R.drawable.myan3));
        foodGroups.add(new FoodGroups("تزئینات", R.drawable.myan4));
        foodGroups.add(new FoodGroups("دانشجویی", R.drawable.myan5));
        foodGroups.add(new FoodGroups("رژیمی", R.drawable.myan6));
        foodGroups.add(new FoodGroups("نوشیدنی", R.drawable.myan6));
        foodGroups.add(new FoodGroups("ترشی و شور", R.drawable.myan6));
        foodGroups.add(new FoodGroups("دسر", R.drawable.myan6));
        foodGroups.add(new FoodGroups("غذای محلی", R.drawable.myan6));
        foodGroups.add(new FoodGroups("سالاد", R.drawable.myan6));
        foodGroups.add(new FoodGroups("کیک و شیرینی", R.drawable.myan6));
        foodGroups.add(new FoodGroups("تنقلات", R.drawable.myan6));
        foodGroups.add(new FoodGroups("غذای کودک", R.drawable.myan6));
    }
    //for sonati
    public void setSonati(){
        foodGroups.add(new FoodGroups("کباب کوبیده", R.drawable.kabab));
        foodGroups.add(new FoodGroups("قیمه", R.drawable.qeime));
        foodGroups.add(new FoodGroups("قرمه سبزی", R.drawable.img6));
        foodGroups.add(new FoodGroups("چلو مرغ", R.drawable.img2));
        foodGroups.add(new FoodGroups("مرصع پلو", R.drawable.img5));
        foodGroups.add(new FoodGroups("قیمه نثار", R.drawable.nesar1));
    }
    //for modern
    public void setModern(){
        foodGroups.add(new FoodGroups("هات داگ", R.drawable.img3));
        foodGroups.add(new FoodGroups("پیتزا", R.drawable.pitzza1));
        foodGroups.add(new FoodGroups(" کیچن استراگانوف", R.drawable.kitchen));
        foodGroups.add(new FoodGroups("همبرگر", R.drawable.hamberger1));
        foodGroups.add(new FoodGroups("مرغ سوخاری", R.drawable.sokhari));
        foodGroups.add(new FoodGroups(" میگو سوخاری", R.drawable.meigusokhari1));
    }
    //for soap
    public void setSoap(){
        foodGroups.add(new FoodGroups("هات داگ", R.drawable.img3));
        foodGroups.add(new FoodGroups("پیتزا", R.drawable.pitzza1));
        foodGroups.add(new FoodGroups(" کیچن استراگانوف", R.drawable.kitchen));
        foodGroups.add(new FoodGroups("همبرگر", R.drawable.hamberger1));
        foodGroups.add(new FoodGroups("مرغ سوخاری", R.drawable.sokhari));
        foodGroups.add(new FoodGroups(" میگو سوخاری", R.drawable.meigusokhari1));
    }

    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
