package androidx.fragment.app;

import androidx.fragment.app.Fragment;

public abstract class FragmentTransaction {
    public abstract androidx.fragment.app.FragmentTransaction add(int containerViewId, Fragment fragment, String tag);

    public abstract androidx.fragment.app.FragmentTransaction replace(int containerViewId, Fragment fragment, String tag);

    public abstract androidx.fragment.app.FragmentTransaction addToBackStack(String name);

    public abstract int commit();
}