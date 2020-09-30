package com.bean;


import lombok.Data;



@Data

public class WineCulture {

    private int id;

    private String title;//标题

    private String intro;//文本内容

    private int status;//发布状态

}
