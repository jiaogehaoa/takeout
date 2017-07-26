package com.example.birth.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.birth.myapplication.R;
import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.presenter.HomePresenter;
import com.example.birth.myapplication.ui.adapter.HomtAdapter;

/**
 * Created by birth on 2017/7/23.
 */

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView rv;
    HomePresenter homePresenter;
    private HomtAdapter homtAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(MyApplication.getContext())
                .inflate(R.layout.home_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rv = (RecyclerView) view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        homtAdapter = new HomtAdapter();
        rv.setAdapter(homtAdapter);
        homePresenter = new HomePresenter(this);
        homePresenter.requestHomeData();
    }

    public HomtAdapter getAdapter(){
        return homtAdapter;
    }
}
