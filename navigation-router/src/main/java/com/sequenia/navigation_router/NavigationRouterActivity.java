package com.sequenia.navigation_router;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;


/**
 * {@link AppCompatActivity Activity} with {@link NavigationRouter}
 */
public abstract class NavigationRouterActivity extends AppCompatActivity implements OnChangeScreenListener {
    /**
     * Handles the navigation of screens
     */
    protected NavigationRouter navigationRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationRouter = new NavigationRouter(this, getContainerId());
        if (savedInstanceState == null) {
            navigationRouter.openScreen(openFirstScreen());
        }
    }

    /**
     * Closes the current screen
     * and finishes the activity when the screens quantity equals 0 or 1
     */
    @Override
    public void onBackPressed() {
        onScreenClose();
        if (navigationRouter.getScreenCount() == 1 || navigationRouter.getScreenCount() == 0) {
            finish();
        } else {
            navigationRouter.closeCurrentScreen();
        }
    }

    @Override
    public void onScreenChanged(Fragment fragment) {}

    /**
     * Returns the id of the fragments container
     *
     * @return the id of the container
     */
    @IdRes
    protected abstract int getContainerId();

    /**
     * Returns the {@link Fragment} of the first screen
     *
     * @return {@link Fragment} of the first screen
     */
    protected abstract Fragment openFirstScreen();

    /**
     * Triggers when the screen is closing
     */
    private void onScreenClose() {
        Fragment fragment = navigationRouter.getCurrentScreen();
        if (fragment != null && fragment instanceof ScreenCloseable) {
            ((ScreenCloseable) fragment).onCloseScreen();
        }
    }
}
