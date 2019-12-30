package com.example.sarashpaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Dastebandi extends AppCompatActivity {

    private ImageView imgBack;
    RelativeLayout ltSoup,ltmodern,ltsonaty,lttazeenat,ltdaneshjuee
            ,ltrejimi,ltnoshidani,lttorshi,ltdeser,ltmahali,ltsalad,ltcake,lttanaqolat,ltkoodak;

    private TextView txtsoup,txtmodern,txtsonaty,txttazeenat,txtdaneshjuee
            ,txtrejimi,txtnoshidani,txttorshi,txtdeser,txtmahali,txtsalad,txtcake,txttanaqolat,txtkoodak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dastebandi);


        ///set  item RelativeLayout click listener
        ltSoup=findViewById(R.id.ltsoup);
        txtsoup=findViewById(R.id.txtsoup);
        ltSoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtsoup.getText().toString();
            }
        });
        ltmodern=findViewById(R.id.ltmodern);
        txtmodern=findViewById(R.id.txtmodern);
        ltmodern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtmodern.getText().toString();
            }
        });
        ltsonaty=findViewById(R.id.ltsonati);
        txtsonaty=findViewById(R.id.txtsonati);
        ltsonaty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtsonaty.getText().toString();
            }
        });
        lttazeenat=findViewById(R.id.lttazeenat);
        txttazeenat=findViewById(R.id.txttazeenat);
        lttazeenat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txttazeenat.getText().toString();
            }
        });
        ltdaneshjuee=findViewById(R.id.ltdaneshjuee);
        txtdaneshjuee=findViewById(R.id.txtdaneshjuee);
        ltdaneshjuee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtdaneshjuee.getText().toString();
            }
        });
        ltrejimi=findViewById(R.id.ltrejimi);
        txtrejimi=findViewById(R.id.txtrejimi);
        ltrejimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtrejimi.getText().toString();
            }
        });
        ltnoshidani=findViewById(R.id.ltnushidani);
        txtnoshidani=findViewById(R.id.txtnushidani);
        ltnoshidani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtnoshidani.getText().toString();
            }
        });
        lttorshi=findViewById(R.id.lttorshi);
        txttorshi=findViewById(R.id.txttorshi);
        lttorshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txttorshi.getText().toString();
            }
        });
        ltdeser=findViewById(R.id.ltdeser);
        txtdeser=findViewById(R.id.txtdeser);
        ltdeser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtdeser.getText().toString();
            }
        });
        ltmahali=findViewById(R.id.ltmahali);
        txtmahali=findViewById(R.id.txtmahali);
        ltmahali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtmahali.getText().toString();
            }
        });
        ltsalad=findViewById(R.id.ltsalad);
        txtsalad=findViewById(R.id.txtsalad);
        ltsalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtsalad.getText().toString();
            }
        });
        ltcake=findViewById(R.id.ltcake);
        txtcake=findViewById(R.id.txtcake);
        ltcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtcake.getText().toString();
            }
        });
        lttanaqolat=findViewById(R.id.lttanaqolat);
        txttanaqolat=findViewById(R.id.txttanaqolat);
        lttanaqolat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txttanaqolat.getText().toString();
            }
        });
        ltkoodak=findViewById(R.id.ltkoodak);
        txtkoodak=findViewById(R.id.txtkoodak);
        ltkoodak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dastebandi.this, Menu.class));
                Menu.titleMenu=txtkoodak.getText().toString();
            }
        });
        ///////////back to home
        imgBack=findViewById(R.id.video_backhome);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
