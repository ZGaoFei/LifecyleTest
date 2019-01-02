package com.example.zhaogaofei.lifecyletest.lifecyle;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

/**
 * 使用Lifecycle的第二种方式
 *
 * 实现GenericLifecycleObserver，并实现onStateChanged方法
 *
 * 根据Lifecycle.Event返回的生命周期来区分，然后执行相应的代码
 */
public class TestLifeObserve1 implements GenericLifecycleObserver {

    @Override
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Log.e("zgf", "===TestLifeObserve1=====" + source.toString());
        Log.e("zgf", "====TestLifeObserve1====" + event.name());
    }
}
