package com.lyt.hi.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobGeoPoint;

/**
 * Created by Administrator on 2015/12/11.
 */
public class HiUser extends BmobUser {
    /**
     * 性别
     */
    private String Sex;
    /**
     * 头像
     */
    private HeadImage headImage;
    /**
     * 恋爱状况 单身/恋爱中/已婚
     */
    private String affairStates;
    /**
     * 自我介绍
     */
    private String briefIntro;

    /**
     * 当前位置
     */
    private BmobGeoPoint location;

    /**
     * 是否进行了个人信息设置
     */
    private boolean set=false;

    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public HeadImage getHeadImage() {
        return headImage;
    }

    public void setHeadImage(HeadImage headImage) {
        this.headImage = headImage;
    }

    public String getAffairStates() {
        return affairStates;
    }

    public void setAffairStates(String affairStates) {
        this.affairStates = affairStates;
    }

    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    public BmobGeoPoint getLocation() {
        return location;
    }

    public void setLocation(BmobGeoPoint location) {
        this.location = location;
    }
}
