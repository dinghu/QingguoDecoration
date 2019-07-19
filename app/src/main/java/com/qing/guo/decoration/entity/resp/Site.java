package com.qing.guo.decoration.entity.resp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dinghu on 2019/7/19.
 */
public class Site {

    /**
     * isNewRecord : false
     * id : 1
     * houseid : 1
     * housename : 得我d
     * teamid : 2
     * teamname : 查实的
     * province : 湖北
     * city : 武汉
     * district : 武昌
     * date : 2019-06-27 11:06:27
     * title : 测试
     * img : /file/upload/opration/20190627/201906271124331090.jpg
     * rate : 2019-06-27 11:06:32
     * detail : 是多少
     * amount : 1
     * type : 2
     * capital : 3
     * housetype : 4
     * houseamount : 5
     * opratetype : 6
     * time : 2019-06-27 11:06:41
     * remark : 的v
     */

    @SerializedName("isNewRecord")
    private boolean isNewRecord;
    @SerializedName("id")
    private String id;
    @SerializedName("houseid")
    private String houseid;
    @SerializedName("housename")
    private String housename;
    @SerializedName("teamid")
    private String teamid;
    @SerializedName("teamname")
    private String teamname;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("district")
    private String district;
    @SerializedName("date")
    private String date;
    @SerializedName("title")
    private String title;
    @SerializedName("img")
    private String img;
    @SerializedName("rate")
    private String rate;
    @SerializedName("detail")
    private String detail;
    @SerializedName("amount")
    private String amount;
    @SerializedName("type")
    private String type;
    @SerializedName("capital")
    private String capital;
    @SerializedName("housetype")
    private String housetype;
    @SerializedName("houseamount")
    private String houseamount;
    @SerializedName("opratetype")
    private String opratetype;
    @SerializedName("time")
    private String time;
    @SerializedName("remark")
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

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getHouseamount() {
        return houseamount;
    }

    public void setHouseamount(String houseamount) {
        this.houseamount = houseamount;
    }

    public String getOpratetype() {
        return opratetype;
    }

    public void setOpratetype(String opratetype) {
        this.opratetype = opratetype;
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
