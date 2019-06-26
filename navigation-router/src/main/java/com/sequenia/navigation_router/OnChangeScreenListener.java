package com.sequenia.navigation_router;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Listener of {@link NavigationRouter} to track screen replacement
 */
public interface OnChangeScreenListener {
    /**
     * Triggered on when {@link NavigationRouter} replaces the screens
     *
     * @param fragment the fragment of the current screen
     */
    void onScreenChanged(@Nullable Fragment fragment);
}
