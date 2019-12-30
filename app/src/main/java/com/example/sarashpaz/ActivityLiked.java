package com.example.sarashpaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarashpaz.adapter.AdapterLiked;
import com.example.sarashpaz.model.LikedFoods;

import java.util.ArrayList;

public class ActivityLiked extends AppCompatActivity {

    GridView gridView;
    private ImageView imgBackHome;
    TextView txtTitle;
    private ArrayList<LikedFoods> likedFoods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /* Get object from xml file*/
        txtTitle = findViewById(R.id.txttitledastehbandi);
        txtTitle.setText("علاقه مندی ها");
        imgBackHome = findViewById(R.id.img_backdastehbandi);
        gridView= findViewById(R.id.grid_menu);

        /*back to dastebandi*/
        imgBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*set adapter to gridview */
        AdapterLiked adapter = new AdapterLiked(ActivityLiked.this, R.layout.item_menu, likedFoods);
        setFoodLiked();
        gridView.setAdapter(adapter);

    }
    /*method set item list grid*/
    public void setFoodLiked() {
        likedFoods.add(new LikedFoods("قیمه", R.drawable.myan1));
        likedFoods.add(new LikedFoods("قرمه", R.drawable.myan2));
        likedFoods.add(new LikedFoods("سبزی پلو ماهی", R.drawable.myan3));
        likedFoods.add(new LikedFoods("کباب برگ", R.drawable.myan4));
        likedFoods.add(new LikedFoods("جوجه کباب", R.drawable.myan5));
        likedFoods.add(new LikedFoods("فسنجون", R.drawable.myan6));
        likedFoods.add(new LikedFoods("کباب کوبیده", R.drawable.myan6));
        likedFoods.add(new LikedFoods("مرغ آلو", R.drawable.myan6));
        likedFoods.add(new LikedFoods("میرزا قاسمی", R.drawable.myan6));
        likedFoods.add(new LikedFoods("کشک بادمجون", R.drawable.myan6));
        likedFoods.add(new LikedFoods("کوکو", R.drawable.myan6));
        likedFoods.add(new LikedFoods("هویچ پلو", R.drawable.myan6));
    }
}
