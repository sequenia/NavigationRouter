package android.support.v7.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

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