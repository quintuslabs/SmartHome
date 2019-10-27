package com.quintus.labs.smarthome.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.quintus.labs.smarthome.R;
import com.quintus.labs.smarthome.onboarding.OnboardingActivity;

/**
 * Smart Home
 * https://github.com/quintuslabs/SmartHome
 * Created on 27-OCT-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class SplashScreenActivity extends AppCompatActivity {
    Animation animBounce, animZoomIn, animSlideIn;
    LinearLayout linearLayout;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.backgroungColor));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out);
        animBounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);

        linearLayout = findViewById(R.id.linear_layout);
        imageView = findViewById(R.id.image_view);

        linearLayout.startAnimation(animBounce);
        imageView.startAnimation(animZoomIn);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreenActivity.this, OnboardingActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        }, 3000);


    }
}
