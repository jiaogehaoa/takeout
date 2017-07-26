package com.example.birth.myapplication.biz;

import android.widget.Toast;

import com.example.birth.myapplication.base.Constant;
import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.model.net.bean.GoodsItemBean;
import com.example.birth.myapplication.model.net.bean.ItemBean;
import com.example.birth.myapplication.model.net.requestapi.HomeService;
import com.example.birth.myapplication.presenter.GoodsPresenter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by birth on 2017/7/26.
 */

public class RequestGoods {

    private GoodsPresenter goodsPresenter;

    public RequestGoods(GoodsPresenter goodsPresenter) {
        this.goodsPresenter = goodsPresenter;
    }

    public void requestGoods(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HomeService homeService = retrofit.create(HomeService.class);

        Call<ItemBean> goods = homeService.goods(goodsPresenter.getSellerId());

        goods.enqueue(new Callback<ItemBean>() {
            @Override
            public void onResponse(Call<ItemBean> call, Response<ItemBean> response) {
                ItemBean body = response.body();
                if(body !=null && "0".equals(body.code)){
                    Gson gson = new Gson();
                    List<GoodsItemBean> lists = gson.fromJson(body.data,
                            new TypeToken<List<GoodsItemBean>>() {}.getType());
                    goodsPresenter.setAdapterData(lists);

                }

            }

            @Override
            public void onFailure(Call<ItemBean> call, Throwable t) {

            }
        });

    }



}
