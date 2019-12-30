package com.example.sarashpaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarashpaz.adapter.ItemAdapter_recycler_behtarin_dastoor_pokht_ha;
import com.example.sarashpaz.adapter.ItemAdapter_recycler_img;
import com.example.sarashpaz.adapter.ItemAdapter_recycler_myanvade;
import com.example.sarashpaz.adapter.SlidingImage_Adapter;
import com.example.sarashpaz.model.ImageModel;
import com.example.sarashpaz.model.Item_recycler_behtarin_dastoor_pokht_ha;
import com.example.sarashpaz.model.Item_recycler_img;
import com.example.sarashpaz.model.Item_recycler_myanvade;
import com.example.sarashpaz.model.userApp;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    userApp user = new userApp();
    ImageView imgMenu,imgHomeMenu,imgListMenu;
    DrawerLayout myDraw;
    TextView txthistory, video, userName, txtBackHome,txtFavorit,about,call_me;
    BottomNavigationView bottomNav;
    MediaPlayer music;
    ImageView btn_play;
    Boolean flag_play = false;
    public static boolean flag_Dasteh,flag_Search=false;

    //for image slider
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};

    //for recycler myanvade
    RecyclerView recyclerView, recyclerView2, recyclerView3;
    List<Item_recycler_myanvade> mItem = new ArrayList<>();
    ItemAdapter_recycler_myanvade mAdapter;

    //for recycler behtarin_dastoor_pokht_ha
    List<Item_recycler_behtarin_dastoor_pokht_ha> newItem = new ArrayList<>();
    ItemAdapter_recycler_behtarin_dastoor_pokht_ha mAdapter2;

    //for recycler img
    List<Item_recycler_img> mItem33 = new ArrayList<>();
    ItemAdapter_recycler_img mAdapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for music*/
        music = MediaPlayer.create(MainActivity.this, R.raw.music);
        music.start();
        music.setLooping(true);
        btn_play = findViewById(R.id.img_music);
        btn_play.setImageResource(R.drawable.ic_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag_play) {
                    btn_play.setImageResource(R.drawable.ic_pause);
                    music.pause();
                    flag_play = true;
                } else {
                    btn_play.setImageResource(R.drawable.ic_play);
                    music.start();
                    flag_play = false;

                }

            }
        });

        /*end music*/
        //==============open draw=============================
        imgMenu = findViewById(R.id.img_menu);
        myDraw = findViewById(R.id.myDraw);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDraw.openDrawer(Gravity.RIGHT);
            }
        });

        //for image slider
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();
        init();

        //for recycler myanvade
        recyclerView = findViewById(R.id.recycler_view_myanvade);
        mAdapter = new ItemAdapter_recycler_myanvade(mItem, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView myList = findViewById(R.id.recycler_view_myanvade);
        myList.setLayoutManager(layoutManager);
        setDeta();
        recyclerView.setNestedScrollingEnabled(true);

        //for recycler behtarin_dastoor_pokht_ha
        recyclerView2 = findViewById(R.id.recycler_view_bartarinDastoorPokht);
        mAdapter2 = new ItemAdapter_recycler_behtarin_dastoor_pokht_ha(newItem, this);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.setAdapter(mAdapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView myList2 = findViewById(R.id.recycler_view_bartarinDastoorPokht);
        myList2.setLayoutManager(layoutManager2);
        setDeta2();
        recyclerView2.setNestedScrollingEnabled(true);

        //for recycler img
        recyclerView3 = findViewById(R.id.recycler_view_img);
        mAdapter3 = new ItemAdapter_recycler_img(mItem33, this);
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(getApplicationContext());
        recyclerView3.setLayoutManager(mLayoutManager3);
        recyclerView3.setAdapter(mAdapter3);
        setDeta3();
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView myList3 = findViewById(R.id.recycler_view_img);
        myList3.setLayoutManager(layoutManager3);
        //for bottom navigation
        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.item_home);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_dastebandi:
                        startActivity(new Intent(MainActivity.this,Dastebandi.class));
                        flag_Dasteh=true;
                        return true;
                    case R.id.item_home:

                        return true;
                    case R.id.item_search:
                        startActivity(new Intent(MainActivity.this, Search.class));
                        flag_Search=true;
                        return true;
                }
                return false;
            }
        });

        ///////// set menumodel UserName
        userName = findViewById(R.id.username);
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("userdetails", MODE_PRIVATE);
        String StoredValue = myPrefs.getString("username", "");
        userName.setText(StoredValue);

        //////////////click  to back home txt
        txtBackHome = findViewById(R.id.txt_home);
        txtBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDraw.closeDrawers();
            }
        });
        //////////////click  to back home img
        imgHomeMenu= findViewById(R.id.img_home_menu);
        imgHomeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDraw.closeDrawers();
            }
        });
        //txt for go to history
        txthistory = findViewById(R.id.txt_history);
        txthistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, history.class));
            }
        });
        ////// go to favorit
        txtFavorit = findViewById(R.id.txt_favorite);
        txtFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityLiked.class));
            }
        });

        //img for go to history
        imgListMenu=findViewById(R.id.img_history);
        imgListMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Dastebandi.class));
            }
        });
        //for go to video Menu
        video = findViewById(R.id.text_video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Menuvideo.class));
            }
        });
        //for goto about
        about = findViewById(R.id.text_about);



    }



    //for image slider
    private ArrayList<ImageModel> populateList() {

        ArrayList<ImageModel> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }

    private void init() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, imageModelArrayList));
        CirclePageIndicator indicator = findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    //for recycler myanvade
    private void setDeta() {
        mItem.add(new Item_recycler_myanvade(R.drawable.myan1, "پنیر روستایی و میوه"));
        mItem.add(new Item_recycler_myanvade(R.drawable.myan2, "ترکیبی از آجیل و میوه جات خشک شده خانگی"));
        mItem.add(new Item_recycler_myanvade(R.drawable.myan3, "لقمه بوقلمون، آووکادو و حمص"));
        mItem.add(new Item_recycler_myanvade(R.drawable.myan4, "اسموتی سبز غنی از پروتئین"));
        mItem.add(new Item_recycler_myanvade(R.drawable.myan5, "نخود سرخ کرده"));
        mItem.add(new Item_recycler_myanvade(R.drawable.myan6, "دسر ماست یونانی"));
        mAdapter.notifyDataSetChanged();
    }

    //for recycler behtarin_dastoor_pokht_ha
    private void setDeta2() {
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img1, "kala1"));
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img2, "kala2"));
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img3, "kala3"));
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img4, "kala4"));
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img5, "kala5"));
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img6, "kala6"));
        newItem.add(new Item_recycler_behtarin_dastoor_pokht_ha(R.drawable.img7, "kala7"));
        mAdapter2.notifyDataSetChanged();
    }

    //for recycler img
    private void setDeta3() {
        mItem33.add(new Item_recycler_img(R.drawable.img1));
        mItem33.add(new Item_recycler_img(R.drawable.img2));
        mItem33.add(new Item_recycler_img(R.drawable.img3));
        mItem33.add(new Item_recycler_img(R.drawable.img4));
        mItem33.add(new Item_recycler_img(R.drawable.img5));
        mItem33.add(new Item_recycler_img(R.drawable.img6));
        mItem33.add(new Item_recycler_img(R.drawable.img7));
        mAdapter3.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if(myDraw.isDrawerOpen(GravityCompat.START)){
            myDraw.closeDrawers();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.release();
    }

    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
