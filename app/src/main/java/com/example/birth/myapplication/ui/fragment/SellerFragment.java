package com.example.birth.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.birth.myapplication.base.MyApplication;

/**
 * Created by birth on 2017/7/26.
 */

public class SellerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(MyApplication.getContext());
        tv.setText(getClass().getSimpleName());
        return tv;
    }
}
