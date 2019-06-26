package com.sequenia.navigation_router_sample.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sequenia.navigation_router_sample.R;


public class BaseFragment extends Fragment {
    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    private static final String EXTRA_TEXT = "EXTRA_TEXT";

    protected static Fragment instance(Fragment fragment, int color, String text) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_COLOR, color);
        args.putString(EXTRA_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView) view.findViewById(R.id.fragment_text)).setText(getArguments().getString(EXTRA_TEXT));
        view.setBackgroundColor(getArguments().getInt(EXTRA_COLOR));
        //set alpha for displaying of addable and replaceable fragments
        view.setAlpha(0.3f);
    }
}
