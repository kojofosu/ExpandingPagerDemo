package com.mcdev.expandingpagerdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentFront extends Fragment {
    static final String ARG_TRAVEL = "ARG_TRAVEL";
    Travel travel;

    ImageView image;
    TextView title;

    public FragmentFront() {
    }

    public static FragmentFront newInstance(Travel travel) {
        Bundle args = new Bundle();
        FragmentFront fragmentFront = new FragmentFront();
        args.putParcelable(ARG_TRAVEL, travel);
        fragmentFront.setArguments(args);
        return fragmentFront;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            travel = args.getParcelable(ARG_TRAVEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_front, container, false);

        image = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);

        if (travel != null) {
            image.setImageResource(travel.getImage());
            title.setText(travel.getName());
        }
    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, Travel travel) {
        FragmentActivity activity = getActivity();
        ActivityCompat.startActivity(activity, InfoActivity.newInstance(activity, travel),
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity, new Pair<>(view, getString(R.string.transition_image)))
        .toBundle());
    }
}