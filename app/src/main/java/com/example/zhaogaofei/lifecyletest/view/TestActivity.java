package com.example.zhaogaofei.lifecyletest.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.zhaogaofei.lifecyletest.R;
import com.example.zhaogaofei.lifecyletest.lifecyle.TestActivityLifeObserve;
import com.example.zhaogaofei.lifecyletest.lifecyle.TestLifeObserve1;

public class TestActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, TestActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // 使用注解的方式
        getLifecycle().addObserver(new TestActivityLifeObserve());

        // 可以区分多个Activity/Fragment
        // getLifecycle().addObserver(new TestLifeObserve1());

        findViewById(R.id.tv_test_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 制造一个崩溃，崩溃后监听不要生命周期执行
                String string = null;
                int length = string.length();
                Log.e("zgf", "==========" + length);
            }
        });

        Log.e("zgf", "===TestActivity==onCreate======");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("zgf", "===TestActivity==onStart======");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("zgf", "===TestActivity==onResume======");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("zgf", "===TestActivity==onPause======");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("zgf", "===TestActivity==onStop======");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("zgf", "===TestActivity==onDestroy======");
    }
}
