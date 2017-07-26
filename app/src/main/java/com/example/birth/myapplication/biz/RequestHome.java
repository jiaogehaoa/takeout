package com.example.birth.myapplication.biz;

import android.widget.Toast;

import com.example.birth.myapplication.base.Constant;
import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.model.net.bean.HomeBean;
import com.example.birth.myapplication.model.net.bean.HomeItem;
import com.example.birth.myapplication.model.net.requestapi.HomeService;
import com.example.birth.myapplication.presenter.HomePresenter;
import com.example.birth.myapplication.ui.fragment.HomeFragment;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by birth on 2017/7/24.
 */

public class RequestHome {

    HomeFragment homeFragment;

    public RequestHome(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public void requestHome(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HomeService homeService =retrofit.create(HomeService.class);

        Call<HomeBean> home = homeService.home();

        home.enqueue(new Callback<HomeBean>() {



            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                HomeBean homeBean = response.body();

                if(homeBean!=null &&"0".equals(homeBean.code)){
                    Gson gson = new Gson();
                   HomeItem homeItem = gson.fromJson(homeBean.data, HomeItem.class);
                    homeFragment.getAdapter().setHomeItem(homeItem);
                }

            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                Toast.makeText(MyApplication.getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
