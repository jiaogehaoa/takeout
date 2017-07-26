package com.example.birth.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.birth.myapplication.R;
import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.dagger2.component.DaggerHomeFragmentComponent;
import com.example.birth.myapplication.dagger2.module.HomeModule;
import com.example.birth.myapplication.presenter.HomePresenter;
import com.example.birth.myapplication.ui.adapter.HomeAdapter;

import javax.inject.Inject;


/**
 * Created by birth on 2017/7/23.
 */

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView rv;
    @Inject
    HomePresenter homePresenter;
    private HomeAdapter homeAdapter;
    private View llHeader;
    private float apha ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(MyApplication.getContext())
                .inflate(R.layout.home_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(view);
    }


    private void init(View view) {



        rv = (RecyclerView) view.findViewById(R.id.rv);
        llHeader = view.findViewById(R.id.ll_header);
        llHeader.setAlpha(0);
        rv.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        homeAdapter = new HomeAdapter();
        rv.setAdapter(homeAdapter);
//        homePresenter = new HomePresenter(this);
        DaggerHomeFragmentComponent.builder().homeModule(new HomeModule(this))
                .build().inject(this);

        homePresenter.requestHomeData();
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                apha+=dy;
                Log.i("##",dy+"");
                llHeader.setAlpha(apha/255);
            }
        });
    }



    public HomeAdapter getAdapter(){
        return homeAdapter;
    }
}
