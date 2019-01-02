package com.example.zhaogaofei.lifecyletest.lifecyle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.util.Log;

/**
 * 使用Lifecycle的第一种方式
 *
 * 添加对应的生命周期函数，给个函数加上对应的注解
 * 系统会自动生成相应的代码来实现
 */
public class TestActivityLifeObserve implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Log.e("zgf", "=====onCreate======");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {
        Log.e("zgf", "=====onStart======");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {
        Log.e("zgf", "=====onResume======");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause() {
        Log.e("zgf", "=====onPause======");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {
        Log.e("zgf", "=====onStop======");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy() {
        Log.e("zgf", "=====onDestroy======");
    }
}
