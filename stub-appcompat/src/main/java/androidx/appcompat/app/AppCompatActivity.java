package androidx.appcompat.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class AppCompatActivity extends FragmentActivity {
    protected void onCreate(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    public void finish() {
        throw new RuntimeException("Stub!");
    }

    public void onBackPressed() {
        throw new RuntimeException("Stub!");
    }

    public FragmentManager getSupportFragmentManager() {
        throw new RuntimeException("Stub!");
    }
}