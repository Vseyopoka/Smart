package com.example.smart.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.smart.R;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Intent iHome = new Intent(IntroActivity.this,SignupActivity.class);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {

                startActivity(iHome);
                finish();
            }
        },3000);
    }
}