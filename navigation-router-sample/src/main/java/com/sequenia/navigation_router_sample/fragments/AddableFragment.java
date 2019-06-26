package com.sequenia.navigation_router_sample.fragments;

import androidx.fragment.app.Fragment;

import com.sequenia.navigation_router.NavigationRouter;

public class AddableFragment extends BaseFragment implements NavigationRouter.Addable {
    public static Fragment instance(int color, String text) {
        Fragment fragment = new AddableFragment();
        return BaseFragment.instance(fragment, color, text+" \"addable fragment\"");
    }
}
