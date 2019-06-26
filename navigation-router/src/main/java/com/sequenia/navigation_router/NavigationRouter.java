package com.sequenia.navigation_router;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.OnBackStackChangedListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

/**
 * This class handles the navigation of screens
 */
public class NavigationRouter implements Cloneable {
    /**
     * A marker interface through which the router will attach the fragment via
     * {@link FragmentTransaction#add(int, Fragment, String)}
     *
     * @see Replaceable
     */
    public interface Addable {}

    /**
     * A marker interface through which the router will attach the fragment via
     * {@link FragmentTransaction#replace(int, Fragment, String)}
     *
     * @see Addable
     */
    public interface Replaceable {}

    private static final String TRANSACTION_NUMBER = "TRANSACTION_NUMBER_";

    private final int containerId;
    private WeakReference<OnChangeScreenListener> wrChangeScreenListener;
    private FragmentManager fragmentManager;

    private int screenCount = 0;

    /**
     * Initialization of {@link NavigationRouter}
     *
     * @param activity    activity for providing FragmentManager and OnChangeScreenListener behavior
     * @param containerId container identifier of frame layout
     */
    public NavigationRouter(AppCompatActivity activity, int containerId) {
        this.containerId = containerId;

        wrChangeScreenListener = new WeakReference<>(activity instanceof OnChangeScreenListener ?
                (OnChangeScreenListener) activity : null);

        fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(new OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                OnChangeScreenListener screenListener = wrChangeScreenListener.get();
                if (screenListener != null) {
                    screenListener.onScreenChanged(
                            fragmentManager.findFragmentById(NavigationRouter.this.containerId));
                }
            }
        });

        screenCount = fragmentManager.getBackStackEntryCount();
    }

    /**
     * Opens the screen by fragment and added that fragment to the stack
     *
     * @param fragment {@link Fragment} of the screen
     */
    public void openScreen(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment instanceof Addable) {
            transaction.add(containerId, fragment, getTagByPosition(screenCount));
        } else {
            transaction.replace(containerId, fragment, getTagByPosition(screenCount));
        }
        transaction.addToBackStack(getNextTag())
                .commit();
        screenCount += 1;
    }

    /**
     * Removes current screen from the stack of screens
     *
     * @see #closeAllScreens()
     * @see #closeCurrentScreen()
     */
    public void closeCurrentScreen() {
        if (getScreenCount() > 1) {
            fragmentManager.popBackStack();
            screenCount -= 1;
        }
    }

    /**
     * Removes all screens until the screen by the position
     * inclusive or exclusive from the stack of screens
     *
     * @param position        the position of the screen
     * @param includePosition true - removes all screens include the screen by the position, otherwise removes without it
     * @see #closeAllScreens()
     * @see #closeCurrentScreen()
     */
    public void closeToScreen(int position, boolean includePosition) {
        if ((position + (includePosition ? 1 : 0)) < screenCount) {
            String transactionTag = getTagByPosition(position);
            fragmentManager.popBackStack(transactionTag,
                    includePosition ? POP_BACK_STACK_INCLUSIVE : 0);
            screenCount -= screenCount - (includePosition ? 0 : 1) - position;
        }
    }

    /**
     * Removes all screen inclusive from the stack of screens
     *
     * @see #closeToScreen(int, boolean)
     */
    public void closeAllScreens() {
        fragmentManager.popBackStack(null, POP_BACK_STACK_INCLUSIVE);
        screenCount = 0;
    }

    /**
     * Returns current fragment of the fragments container
     *
     * @return {@link Fragment}
     */
    public Fragment getCurrentScreen() {
        return fragmentManager.findFragmentById(containerId);
    }

    /**
     * Returns current quantity of screens
     *
     * @return quantity of screens
     */
    public int getScreenCount() {
        return screenCount;
    }

    /**
     * Returns the transaction tag by the position
     *
     * @param position the position of the screen
     * @return {@link String} of the transaction tag
     * @see #getNextTag()
     */
    private String getTagByPosition(int position) {
        return TRANSACTION_NUMBER + position;
    }

    /**
     * Returns the transaction tag of the next screen
     *
     * @return {@link String} of the transaction tag
     * @see #getTagByPosition(int)
     */
    private String getNextTag() {
        return getTagByPosition(getScreenCount());
    }
}