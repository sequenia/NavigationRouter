package androidx.fragment.app;

public abstract class FragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener listener);

    public abstract Fragment findFragmentById(int id);

    public abstract int getBackStackEntryCount();

    public abstract void popBackStack();

    public abstract void popBackStack(String name, int flags);

    public FragmentTransaction beginTransaction() {
        throw new RuntimeException("Stub!");
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }
}