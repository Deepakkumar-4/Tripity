package com.example.tripity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.tripity.R;

public class viewPagerOnBoardingAdapter extends PagerAdapter {

    Context context;
    int[] images= {
            R.drawable.bboking,
            R.drawable.payment,
            R.drawable.ahmedabad_temple,
            R.drawable.exploring
    };

    int[] headings={

            R.string.onBoarding1,
            R.string.onBoarding2,
            R.string.onBoarding3,
            R.string.onBoarding4,

    };
    int[] description={

            R.string.Defination1,
            R.string.Defination2,
            R.string.Defination3,
            R.string.Defination4,
    };

    public viewPagerOnBoardingAdapter(Context context){

        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slidingHeading =(TextView) view.findViewById(R.id.titleHeading);
        TextView slidingDesc = (TextView) view.findViewById(R.id.titleDescription);
        slidetitleimage.setImageResource(images[position]);
        slidingHeading.setText(headings[position]);
        slidingDesc.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
