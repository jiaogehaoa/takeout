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
import com.example.birth.myapplication.presenter.GoodsPresenter;
import com.example.birth.myapplication.ui.adapter.GoodsLeftAdapter;
import com.example.birth.myapplication.ui.adapter.GoodsRightAdapter;

/**
 * Created by birth on 2017/7/26.
 */

public class GoodsFragment extends Fragment {

    private int sellerId;
    private RecyclerView rvLeft;
    private RecyclerView rvRight;
    private GoodsPresenter goodsPresenter;
    private GoodsLeftAdapter goodsLeftAdapter;
    private GoodsRightAdapter goodsRightAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = LayoutInflater.from(getContext())
               .inflate(R.layout.goods_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle extras = getActivity().getIntent().getExtras();
        sellerId = extras.getInt("id");
        rvLeft = (RecyclerView) view.findViewById(R.id.rv_left);
        rvRight = (RecyclerView)view.findViewById(R.id.rv_right);
        rvLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRight.setLayoutManager(new LinearLayoutManager(getContext()));
        goodsLeftAdapter = new GoodsLeftAdapter();
        goodsRightAdapter = new GoodsRightAdapter();
        rvLeft.setAdapter(goodsLeftAdapter);
        rvRight.setAdapter(goodsRightAdapter);

        goodsPresenter = new GoodsPresenter(this);
        goodsPresenter.requestGoods();
    }




    public int getSellerId(){
        return sellerId;
    }

    public GoodsLeftAdapter getGoodsLeftAdapter(){
        return goodsLeftAdapter;
    }

    public GoodsRightAdapter getGoodsRightAdapter(){
        return goodsRightAdapter;
    }
}
