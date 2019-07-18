package com.qing.guo.decoration.entity.resp;

import java.io.Serializable;

public class ProductDetail implements Serializable{
    public String id;    //String	Y	产品编号
    public String img;    //String	Y	产品图片地址
    public String title;    //String	Y	产品标题
    public String capital;    //String	Y	产品描述（营销软件，口碑营销等，用逗号分隔）
    public String detail;    //String	Y	产品正文（可能包含图片）

}
