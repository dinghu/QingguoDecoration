package com.qing.guo.decoration.entity.req;

/**
 * Created by dinghu on 2019/7/22.
 */
public class RongTokenReq {

    public String userId;    //String	用户 Id，支持大小写英文字母、数字、部分特殊符号 + = - _ 的组合方式，最大长度 64 字节。是用户在 App 中的唯一标识，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
    public String name;//String	用户名称，最大长度 128 字节。用来在 Push 推送时显示用户的名称。（必传）
    public String portraitUri;//S
}
