package com.example.zhaogaofei.lifecyletest.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.lifecyletest.R;

public class FragmentTestActivity extends AppCompatActivity {
    private TestFragment fragment;

    public static void start(Context context) {
        context.startActivity(new Intent(context, FragmentTestActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        addFragment();

        findViewById(R.id.tv_test_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }

    private void addFragment() {
        fragment = new TestFragment();
        getSupportFragmentManager().beginTransaction().add(fragment, "test_fragment").commit();
    }

    private void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}
