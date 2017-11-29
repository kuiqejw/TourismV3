package com.example.ongajong.tourismv3;

/**
 * Created by ongajong on 27/11/2017.
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LocateFrag tab1 = new LocateFrag();
                return tab1;
            case 1:

                AttractionFrag tab2 = new AttractionFrag();
                //TravelFrag tab2 = new TravelFrag();
                return tab2;
            case 2:
                WeatherFrag tab3 = new WeatherFrag();
                return tab3;
            case 3:
               TravelFrag tab4 = new TravelFrag();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}