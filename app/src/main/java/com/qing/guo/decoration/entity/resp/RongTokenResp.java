package com.qing.guo.decoration.entity.resp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dinghu on 2019/7/22.
 */
public class RongTokenResp {

    /**
     * code : 200
     * userId : jlk456j5
     * token : sfd9823ihufi
     */

    @SerializedName("code")
    private int code;
    @SerializedName("userId")
    private String userId;
    @SerializedName("token")
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
