package com.example.birth.myapplication.dagger2.component;

import com.example.birth.myapplication.dagger2.module.HomeModule;
import com.example.birth.myapplication.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by birth on 2017/7/26.
 */

@Component(modules = HomeModule.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
