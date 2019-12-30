package com.example.sarashpaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarashpaz.adapter.AdapterGroupFoods;
import com.example.sarashpaz.adapter.AdapterLiked;
import com.example.sarashpaz.adapter.AdapterSearch;
import com.example.sarashpaz.adapter.ItemAdapter_recycler_behtarin_dastoor_pokht_ha;
import com.example.sarashpaz.adapter.ItemAdapter_recycler_img;
import com.example.sarashpaz.adapter.ItemAdapter_recycler_myanvade;

public class Tozihat extends AppCompatActivity {

    private TextView titleTozihat;
    ImageView imgTozihat, imgLike;
    public boolean flagLike = false;
//    ArrayList<Foods> foodsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_tozihat);

        titleTozihat = findViewById(R.id.title_tozihat);
        imgTozihat = findViewById(R.id.img_tozihat);
        imgLike = findViewById(R.id.img_like);


//        getAllSharedPreferences(titleTozihat.getText().toString().trim());

        //////load from recycler_myanvade
        if (ItemAdapter_recycler_myanvade.flag_myanvade == true) {
            /////set title tozihat
            Bundle bundle = getIntent().getExtras();
            titleTozihat.setText(bundle.getString("title_myanvade"));
            ///////setimage tozihat
            Bundle bundle1 = getIntent().getExtras();
            Bundle bd = getIntent().getExtras();
            imgTozihat.setImageResource(bd.getInt("image_myanvade"));
        }
        //////load from behtarin_dastoor_pokht_ha
        if (ItemAdapter_recycler_behtarin_dastoor_pokht_ha.flag_behtarin_dastoor_pokht_ha == true) {
            /////set title tozihat
            Bundle bundle = getIntent().getExtras();
            titleTozihat.setText(bundle.getString("title_bdph"));
            ///////setimage tozihat
            Bundle bundle1 = getIntent().getExtras();
            Bundle bd = getIntent().getExtras();
            imgTozihat.setImageResource(bd.getInt("image_bdph"));
        }

        //////load from AdapterSearch
        if (AdapterSearch.flag_serch == true) {
            /////set title tozihat
            Bundle bundle = getIntent().getExtras();
            titleTozihat.setText(bundle.getString("title_search"));
            ///////setimage tozihat
//            Bundle bundle1 = getIntent().getExtras();
//            Bundle bd = getIntent().getExtras();
//            imgTozihat.setImageResource(bd.getInt("title_search"));
        }
        //////load from ActivityLiked
        if (AdapterLiked.flag_Liked == true) {
            /////set title tozihat
            Bundle bundle = getIntent().getExtras();
            titleTozihat.setText(bundle.getString("title_liked"));
            ///////setimage tozihat
            Bundle bundle1 = getIntent().getExtras();
            Bundle bd = getIntent().getExtras();
            imgTozihat.setImageResource(bd.getInt("image_liked"));
        }
        //////load from Activitygroup
        if (AdapterGroupFoods.flag_group == true) {
            /////set title tozihat
            Bundle bundle = getIntent().getExtras();
            titleTozihat.setText(bundle.getString("title_group"));
            ///////setimage tozihat
            Bundle bundle1 = getIntent().getExtras();
            Bundle bd = getIntent().getExtras();
            imgTozihat.setImageResource(bd.getInt("image_group"));
        }

         /*calling method liked or disliked food*/
        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagLike == false) {
                    imgLike.setColorFilter(getApplication().getResources().getColor(R.color.colorPrimaryDark));
                    flagLike = true;
                    foodsLiked(titleTozihat.getText().toString().trim());
                } else {
                    imgLike.setColorFilter(getApplication().getResources().getColor(R.color.colorPrimaryLight));
                    flagLike = false;
                    foodsDisLiked(titleTozihat.getText().toString().trim());
                }
            }
        });
    }
    /*methid to liked food*/
    public void foodsLiked(String namefood) {
        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("likedfood", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString(namefood, namefood);
        edit.apply();
        //////////
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("likedfood", MODE_PRIVATE);
        String StoredValue = myPrefs.getString(namefood, "");
        Log.i("namefoodliked:)))))))))", StoredValue);
    }
    /*methid to disliked food*/
    public void foodsDisLiked(String namefood) {
        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("likedfood", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.remove(namefood);
        edit.apply();
//        getAllSharedPreferences();
    }

//    public void getAllSharedPreferences(String name) {
//        SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences("likedfood", MODE_PRIVATE);
//        Set<String> itemIds = mSharedPreferences.getAll().keySet();
//        for (String itemId : itemIds) {
//            Log.i("getAll:::", "itemId:))))" + itemId);
//            if (itemId.contains(name)) {
//                Log.i("contains:::", ":))))" + itemId);
//                imgLike.setColorFilter(getApplication().getResources().getColor(R.color.colorPrimaryDark));
//                flagLike = true;
//
//            }
//        }
//    }

    @Override
    public void onBackPressed() {
        ItemAdapter_recycler_myanvade.flag_myanvade = false;
        ItemAdapter_recycler_behtarin_dastoor_pokht_ha.flag_behtarin_dastoor_pokht_ha = false;
        ItemAdapter_recycler_img.flag_img = false;
        AdapterSearch.flag_serch = false;
        AdapterGroupFoods.flag_group=false;
        AdapterLiked.flag_Liked=false;
        super.onBackPressed();
    }
}
