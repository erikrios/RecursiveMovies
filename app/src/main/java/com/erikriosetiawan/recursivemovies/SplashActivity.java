package com.erikriosetiawan.recursivemovies;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    final static int LOAD_TIME = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentMove = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMove);
                finish();
            }
        }, LOAD_TIME);
    }
}
