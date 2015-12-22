package com.lyt.hi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.lyt.hi.R;
import com.lyt.hi.adapter.HiViewPagerAdapter;
import com.lyt.hi.fragment.ExploreFragment;
import com.lyt.hi.fragment.MainFragment;
import com.lyt.hi.fragment.MsgFragment;
import com.lyt.hi.fragment.ProfileFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.hi_viewpager)
    ViewPager hiViewpager;
    @Bind(R.id.hi_tablayout)
    TabLayout hiTablayout;
    /**
     * 定位客户端
     */
    AMapLocationClient locationClient;
    /**
     * 定位结果监听
     */
    AMapLocationListener aMapLocationListener;
    AMapLocationClientOption aMapLocationClientOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();

        getLocation();

    }

    /**
     * 获取定位结果
     */
    private void getLocation() {

    }

    private void initUI() {
        setSupportActionBar(toolbar);
        hiTablayout.addTab(hiTablayout.newTab().setText("主页").setIcon(getResources().getDrawable(R.drawable.tab_home_selector)));
        hiTablayout.addTab(hiTablayout.newTab().setText("消息").setIcon(getResources().getDrawable(R.drawable.tab_msg_selector)));
        hiTablayout.addTab(hiTablayout.newTab().setText("发现").setIcon(getResources().getDrawable(R.drawable.tab_explore_selector)));
        hiTablayout.addTab(hiTablayout.newTab().setText("我").setIcon(getResources().getDrawable(R.drawable.tab_person_selector)));
        hiTablayout.setTabTextColors(getResources().getColor(R.color.textcolor), getResources().getColor(R.color.colorPrimary));

        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(MainFragment.newInstance("",""));
        fragments.add(MsgFragment.newInstance("",""));
        fragments.add(ExploreFragment.newInstance("", ""));
        fragments.add(ProfileFragment.newInstance("", ""));
        HiViewPagerAdapter pagerAdapter=new HiViewPagerAdapter(getSupportFragmentManager(),fragments);
        hiViewpager.setAdapter(pagerAdapter);
        hiViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(hiTablayout));

        hiTablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(hiViewpager));
    }


}
