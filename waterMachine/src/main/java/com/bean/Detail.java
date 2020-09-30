package com.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "wm_detail")
public class Detail {

    @Id
    private int id;

    private  int temperature;//水温

    private int capacity;//容量

    private int pressure;//水压

    @Column(name = "soak_time")
    private int soakTime;//浸泡时间

    private int  type;//冲泡方式 0扫码1称重2秘籍

    private int weight;//重量

    @Column(name = "thing_id")
    private int thingId;//冲泡物品id

    @Column(name = "thing_name")
    private String thingName;//冲泡物品名称

    private int num;//绑定数量

    private String water;//水类型

}
