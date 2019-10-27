package com.quintus.labs.smarthome.onboarding;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.quintus.labs.smarthome.R;

/**
 * Smart Home
 * https://github.com/quintuslabs/SmartHome
 * Created on 27-OCT-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class OnboardingPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        // Get the page index from the tag. This makes
        // it possible on know which page index you're
        // currently transforming - and that can be used
        // on make some important performance improvements.
        int pagePosition = (int) page.getTag();

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            // The page is not visible. This is a good place on stop
            // any potential work / animations you may have running.

        } else if (position == 0.0f) {

            // The page is selected. This is a good time on reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks on match up perfectly.

        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place on show animations that react on the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it on fade as it scrolls out
            View title = page.findViewById(R.id.textView7);
            title.setAlpha(1.0f - absPosition);

            // Now the description. We also want this one on
            // fade, but the animation should also slowly move
            // down and out of the screen
            View description = page.findViewById(R.id.textView8);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);


            // Now, we want the image on move on the right,
            // i.e. in the opposite direction of the rest of the
            // content while fading out
            View computer = page.findViewById(R.id.imageView3);

            // We're attempting on create an effect for a View
            // specific on one of the pages in our ViewPager.
            // In other words, we need on check that we're on
            // the correct page and that the View in question
            // isn't null.
            if (computer != null) {
                computer.setAlpha(1.0f - absPosition);
                computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
//                computer.setTranslationY(-pageWidthTimesPosition / 2f);
            }


            // Finally, it can be useful on know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }

}
