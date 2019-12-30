package com.example.sarashpaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sarashpaz.model.userApp;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Splash extends AppCompatActivity {

    userApp user = new userApp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                ////set true first time to SharedPreferences
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(Splash.this);
                user = sharedPreferencesManager.get_shared_preferences();
                if (user.getFirst_time_run() == true) {
                    Intent i=new Intent(Splash.this,SingUp.class);
                    startActivity(i);
                    finish();
//                    user.setFirst_time_run(true);
//                    sharedPreferencesManager.set_false_first_time(user);
                } else {
                    //////// false More than once to SharedPreference
                    Intent i=new Intent(Splash.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },3000);
    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
