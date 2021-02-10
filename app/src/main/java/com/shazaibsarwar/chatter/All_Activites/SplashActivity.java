package com.shazaibsarwar.chatter.All_Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shazaibsarwar.chatter.R;

public class SplashActivity extends AppCompatActivity {

    ImageView iv_top, iv_myLogo, iv_Bottom, iv_heart;
    TextView tv_myName, tv_NDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        getSupportActionBar().hide();

        iv_top = findViewById(R.id.iv_top);
        iv_Bottom = findViewById(R.id.iv_bottom);
        iv_myLogo = findViewById(R.id.iv_myLogo);
        tv_myName = findViewById(R.id.tv_name);
        iv_heart = findViewById(R.id.iv_heart);
        tv_NDescription = findViewById(R.id.tv_NDescription);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.top_wave);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.rotate);

        iv_top.setAnimation(animation1);
        iv_Bottom.setAnimation(animation2);
        tv_myName.setAnimation(animation1);
        tv_NDescription.setAnimation(animation2);
        iv_heart.setAnimation(animation3);






        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, EntringPhoneNo_Activity.class));
                finish();
            }
        }, 5000);

    }
}