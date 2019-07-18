package com.qing.guo.decoration.entity.resp;

import java.io.Serializable;

public class QActivity implements Serializable{


    /**
     * isNewRecord : false
     * id : 2
     * img : /file/upload/activity/20190627/201906271123441424.jpg
     * title : 测试sds
     * detail : 是多少
     * time : 2019-06-27 11:04:13
     * remark : 十点多
     */

    private boolean isNewRecord;
    private String id;
    private String img;
    private String title;
    private String detail;
    private String time;
    private String remark;

    public boolean isIsNewRecord() {
        return isNewRecord;
    }

    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
