package com.example.tripity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenActivity extends AppCompatActivity {

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        auth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(auth.getCurrentUser() != null)
                {
                    Intent intent = new Intent(SplashScreenActivity.this , DashboardActivity.class);
                    startActivity(intent);
                    finish();

                }
                else {
                Intent intent = new Intent(SplashScreenActivity.this,onBoardingActivity.class);
                startActivity(intent);
                finish();
                }
            }
        },1800);

    }
}