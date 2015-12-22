package com.lyt.hi.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2015/12/22.
 */
public class HeadImage extends BmobObject {
    private String fileName;
    private String url;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
