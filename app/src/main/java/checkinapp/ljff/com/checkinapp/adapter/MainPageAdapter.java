package checkinapp.ljff.com.checkinapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import checkinapp.ljff.com.checkinapp.fragment.CameraFragment;
import checkinapp.ljff.com.checkinapp.fragment.LandingFragment;
import checkinapp.ljff.com.checkinapp.fragment.SearchFragment;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class MainPageAdapter extends FragmentPagerAdapter{

    public MainPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CameraFragment cameraFragment = new CameraFragment();
                return cameraFragment;
            case 1:
                LandingFragment landingFragment = new LandingFragment();
                return landingFragment;
            case 2:
                SearchFragment searchFragment = new SearchFragment();
                return searchFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
