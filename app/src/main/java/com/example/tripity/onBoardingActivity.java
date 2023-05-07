package com.example.tripity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tripity.Adapters.viewPagerOnBoardingAdapter;

public class onBoardingActivity extends AppCompatActivity {
    ViewPager sliderviewPager;
    LinearLayout dotlayout;
    Button skip, back, next;

    TextView[] dots;

    viewPagerOnBoardingAdapter viewPagerOnBoardingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        skip = findViewById(R.id.onBoardingSkip);
        back = findViewById(R.id.Back);
        next = findViewById(R.id.next);

        back.setVisibility(View.INVISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getItem(0)>0){
                    sliderviewPager.setCurrentItem(getItem(-1),true);
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0)<3){
                    sliderviewPager.setCurrentItem(getItem(1),true);
                }
                else {
                    Intent i = new Intent(onBoardingActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(onBoardingActivity.this, LoginActivity.class);
                startActivity(i);
                finish();

            }
        });


        sliderviewPager = findViewById(R.id.OnBoardingViewPager);
        dotlayout = findViewById(R.id.pageNumber);

        viewPagerOnBoardingAdapter = new viewPagerOnBoardingAdapter(this);
        sliderviewPager.setAdapter(viewPagerOnBoardingAdapter);

        setUpIndicator(0);
        sliderviewPager.addOnPageChangeListener(viewListener);

    }

    public void setUpIndicator(int position) {

        dots = new TextView[4];
        dotlayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);

            dots[i].setText(Html.fromHtml("."));

            dots[i].setTextSize(35);

            dots[i].setTextColor(getResources().getColor(R.color.grey, getApplicationContext().getTheme()));

            dotlayout.addView(dots[i]);


        }

        dots[position].setTextColor(getResources().getColor(R.color.main, getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);
            if (position > 0) {
                back.setVisibility(View.VISIBLE);
            } else {
                back.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i){
        return sliderviewPager.getCurrentItem() +i;
    }
}