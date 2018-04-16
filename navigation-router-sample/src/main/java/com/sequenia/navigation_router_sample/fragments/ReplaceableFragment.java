package com.sequenia.navigation_router_sample.fragments;

import android.support.v4.app.Fragment;

import com.sequenia.navigation_router.NavigationRouter;

public class ReplaceableFragment extends BaseFragment implements NavigationRouter.Replaceable {
    public static Fragment instance(int color, String text) {
        Fragment fragment = new ReplaceableFragment();
        return BaseFragment.instance(fragment, color, text + " \"replaceable fragment\"");
    }
}
