package android.support.v4.app;

public abstract class FragmentTransaction {
    public abstract FragmentTransaction add(int containerViewId, Fragment fragment, String tag);

    public abstract FragmentTransaction replace(int containerViewId, Fragment fragment, String tag);

    public abstract FragmentTransaction addToBackStack(String name);

    public abstract int commit();
}