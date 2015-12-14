package com.lyt.hi.app;

import android.app.Application;

import com.lyt.hi.adapter.HiViewPagerAdapter;
import com.lyt.hi.model.HiUser;

import java.net.PortUnreachableException;
import java.security.PublicKey;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2015/12/11.
 */
public class HiApplication extends Application {

    private static HiApplication hiApplication;

    public HiUser getHiUser() {
        return hiUser;
    }

    public void setHiUser(HiUser hiUser) {
        this.hiUser = hiUser;
    }

    private HiUser hiUser;
    @Override
    public void onCreate() {
        super.onCreate();
        hiApplication=new HiApplication();
        Bmob.initialize(this,"4cf735bb4c16f7154c215d8cc8439fc2");
    }
    public static HiApplication getInstance(){
        return hiApplication;
    }
}
