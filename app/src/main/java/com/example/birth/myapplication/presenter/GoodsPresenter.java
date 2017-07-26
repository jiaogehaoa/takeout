package com.example.birth.myapplication.presenter;

import com.example.birth.myapplication.biz.RequestGoods;
import com.example.birth.myapplication.model.net.bean.GoodsItemBean;
import com.example.birth.myapplication.ui.fragment.GoodsFragment;

import java.util.List;

/**
 * Created by birth on 2017/7/26.
 */

public class GoodsPresenter {

    private GoodsFragment goodsFragment;
    private RequestGoods requestGoods;

    public GoodsPresenter(GoodsFragment goodsFragment) {
        this.goodsFragment = goodsFragment;
        this.requestGoods = new RequestGoods(this);
    }


    public void requestGoods(){
        requestGoods.requestGoods();
    }

    public int getSellerId(){
        return goodsFragment.getSellerId();
    }

    public void setAdapterData(List<GoodsItemBean> lists){
        goodsFragment.getGoodsLeftAdapter().setAdapterData(lists);
        goodsFragment.getGoodsRightAdapter().setAdapterData(lists);
    }

}
