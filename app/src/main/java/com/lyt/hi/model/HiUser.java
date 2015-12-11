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
    private String headImageUrl;
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

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
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
