package com.example.zhaogaofei.lifecyletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.lifecyletest.view.FragmentTestActivity;
import com.example.zhaogaofei.lifecyletest.view.TestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_skip_test_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.start(MainActivity.this);
            }
        });

        findViewById(R.id.tv_skip_test_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTestActivity.start(MainActivity.this);
            }
        });
    }
}
