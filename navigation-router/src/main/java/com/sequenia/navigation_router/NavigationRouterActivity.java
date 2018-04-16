package com.sequenia.navigation_router;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


/**
 * {@link AppCompatActivity Activity} with {@link NavigationRouter}
 */
public abstract class NavigationRouterActivity extends AppCompatActivity implements OnChangeScreenListener {
    protected NavigationRouter navigationRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationRouter = new NavigationRouter(this, getContainerId());
        if (savedInstanceState == null) {
            navigationRouter.openScreen(openFirstScreen());
        }
    }

    @Override
    public void finish() {
        super.finish();
        onActivityClose();
    }

    /**
     * Closes the current screen
     * and finishes the activity when the screens quantity equals 0 or 1
     */
    @Override
    public void onBackPressed() {
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
     * Closes the screen when activity is finished
     */
    private void onActivityClose() {
        Fragment fragment = navigationRouter.getCurrentScreen();
        if (fragment != null && fragment instanceof ScreenCloseable) {
            ((ScreenCloseable) fragment).onCloseScreen();
        }
    }
}
