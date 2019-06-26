package com.sequenia.navigation_router_sample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sequenia.navigation_router.NavigationRouterActivity;
import com.sequenia.navigation_router_sample.fragments.AddableFragment;
import com.sequenia.navigation_router_sample.fragments.ReplaceableFragment;

public class MainActivity extends NavigationRouterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationRouter.openScreen(AddableFragment.instance(
                        Color.CYAN,
                        "count" + navigationRouter.getScreenCount()
                ));
            }
        });
        findViewById(R.id.replace_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationRouter.openScreen(ReplaceableFragment.instance(
                        Color.RED,
                        "count" + navigationRouter.getScreenCount()
                ));
            }
        });
        findViewById(R.id.clear_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationRouter.closeAllScreens();
            }
        });

        final EditText positionEditText = findViewById(R.id.position);
        final CheckBox includeCheck = findViewById(R.id.include_check);
        findViewById(R.id.clear_to_position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationRouter.closeToScreen(
                        Integer.parseInt(positionEditText.getText().toString()),
                        includeCheck.isChecked());
            }
        });
    }

    @Override
    protected int getContainerId() {
        return R.id.content_container;
    }

    @Override
    protected Fragment openFirstScreen() {
        return AddableFragment.instance(Color.LTGRAY, "First");
    }

    @Override
    public void onScreenChanged(@Nullable Fragment fragment) {
        if (fragment != null) {
            Toast.makeText(this, fragment.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        }
    }
}