package com.quintus.labs.smarthome.onboarding;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.quintus.labs.smarthome.R;
import com.quintus.labs.smarthome.ui.activity.LoginActivity;

/**
 * Smart Home
 * https://github.com/quintuslabs/SmartHome
 * Created on 27-OCT-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.backgroungColor));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        makeStatusbarTransparent();
        viewPager = findViewById(R.id.onboarding_view_pager);
        onboardingAdapter = new OnboardingAdapter(this);
        viewPager.setAdapter(onboardingAdapter);
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());

    }


    // Listener for next button press
    public void nextPage(View view) {
        if (view.getId() == R.id.button2) {
            if (viewPager.getCurrentItem() < onboardingAdapter.getCount() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        }
    }

    private void makeStatusbarTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void finishPage(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
