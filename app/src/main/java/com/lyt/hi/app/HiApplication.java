package com.lyt.hi.app;

import android.app.Application;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerBase;
import com.lyt.hi.adapter.HiViewPagerAdapter;
import com.lyt.hi.model.HiUser;
import com.orhanobut.logger.Logger;

import java.net.PortUnreachableException;
import java.security.PublicKey;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2015/12/11.
 */
public class HiApplication extends Application {

    private HiUser hiUser;
    private static HiApplication hiApplication;
    private AMapLocationClientOption aMapLocationClientOption;
    private LocationManagerBase locationClient;
    private AMapLocationListener aMapLocationListener;

    private AMapLocation aMapLocation;

    public AMapLocation getaMapLocation() {
        return aMapLocation;
    }

    public void setaMapLocation(AMapLocation aMapLocation) {
        this.aMapLocation = aMapLocation;
    }

    public HiUser getHiUser() {
        return hiUser;
    }

    public void setHiUser(HiUser hiUser) {
        this.hiUser = hiUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        hiApplication=new HiApplication();
        setUpLocation();
        Bmob.initialize(this,"4cf735bb4c16f7154c215d8cc8439fc2");
        Logger.init();

    }

    private void setUpLocation() {
        aMapLocationClientOption=new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setMockEnable(true);
        locationClient=new AMapLocationClient(this);
        locationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationListener=new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                setaMapLocation(aMapLocation);
            }
        };
        locationClient.setLocationListener(aMapLocationListener);
        locationClient.startLocation();
    }

    public static HiApplication getInstance(){
        return hiApplication;
    }
}
