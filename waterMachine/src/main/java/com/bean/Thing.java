package com.bean;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "wm_thing")
public class Thing {

    @Id
    private int id;

    private String thingName;//物品名称

    private int protein;//蛋白质

    private int fat;//热量

    private int cabohydrate;//碳水化合物

    private int sugar;//糖分

    private int heat;//热量
}
