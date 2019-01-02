package com.example.zhaogaofei.lifecyletest.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaogaofei.lifecyletest.R;
import com.example.zhaogaofei.lifecyletest.lifecyle.TestActivityLifeObserve;

public class TestFragment extends Fragment {

    public TestFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("zgf", "===TestFragment==onAttach======");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLifecycle().addObserver(new TestActivityLifeObserve());

        Log.e("zgf", "===TestFragment==onCreate======");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("zgf", "===TestFragment==onCreateView======");
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("zgf", "===TestFragment==onActivityCreated======");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e("zgf", "===TestFragment==onStart======");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("zgf", "===TestFragment==onResume======");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("zgf", "===TestFragment==onPause======");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("zgf", "===TestFragment==onStop======");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("zgf", "===TestFragment==onDestroyView======");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("zgf", "===TestFragment==onDestroy======");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("zgf", "===TestFragment==onDetach======");
    }
}
