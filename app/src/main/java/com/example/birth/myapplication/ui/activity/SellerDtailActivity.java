package com.example.birth.myapplication.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.birth.myapplication.R;
import com.example.birth.myapplication.model.net.bean.Seller;
import com.example.birth.myapplication.presenter.GoodsPresenter;
import com.example.birth.myapplication.ui.adapter.SellerDetailAdapter;
import com.example.birth.myapplication.ui.fragment.AppraiseFragment;
import com.example.birth.myapplication.ui.fragment.GoodsFragment;
import com.example.birth.myapplication.ui.fragment.SellerFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class SellerDtailActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private Toolbar tBar;
    private ViewPager vpCon;
    private TabLayout tabNavi;

    GoodsPresenter goodsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_dtail);

        init();
        initView();
    }

    private void initView() {
        tabNavi = (TabLayout) findViewById(R.id.tab_navi);
        vpCon = (ViewPager) findViewById(R.id.vp_con);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new GoodsFragment());
        fragments.add(new AppraiseFragment());
        fragments.add(new SellerFragment());

        vpCon.setAdapter(new SellerDetailAdapter(getSupportFragmentManager(),fragments));
        tabNavi.setupWithViewPager(vpCon);
        vpCon.addOnPageChangeListener(this);
    }


    private void init() {
        Bundle extras = getIntent().getExtras();
        tBar = (Toolbar) findViewById(R.id.tbar);
        tBar.setTitle(extras.getString("name"));
        setSupportActionBar(tBar);

//        tBar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
//        tBar.setNavigationOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "pos:"+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
