package com.mcdev.expandingpagerdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qslll.library.fragments.ExpandingFragment;

public class TravelExpandingFragment extends ExpandingFragment {
    static final String ARG_TRAVEL = "ARG_TRAVEL";
    Travel travel;

    public TravelExpandingFragment() {
        // Required empty public constructor
    }

    public static TravelExpandingFragment newInstance(Travel travel) {
        TravelExpandingFragment fragment = new TravelExpandingFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TRAVEL, travel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            travel = args.getParcelable(ARG_TRAVEL);
        }
    }

    /*
    *include TopFragment
    * @return
    * */
    @Override
    public Fragment getFragmentTop() {
        return FragmentFront.newInstance(travel);
    }

    /*include BottomFragment*/
    @Override
    public Fragment getFragmentBottom() {
        return FragmentBottom.newInstance();
    }
}