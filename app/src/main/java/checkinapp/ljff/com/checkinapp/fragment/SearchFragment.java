package checkinapp.ljff.com.checkinapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import checkinapp.ljff.com.checkinapp.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class SearchFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
}
