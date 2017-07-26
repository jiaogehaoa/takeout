package com.example.birth.myapplication.presenter;

import com.example.birth.myapplication.biz.RequestHome;
import com.example.birth.myapplication.ui.fragment.HomeFragment;

/**
 * Created by birth on 2017/7/24.
 */

public class HomePresenter {

    RequestHome requestHome;
    HomeFragment homeFragment;
    public HomePresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        this.requestHome = new RequestHome(homeFragment);
    }


    public void requestHomeData(){
        requestHome.requestHome();

    }
}
