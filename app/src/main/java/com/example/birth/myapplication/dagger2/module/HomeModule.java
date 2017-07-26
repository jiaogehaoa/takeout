package com.example.birth.myapplication.dagger2.module;

import com.example.birth.myapplication.presenter.HomePresenter;
import com.example.birth.myapplication.ui.fragment.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by birth on 2017/7/26.
 */
@Module
public class HomeModule {
    private HomeFragment homeFragment;

    public HomeModule(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @Provides
    public HomePresenter provideHomePresenter(){
        return new HomePresenter(homeFragment);
    }
}
